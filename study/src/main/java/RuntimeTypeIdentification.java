import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhull
 * @date 2018/1/19</P>
 * <P>description: 运行期类型鉴定</P>
 * newInstance: 弱类型。低效率。只能调用无参构造。在没有对象的情况下可以创建一个新对象
 * new: 强类型。相对高效。能调用任何public构造。
 *
 */
public class RuntimeTypeIdentification {

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("FancyToy");
        } catch(ClassNotFoundException e) {}
        printInfo(c);

        Class[] faces = c.getInterfaces();
        for(int i = 0; i < faces.length; i++)
            printInfo(faces[i]);

        Class cy = c.getSuperclass();
        Object o = null;
        try {
            // Requires default constructor:
            o = cy.newInstance(); // (*1*)
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(o.getClass());

        Object o1 = null;
        try {
            Constructor<Toy> constructor = Toy.class.getConstructor();
            o1 = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        printInfo(o1.getClass());
    }
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
    }

    public static void test() {
        Boolean b2 = false;
        System.out.println(Boolean.class.isInstance(b2));
        System.out.println(b2 instanceof Boolean);
        System.out.println(Boolean.class == b2.getClass());
        System.out.println(boolean.class == b2.getClass());
    }
}

interface HasBatteries {
}

interface Waterproof {
}

interface ShootsThings {
}

class Toy {
    // (*1*)
    public Toy() {
        // 对于Constructor<Toy> constructor = Toy.class.getConstructor();需要将构造方法设为public的，不然找不到
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, ShootsThings {
    FancyToy() {
        super(1);
    }
}
