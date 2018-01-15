package myexcel.read.checkout;

public class Test {
    public static void main(String[] args){
        String[] mobile={"18883992403","15835243834","158352434","232314515151","1231412412"};
        for(int i=0;i<5;i++) {
            boolean result = CleckoutUtil.checkoutMoblie(mobile[i]);
            System.out.print("这个电话是："+mobile[i]+";结果是：");
            if (result == true) {
                System.out.println("是电话号哦哦");
            } else {
                System.out.println("不是");
            }
        }
        String[] date={"1992-1-2","2018-1-04","2018-12-04","2018-1-04","2018-1-31","22-23-3","12011-21-22"};
        for(int i=0;i<7;i++) {
            boolean result = CleckoutUtil.checkoutDateFormat1(date[i]);
            System.out.print("这个日期是："+date[i]+";结果是：");
            if (result == true) {
                System.out.println("是");
            } else {
                System.out.println("不是");
            }
        }
    }
}
