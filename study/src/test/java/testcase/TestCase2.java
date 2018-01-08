package testcase;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author: zhull
 * <P>date: 2018/1/8</P>
 * <P>description: 测试timeout，ignore</P>
 */
public class TestCase2 {

    /**
     * 如果test case执行时间大于timeout则失败。
     */
    @Test(timeout = 1000)
    public void testTimeout() throws InterruptedException {
        System.out.println("testTimeout");
        /**
         * failed
         */
//        Thread.sleep(5000);
        /**
         * passed
         */
        Thread.sleep(999);
    }

    /**
     * 该测试方法不会执行
     */
    @Ignore
    public void testIgnore() {
        System.out.println("this is ignored");
    }
}
