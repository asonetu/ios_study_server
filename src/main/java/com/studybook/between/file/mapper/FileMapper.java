package com.studybook.between.file.mapper;

import com.studybook.between.file.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {

    void createFile(FileInfo fileInfo);

    FileInfo getFileInfo(@Param("fileId") String fileId);
}
