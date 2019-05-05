import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author zhull
 * @date 2018/1/16</P>
 * <P>description: </P>
 */
public class Anything {

    private static int _1MB = 1024 * 1024;


    public static void main(String[] args) {
        convertToJsonArray("C:\\Users\\zhulili04\\Desktop\\test.txt");
    }

    static Long getNormalAmount(Long a, int b) {
        BigDecimal normalAmount = new BigDecimal(a).divide(new BigDecimal(b), BigDecimal.ROUND_HALF_UP);
        System.out.println("! " + normalAmount);
        return normalAmount.longValue();
    }

    private static String getContractName(String contractPath) {
        String fileName = contractPath.substring(contractPath.lastIndexOf('/') + 1, contractPath.length() - ".pdf".length());
        return fileName;
    }

    public static JSONArray convertToJsonArray(String path) {
        JSONArray jsonArray = null;
        StringBuilder jsonStrs = new StringBuilder();
        try (InputStream inputStream =new FileInputStream(path) ;
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader reader = new BufferedReader(inputStreamReader)){
            //绝对路径
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                jsonStrs.append(tempStr);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(jsonStrs.toString());
        try {
            jsonArray = JSONArray.parseArray(jsonStrs.toString().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonArray;
    }
}

