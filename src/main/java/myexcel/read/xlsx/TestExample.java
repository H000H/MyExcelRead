package myexcel.read.xlsx;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestExample {
    public static void maintest(){
        //使用默认的excel文件
        System.out.println("这是一个用例");
        XlsxRead readExcle=new XlsxRead();
        String[] keylist=readExcle.getKeyList();
        System.out.println("这个是key的值："+keylist.toString());
        StringBuilder builder=new StringBuilder("结果是：");
        List<Map<String, Object>> list=readExcle.getValue(0);
        for(Map<String,Object> map : list){
            builder.append("/n"+"第n行数据是："+map.get(keylist[0])+" "+map.get(keylist[1])+" "+map.get(keylist[2])+" "+map.get(keylist[3])+" "+map.get(keylist[4]));
        }
        System.out.println(builder.toString());
        //这里是对数据日期问题的进行处理
        Map<String,Object> map=list.get(1);
        if(map.get(keylist[3])instanceof String){
            System.out.println("creditMoney is a str");
        }else if(map.get(keylist[3])instanceof Double){
            System.out.println("creditMoney is a double");
            Date date=new Date(System.currentTimeMillis());
            System.out.println("now time is:"+date.toString());
            Date date2=new Date(0);
            date2.setDate(((Double) map.get(keylist[3])).intValue());
            System.out.println("excel time is:"+date2.toString());
        }else{
            System.out.println("I don't know what is this"+map.get(keylist[3]).toString());
        }
        //这里是对double数据转换成string格式数据的处理
        System.out.println(map.toString());
        System.out.println(new BigDecimal((double)map.get(keylist[2])).toString());
    }
}
