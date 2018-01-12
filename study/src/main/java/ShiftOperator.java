/**
 * @author zhull
 * @date 2018/1/10</P>
 * <P>description: 无符号右移运算符</P>
 * byte	  8-bit
 * char	  16-bit
 * short  16-bit
 * int	  32-bit
 * long	  64-bit
 * float  32-bit
 * double 64-bit
 *
 * << : 左移运算符，num << 1,相当于num乘以2
 * >> : 右移运算符，num >> 1,相当于num除以2
 * >>>: 无符号右移，忽略符号位，空位都以0补齐
 *
 * 对-3右移3位     -3>>3 ，
 * 就是对-3的补码11111111 11111111 11111111 11111101右移3位，结果为：
 * 1 111 1111111 11111111 11111111 11111，由于是负数，高位需要补1（正数高位补0），而
 * 1 111 1111111 11111111 11111111 11111
 * 的原码为10000000 00000000 00000000 00000001，结果为-1，所以-3>>3的结果整数值为-1
 */
public class ShiftOperator {

    public static void main(String[] args) {

        int i = 1;
        System.out.println(Integer.toBinaryString(i));
        i >>= 10;
//        System.out.println(i >>> 10);
//        System.out.println(Integer.toBinaryString(i >>> 10));
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));


/**
        long l = -1;
        l >>>= 10;
        System.out.println(l);

        short s = -1;
        s >>>= 10;
        System.out.println(s);

        byte b = -1;
        b >>>= 10;
        System.out.println(b);
**/
    }
}
