package myexcel.file;

import java.io.File;

/**
 * 文件顺序查找组件
 */

public class FileOrderSearch {
    //文件根目录
    public static String FILEPATH="myFile";

    //文件根目录
    private String fileParent="myFile";

    //文件类型
    private String fileType=FileTypeMEnum._file.toString();

    //需查找的文件的文件名
    private String fileName="";

    public void setFileParent(String fileParent){
        this.fileParent=fileParent;
    }

    public void setFileType(String type){
        this.fileType=type;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 查询文件夹是否存在
     * @param filesName
     * @return
     */
    public static File getFiles(String filesName){
        File parentFile=new File(FILEPATH);
        File result=null;
        if(!parentFile.exists()){
            parentFile.mkdir();
        }else {
            FileOrderSearch util=new FileOrderSearch();
            util.setFileName(filesName);
            result=util.getFile();
        }
        return result;
    }

    /**
     * 开放出来的查询接口
     */
    public File getFile(){
        File parentFile=new File(fileParent);
        return search(parentFile);
    }
    /**
     * 迭代加循环的方式查找
     */
    private File search(File parent){
        File[] fileList=parent.listFiles();
        File result=null;
        //根据fileType来查找需要的文件
        if(fileList!=null) {
            for (int i = 0; i < fileList.length; i++) {
                File tempFile = fileList[i];
                if (tempFile.isDirectory()){
                    tempFile = search(tempFile);
                    if (tempFile == null)
                        tempFile=fileList[i];
                }
                if (tempFile.getName().equals(fileName)) {
                    result = tempFile;
                }
            }
        }
        return result;
    }
    /**
     * 查询文件是否存在一个文件夹中
     */

    /**
     * 查询一个文件夹是否存在并且创建
     */

    /**
     * 查询一个文件是否存在文件夹如果不存在创建
     */


}
