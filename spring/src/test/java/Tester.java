import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.bjpowernode.dao.ProductDao;
import com.bjpowernode.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Tester {
    // 读取配置文件，获得工厂实例
    BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");

    /*public void test00() {
        //ProductDao productDao = new ProductDaoImpl();
        // 通过工厂对象获取实例
        //ProductDao productDao = (ProductDao)factory.getBean("productDao");// 根据唯一标识获取实例
        // 根据类型智能匹配
        ProductDao productDao = factory.getBean(ProductDao.class);
        productDao.save();
    }
    @Test
    public void test01() {
        ProductService productService = factory.getBean(ProductService.class);
        productService.save();
    }*/

    @Test
    public void test02() throws SQLException {
        // dataSource: 连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test03() throws SQLException {
        ProductService service = factory.getBean(ProductService.class);
        List list = service.queryList();
        System.out.println(list);
    }
}
