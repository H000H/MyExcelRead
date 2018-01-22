package myexcel.file;

import java.io.File;
import java.io.IOException;

public class FileCreateUtil {
    /**
     * 由于我们经常想对文件存储进行分层，但是要分层又需要一段代码去控制建立文件层，
     * 这里我们通过这个代码自动的建立文件夹并且创建文件。
     * @param parentFilePath 根目录的绝对路径
     * @param filePath 相对路径和文件名
     * @return 正常返回file，运行错误返回一个null
     */
    public static File getFile(String parentFilePath,String filePath) {
        FileCreateUtil tool=new FileCreateUtil();
        tool.setParentFilePath(parentFilePath);
        tool.setFilePath(filePath);
        return tool.getFile();
    }

    //默认的路径是win路径的users文件夹
    private String parentFilePath="c:\\Users";

    //相对路径
    private String filePath="";

    public File getFile() {
        File result=null;
        File parentFile=new File(getParentFilePath());
        if (!parentFile.exists()) {
            return null;
        }
        String []list=getFilePath().split("\\\\");
        StringBuilder currentFiles=new StringBuilder(getParentFilePath());
        if(list!=null){
            for(int i=0;i<list.length;i++){
                currentFiles.append("\\"+list[i]);
                File tempFile=new File(currentFiles.toString());
                if(i<list.length-1&&tempFile.exists())
                    continue;
                if(i<list.length-1&&!tempFile.exists())
                    tempFile.mkdir();
                if(i==list.length-1&&tempFile.exists())
                    result=tempFile;
                if(i==list.length-1&&!tempFile.exists())
                    try {
                        if(tempFile.createNewFile())
                        result=tempFile;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
            }
        }
        return result;
    }

    public void setParentFilePath(String parentFilePath) {
        this.parentFilePath = parentFilePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getParentFilePath() {
        return parentFilePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
