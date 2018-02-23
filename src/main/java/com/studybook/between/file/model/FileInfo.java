package com.studybook.between.file.model;

import com.studybook.between.common.util.GsonToString;

public class FileInfo extends GsonToString {

    private int fileId;
    private String fileName;
    private String fileExt;
    private String fileOriName;
    private String base64Data;

    public FileInfo() {
        super();
    }

    public FileInfo(String fileName, String fileExt, String fileOriName) {
        super();
        this.fileName = fileName;
        this.fileExt = fileExt;
        this.fileOriName = fileOriName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileOriName() {
        return fileOriName;
    }

    public void setFileOriName(String fileOriName) {
        this.fileOriName = fileOriName;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }
}