package com.tshop.redis;

import redis.clients.jedis.ShardedJedis;

public interface RedisCallBack<T> {
	public T call(ShardedJedis jedis);
}