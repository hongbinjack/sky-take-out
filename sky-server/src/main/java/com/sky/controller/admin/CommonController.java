package com.sky.controller.admin;

import com.sky.commonMethod.UploadFile;
import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 填好controller后去application.yml中配置oss。
 * 在server模块中创建一个叫OssConfiguration的配置类，这个类有一个方法upload可以创建出AliOssUtil对象并交由spring容器管理
 */


@RestController
@RequestMapping("/admin/common")
@Slf4j
@ApiOperation("通用接口")
public class CommonController {
       @Autowired
       private AliOssUtil aliOssUtil;

       @Autowired
       private UploadFile uploadFile;
       /**
        *文件上传
        * @param file
        * @return
        */
       @PostMapping("/upload")
       @ApiOperation("文件上传")
       public Result<String> upload(MultipartFile file) throws IOException {
              log.info("文件上传： {}",file);
              Result<String> filePath = uploadFile.upload(file);
              if(filePath.getCode() != 0)
                    return filePath;
              else
              return Result.error(MessageConstant.UPLOAD_FAILED);
       }
}
