package myexcel.file;

public enum  FileTypeMEnum {
    _files(""),
    _png("png"),
    _jpg("jpg"),
    _file("all"),
    _txt("txt"),
    _doc("doc") ,
    _docx("docx");

    public String type;
    FileTypeMEnum(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
