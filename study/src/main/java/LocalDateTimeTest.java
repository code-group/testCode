import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * @author: zhull
 * <P>date: 2017/12/28</P>
 * <P>description: Java8 线程安全的时间工具</P>
 * SimpleDateFormat 是线程不安全的类，一般不要定义为static变量，如果定义为static，必须加锁，或者使用DateUtils工具类。
 * 说明：如果是JDK8的应用，可以使用Instant代替Date，LocalDateTime代替Calendar，DateTimeFormatter代替SimpleDateFormat，
 * 官方给出的解释：simple beautiful strong immutable thread-safe。
 * ——《阿里巴巴Java开发手册(终极版)》
 */
public class LocalDateTimeTest {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * <P>date:        2017/12/28</P>
     * <P>description: 使用LocalDateTime</P>
     **/
    public static void useLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
        System.out.println(format);
    }

    public static void main(String[] args) {

        // 用ThreadLocal变量
        df.get().format(new Date());

        // 用LocalDateTime
        useLocalDateTime();

        Random random = new Random();
        random.nextInt();

    }
}
