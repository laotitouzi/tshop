import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.tshop.page.*;
import com.tshop.entity.Product;
import com.tshop.service.ProductService;
import com.tshop.dao.ProductMapper;


/*
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
 * transactionManager的默认取值是"transactionManager"，
 * defaultRollback的默认取值是true，当然，你也可以改成false。
 * true表示测试不会对数据库造成污染,false的话当然就会改动到数据库中了。
 * 在方法名上添加@Rollback(false)表示这个测试用例不需要回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class ProductServiceTest {
    private static Object id;
    @Autowired
    private ProductService productService;


    @Test
    public void testAdd() {
        try {
            Product product = new Product();
            product.setCategoryId("1");
            product.setDescription("我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇我的电风扇");
            product.setDiscount(new BigDecimal(100));
            product.setProductName("我的电风扇");
            product.setPrice(new BigDecimal(100));
            productService.addProduct(product);
            id = product.getId();
            System.out.println("-testAdd-----id---------" + id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testList() {
        try {
            Criteria criteria = new Criteria();
            criteria.put("productName", "我的电风扇");
            List<Product> products = productService.queryProductForList(criteria);
            for (Product e : products) {
                System.out.println(e.getId());
                System.out.println(e.getDescription());
            }

            System.out.println("----testList----------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testDel() {
        try {
            id = 2;
           int record = productService.deleteProductById(id);
            System.out.println("---testDel record: "+ record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPage() {
        Criteria criteria = new Criteria();
        criteria.setPageSize(1);
        criteria.setCurrentPage(1);
        criteria.put("productName", "我的电风扇4444");
        Page p = productService.queryProductForPage(criteria);

        System.out.println("pagsize："+p.getPageSize());

        System.out.println("totalPage："+p.getTotalPage());

        List<Product> list = p.getList();
        for (Product product : list) {
            System.out.println(product.getId());
        }
    }
}
