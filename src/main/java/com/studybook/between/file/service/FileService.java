package com.studybook.between.file.service;

import com.studybook.between.common.model.Constants;
import com.studybook.between.file.dao.FileDao;
import com.studybook.between.file.model.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    public FileInfo createFile(MultipartFile multipartFile) {

        FileInfo fileInfo = null;

        String originalFileName = multipartFile.getOriginalFilename();
        String fileOriName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        String fileExt = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        String fileName = String.valueOf(new Date().getTime());

        File file = new File(Constants.FILE_PATH + File.separator + fileName);
        try {
            multipartFile.transferTo(file);
            fileInfo = new FileInfo(fileName, fileExt, fileOriName);
            fileDao.createFile(fileInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInfo;
    }

    public FileInfo getFileInfo(String fileId) {
        return fileDao.getFileInfo(fileId);
    }
}
