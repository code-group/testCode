import java.math.BigDecimal;

/**
 * @author zhull
 * @date 2018/1/16</P>
 * <P>description: </P>
 */
public class Anything {

    private static int _1MB = 1024*1024;


    public static void main(String[] args) {
        System.out.println(getNormalAmount(20L, 3));
        System.out.println(getNormalAmount(10L, 3));
        System.out.println(getNormalAmount(13L, 2));
    }

    static Long getNormalAmount(Long a, int b) {
        BigDecimal normalAmount = new BigDecimal(a).divide(new BigDecimal(b), BigDecimal.ROUND_HALF_UP);
        System.out.println("! " + normalAmount);
        return normalAmount.longValue();
    }
}