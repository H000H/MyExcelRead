package myexcel.checkout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 这个是匹配工具类
 */
public class CleckoutUtil {
    /**
     * Str是否是电话号
     * 现在实现的功能：开头是1，后面+10哥数字
     */
    public static Boolean checkoutMoblie(String mobile){
        // 按指定模式在字符串查找
        return checkoutBase(mobile,"^1\\d{10}");
    }

    /**
     * str是否是“2018-1-12”这种格式
     */
    public static Boolean checkoutDateFormat1(String date){
        return checkoutBase(date,"^\\d{4}-\\d{1,2}-\\d{1,2}");
    }

    /**
     * 基础的服务哦
     * @param str
     * @param pattern
     * @return
     */
    public static Boolean checkoutBase(String str,String pattern){
        Boolean result;
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        if (m.matches()) {
            result=true;
        }else{
            result=false;
        }
        return result;
    }
}
