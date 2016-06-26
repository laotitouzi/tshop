package com.tshop.redis;

import java.io.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisClientTemplate")
public class RedisClientTemplate implements Serializable {
    private static final Log log = LogFactory.getLog(RedisClientTemplate.class);
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public void disconnect() {
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        shardedJedis.disconnect();
    }

    public <T> T execute(RedisCallBack<T> callback) {
        ShardedJedis jedis = null;
        boolean broken = false;
        try {

            jedis = shardedJedisPool.getResource();
            return callback.call(jedis);
        } catch (Exception e) {
            broken = true;
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                if (broken) {
                    shardedJedisPool.returnBrokenResource(jedis);
                } else {
                    shardedJedisPool.returnResource(jedis);
                }
            }
        }
        return null;
    }

    /*	public String set(final String key, final String value) {
            return this.execute(new RedisCallBack<String>() {
                @Override
                public String call(ShardedJedis jedis) {
                    String result = jedis.set(key, value);
                    return result;
                }

            });
        }*/
    private static byte[] serialize(Object value) {
        if (value == null) {
            return null;
        }
        byte[] result = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            result = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            try {
                if (os != null)
                    os.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    private static Object deserialize(byte[] in) {
        Object result = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                result = (Object) is.readObject();
                is.close();
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public Object set(final String key, final Object value, final int second) {
        return this.execute(new RedisCallBack<Long>() {
            @Override
            public Long call(ShardedJedis jedis) {
                Long result = jedis.hset( key.getBytes(), "".getBytes(),serialize(value));
                jedis.expire(key.getBytes(), second);
                return result;
            }

        });
    }

    /**
     * @param key
     * @return
     */
    public Object get(final String key) {
        return this.execute(new RedisCallBack<Object>() {
            @Override
            public Object call(ShardedJedis jedis) {
                byte[] result = jedis.hget( key.getBytes(),"".getBytes());
                return deserialize(result);
            }
        });
    }

	/*public String putSession(final String sessionKey, final RedisHttpSession session, final int timeOut) {
        return this.execute(new RedisCallBack<String>() {
			@Override
			public String call(ShardedJedis jedis) {
				return jedis.setex(sessionKey.getBytes(), timeOut, SeesionSerializer.serialize(session));
			}
		});
	}

	public String setex(final String key, final String value) {
		return this.execute(new RedisCallBack<String>() {
			@Override
			public String call(ShardedJedis jedis) {
				return jedis.setex(key.getBytes(), 1, value.getBytes());
			}
		});
	}
	
	public RedisHttpSession getSession(final String sessionKey) {
		return this.execute(new RedisCallBack<RedisHttpSession>() {
			@Override
			public RedisHttpSession call(ShardedJedis jedis) {
				byte[] sessionByte = jedis.get(sessionKey.getBytes());
				return SeesionSerializer.deserialize(sessionByte);
			}
		});
	}*/

    public void deleteSession(final String sessionKey) {
        this.execute(new RedisCallBack<String>() {

            @Override
            public String call(ShardedJedis jedis) {
                jedis.del(sessionKey);
                return null;
            }
        });
    }
}