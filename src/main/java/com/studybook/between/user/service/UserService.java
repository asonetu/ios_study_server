package com.studybook.between.user.service;

import com.studybook.between.file.model.FileInfo;
import com.studybook.between.file.service.FileService;
import com.studybook.between.user.dao.UserDao;
import com.studybook.between.user.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private FileService fileService;

    public void createUserProfile(User user) {
        userDao.createUserProfile(user);
    }

    public User getUserProfile(String userId) {
        return userDao.getUserProfile(userId);
    }

    public Integer uploadUserProfileImage(MultipartFile multipartFile, String userId) {

        int fileId = -1;

        FileInfo file = fileService.createFile(multipartFile);
        if(file != null) {
            fileId = file.getFileId();

            log.info("fileId : " + fileId);

            userDao.updateUserProfileImage(userId, fileId);
        }

        return fileId;
    }
}
