package refactor;

import lombok.Data;

/**
 * @author: zhull
 * <P>date: 2018/1/5</P>
 * <P>description: 客户</P>
 */
@Data
public class Customer {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
