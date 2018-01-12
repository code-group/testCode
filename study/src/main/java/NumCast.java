/**
 * @author zhull
 * @date 2018/1/11</P>
 * <P>description: 数值类型的转型</P>
 */
public class NumCast {

    public static void main(String[] args) {

        // float类型初始化时，数字常量要追加f，否则与double混淆。
        float d = 1.0f;

        /**
         * “比int小”（即char，byte或者short），在正式执行运算之前，值会自动转换成int。
         * 这样一来，最终生成的值就是int类型
         */
        byte b1 = 1;
        byte b2 = 2;
        byte b3 = (byte) (b1 + b2);

    }
}
