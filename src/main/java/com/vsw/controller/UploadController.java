package com.vsw.controller;

import com.alibaba.fastjson.JSON;
import com.vsw.common.util.ImgAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Value("${prop.frontproject.folder}")
    private String FRONTPRJ_FOLDER;

    private static String ROOT_PATH = "../";

    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/singlefile")
    public String singleFileUpload(MultipartFile file) {
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        try {
            byte[] bytes = file.getBytes();
            String upload_sub_path = UPLOAD_FOLDER + format.format(Calendar.getInstance().getTime()) + "/";

            String real_foler_path = FRONTPRJ_FOLDER + upload_sub_path;

//            String resetFileName = ImgAddressUtil.rewriteImgAddressByHashCode(file.getOriginalFilename());

            Path path = Paths.get(real_foler_path, file.getOriginalFilename());

            System.out.println(path);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(real_foler_path));
            }
            //如若文件存在,直接返回path
            logger.debug("文件已存在");
            if (!Files.exists(path)) {

                //文件写入指定路径
                Files.write(path, bytes);
                logger.debug("文件写入成功...");
            }
            return ROOT_PATH + upload_sub_path + file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
}