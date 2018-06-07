package remote.exec;

/**
 * @author zhull
 * @date 2018/6/7
 * <P>为了多次载入执行类而加入的加载器</P>
 * 开放defineClass方法，由虚拟机调用时，仍用双亲委派规则loadClass进行类加载
 */
public class HotSwapClassLoader extends ClassLoader {

    /**
     * 创建父 类加载器
     */
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    /**
     * 显示调用才使用的方法。
     * @param classByte
     * @return
     */
    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
