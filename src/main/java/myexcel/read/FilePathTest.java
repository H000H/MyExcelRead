package myexcel.read;

import java.io.File;
import java.io.IOException;

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
    }
}
