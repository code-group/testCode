/**
 * @author zhull
 * @date 2018/1/16</P>
 * <P>description: </P>
 */
public class Anything extends Ball{
    public static void main(String[] args) {

    }
}

abstract class Instrument {

}

abstract class Ball {

}

interface A {
    void common();
}

interface B {
    void common();
}

class C implements A, B{

    @Override
    public void common() {

    }
}