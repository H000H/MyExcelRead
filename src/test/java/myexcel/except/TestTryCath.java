package myexcel.except;


import org.junit.Test;

public class TestTryCath{

    /**
     * 该测试说明。。。reture是会这样的哦
     */
    @Test
    public void TryCath(){
        //测试一个file的isDirectory和isFile
        String result=fun1();
        if(null==result)
            System.out.println("没有参数哦");
        else
            System.out.println("有参数的"+result);
    }

    public String fun1(){
        try{
            throw new Exception("没有参数");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        String str="nihao";
        return str;
    }
}
