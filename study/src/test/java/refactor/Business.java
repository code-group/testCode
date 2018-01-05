package refactor;

/**
 * @author: zhull
 * <P>date: 2018/1/5</P>
 * <P>description: </P>
 */
public class Business {

    /**
     * 客户端代码
     * @param args
     */
    public static void main(String[] args) {
        Customer customer = getCustomer();
        if (customer instanceof Null) {
            System.out.println("空对象");
        } else {
            System.out.println("我不是空的～");
        }
    }

    /**
     * 服务端代码
     * @return
     */
    private static Customer getCustomer() {
//        return new Customer();
        return new NullCustomer();
    }

    public void longParams(int age, String name) {

    }
}
