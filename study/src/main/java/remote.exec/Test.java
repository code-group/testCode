package remote.exec;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhull
 * @date 2018/6/7
 * <P>测试类</P>
 */
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("/Users/zhull/IdeaProjects/testCode/study/target/classes/Anything.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();

        System.out.println(JavaClassExecuter.execute(b));
    }
}
