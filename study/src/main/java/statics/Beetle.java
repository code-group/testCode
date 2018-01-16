package statics;

/**
 * @author: zhull
 * <P>date: 2018/1/4</P>
 * <P>description: 类加载，与static加载顺序</P>
 */
public class Beetle extends Insect {
    int k = prt("Beetle.k initialized");
    Beetle() {
        prt("k = " + k);
        prt("j = " + j);
    }
    static int x2 =
            prt("static Beetle.x2 initialized");
    static int prt(String s) {
        System.out.println(s);
        return 63;
    }
    public static void main(String[] args) {
        prt("Beetle constructor");
//        Beetle b = new Beetle();
    }
}

class Insect {
    static int i = 9;
    static int i1 = (int)(Math.random() * 10);

    int j;
    Insect() {
        prt("i = " + i + ", j = " + j);
        j = 39;
    }
    static int x1 =
            prt("static Insect.x1 initialized");
    static int prt(String s) {
        System.out.println(s);
        return 47;
    }
}