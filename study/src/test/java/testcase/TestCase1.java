package testcase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author: zhull
 * <P>date: 2017/12/29</P>
 * <P>description: 学习测试用例</P>
 * 1、@BeforeClass
 *      所修饰的方法在所有方法加载前执行，而且他是静态的在类加载后就会执行该方法，
 *      在内存中只有一份实例，适合用来加载配置文件。
 * 2、@AfterClass
 *      所修饰的方法在所有方法执行完毕之后执行，通常用来进行资源清理，例如关闭数据库连接。
 * 3、@Before和@After在每个测试方法执行前都会执行一次。
 */
public class TestCase1 {

    @Test
    public void testAssertEquals() {
        System.out.println("testAssertEquals");
        assertEquals(2, 2);
    }

    @Test
    public void testAssertTrue() {
        System.out.println("testAssertTrue");
        assertTrue(2==2);
    }


}
