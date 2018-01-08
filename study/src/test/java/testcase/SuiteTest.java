package testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author: zhull
 * <P>date: 2018/1/8</P>
 * <P>description: 测试套件</P>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {TestCase2.class, TestCase1.class})
public class SuiteTest {

}
