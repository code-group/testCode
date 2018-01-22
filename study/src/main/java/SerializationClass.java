import java.io.*;
import java.util.Date;

/**
 * @author zhull
 * @date 2018/1/18</P>
 * <P>description: 对象序列化</P>
 * 由于Externalizable 对象默认时不保存它的任何字段，所以transient 关键字只能伴随Serializable 使
 * 用。<br/>
 * 类实现了Externalizable 接口，在writeExternal()方法里定义了哪些属性可以序列化，哪些不可以序列化，
 * 所以，对象在经过这里就把规定能被序列化的序列化保存文件，不能序列化的不处理，
 * 然后在反序列的时候自动调用readExternal()方法，根据序列顺序挨个读取进行反序列，并自动封装成对象返回。<br/>
 */
public class SerializationClass {

    public static void main(String[] args) throws Exception{

        // 输出对象序列化文件
        ObjectOutput out =
                new ObjectOutputStream(
                        new FileOutputStream("file.x"));
        Alien zorcon = new Alien();
        out.writeObject(zorcon);
        System.out.println("origin addr: " + zorcon);

        // 读取文件生成对象
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("file.x"));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass().toString());
        System.out.println("read object addr: " + mystery.toString());
    }
}

class Alien implements Serializable {
}

class UserInfo implements Externalizable {
    public String userName;
    public String userPass;
    public int userAge;

    public UserInfo() {
    }

    public UserInfo(String username, String userpass, int userage) {
        this.userName = username;
        this.userPass = userpass;
        this.userAge = userage;
    }

    //当序列化对象时,该方法自动调用
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("现在执行序列化方法");
        //可以在序列化时写非自身的变量
        Date d = new Date();
        out.writeObject(d);
        //只序列化userName,userPass变量
        out.writeObject(userName);
        out.writeObject(userPass);
    }

    //当反序列化对象时,该方法自动调用
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("现在执行反序列化方法");
        Date d = (Date) in.readObject();
        System.out.println(d);
        this.userName = (String) in.readObject();
        this.userPass = (String) in.readObject();
    }
}