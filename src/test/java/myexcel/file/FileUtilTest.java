package myexcel.file;

import myexcel.image.util.ImageFactory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
    //测试一个file的isDirectory和isFile
    @Test
    public void testIsDrectory(){
        File parentFile=new File("Myfile");
        if(parentFile.isDirectory())
            System.out.println("是一个文件夹");
        else
            System.out.println("不是是一个文件夹");
        if(parentFile.isFile())
            System.out.println("是一个文件");
        else
            System.out.println("不是一个文件");
    }

    //测试list和listfile
    @Test
    public void testfileList(){
        File parentFile=new File("Myfile");
        File result=null;
        if(!parentFile.exists()){
            parentFile.mkdir();
        }else {
            String[]str=parentFile.list();
            File[] files=parentFile.listFiles();
            for(String string:str) {
                System.out.println(string);
            }
            System.out.println("文件");
            for (File file:files){
                System.out.println(file.getAbsolutePath());
            }

        }
    }

    //测试文件查询功能
    @Test
    public void testFileOrderSearch() {
        File file;
        file=FileOrderSearch.getFiles("新建文件夹");
        if(file!=null)
            System.out.println(file.getAbsolutePath());
    }

    //获取os的信息
    @Test
    public void testOS() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperties());
    }

    //反斜杠的特殊分割
    @Test
    public void testIII() {
        String string="C:\\Users";
        String[] result=string.split("\\\\");
        System.out.println(result[1]);
    }

    //测试文件生成
    @Test
    public void testCreateFile() {
        File file=FileCreateUtil.getFile("Myfile","test\\image\\2014213997\\student.txt");
        if(file.exists())
            System.out.println("这个文件存在哦");
    }

    //测试图像生成
    @Test
    public void testImageCreate() {
        ImageFactory.getNewImage("");
    }
}
