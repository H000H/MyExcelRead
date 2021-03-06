package myexcel.read;

import java.io.File;
import java.io.IOException;

/**
 * 测试文件的
 */
public class FilePathTest {
    public static void main(String[] args) {
        //结果是这个文件创建在了项目的更目录里
        File file=new File("weixin.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsoluteFile().getAbsolutePath());
        File file1=new File("src\\main\\resources\\白名单模板(1).xlsx");
        if(!file1.exists()){
            System.out.println("不存在哦");
        }else {
            System.out.println(file1.getAbsoluteFile().getAbsolutePath());
        }
    }
}
