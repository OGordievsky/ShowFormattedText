package model;

public abstract class AbstractFileModel implements GetFileData {
    protected String fileUrl;

    public AbstractFileModel(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}