package remote.exec;

import java.lang.reflect.Method;

/**
 * @author zhull
 * @date 2018/6/7
 * <P>JavaClass执行工具</P>
 */
public class JavaClassExecuter {

    /**
     * 将输入类的byte数组中代表java.lang.System的CONSTANT_Utf8_info常量改为劫持后的HackSystem
     * @param classByte
     * @return
     */
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "remote/exec/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[] {String[].class});
            method.invoke(null, new String[] { null });
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }

        return HackSystem.getBufferString();
    }
}
