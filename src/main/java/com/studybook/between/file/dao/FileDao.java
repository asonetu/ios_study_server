package com.studybook.between.file.dao;

import com.studybook.between.file.mapper.FileMapper;
import com.studybook.between.file.model.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {

    @Autowired
    private FileMapper fileMapper;

    public void createFile(FileInfo fileInfo) {
        fileMapper.createFile(fileInfo);
    }

    public FileInfo getFileInfo(String fileId) {
        return fileMapper.getFileInfo(fileId);
    }
}
