package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.security.interfaces.RSAKey;

/**
 * Mybatis 工具类
 * @author
 * @version
 * @since
 */
public class SqlSessionUtil {
    // 工具类的构造方法一般都是私有化的
    // 工具类中所以的方法都是静态的，直接采用类名即可调用。不需要new对象
    // 为了防止new对象，构造方法私有化
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    // 类加载时执行
    // SqlSessionUtil工具类在进行第一次加载的时候，解析mybatis-config.xml文件。创建SqlSessionFactory对象
    static {
        try{
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("com/mybatis-config.xml"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象。
     * @return 会话对象
     */

    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
