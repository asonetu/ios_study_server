package com.studybook.between.user.controller;

import com.studybook.between.common.model.Constants;
import com.studybook.between.common.util.ResponseCode;
import com.studybook.between.common.util.RestResponse;
import com.studybook.between.file.model.FileInfo;
import com.studybook.between.file.service.FileService;
import com.studybook.between.user.model.User;
import com.studybook.between.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;


    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    public RestResponse createUserProfile(@RequestBody User user) {

        log.info("createUserProfile user : ");
        log.info(user);

        userService.createUserProfile(user);

        return new RestResponse(ResponseCode.SUCCESS, null);
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public RestResponse getUserProfile(@RequestParam("userId") String userId) {

        log.info("getUserProfile userId : " + userId);

        User user = userService.getUserProfile(userId);

        return new RestResponse(ResponseCode.SUCCESS, user);
    }

    @RequestMapping(value = "/user/profile/image", method = RequestMethod.POST)
    public RestResponse uploadUserProfileImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam("userId") String userId) {

        log.info("uploadUserProfileImage userId : " + userId);

        Integer fileId = userService.uploadUserProfileImage(multipartFile, userId);

        log.info("uploadUserProfileImage result fileId : " + fileId);

        return new RestResponse(ResponseCode.SUCCESS, fileId);
    }

    @RequestMapping(value = "/user/profile/image", method = RequestMethod.GET)
    public RestResponse downloadUserProfileImage(@RequestParam("fileId") String fileId) {

        log.info("downloadUserProfileImage fileId : " + fileId);

        FileInfo fileInfo = fileService.getFileInfo(fileId);

        File file = new File(Constants.FILE_PATH + File.separator + fileInfo.getFileName());
        FileInputStream fis = null;
        try {
            byte[] data = new byte[(int) file.length()];
            fis = new FileInputStream(file);
            fis.read(data);

            String base64Data = Base64.getEncoder().encodeToString(data);
            fileInfo.setBase64Data(base64Data);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return new RestResponse(ResponseCode.SUCCESS, fileInfo);
    }
}
