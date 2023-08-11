package com.sky.commonMethod;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public class UploadFile {
    @Autowired
    private AliOssUtil aliOssUtil;
    public Result<String> upload(MultipartFile file) throws IOException {
        try {
            // 原始文件名
            String originalFilename = file.getOriginalFilename();

            // 截取原始文件名的后缀名
            String extensionName = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 构造新的文件名
            String objectName = UUID.randomUUID().toString() + extensionName;

            // 返回该文件的访问路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (Exception e) {
           return Result.error("上传出错");
        }
    }

}
