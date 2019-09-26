package com.learn.springboot.springmvc.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author: zhenghailong
 * @date: 2019/9/25 10:26
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/file/")
public class UploadController {

    @PostMapping("uploadRequest")
    public void uploadRequest(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = null;
        if (request instanceof MultipartHttpServletRequest){
            multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        }else {
            throw new RuntimeException("上传文件失败");
        }
        MultipartFile mf = multipartHttpServletRequest.getFile("file");
        String filename = mf.getOriginalFilename();
        File file = new File(filename);
        mf.transferTo(file);
    }

    @PostMapping("multipartFil")
    public void uploadMultipartFile(MultipartFile mf) throws IOException {
        String filename = mf.getOriginalFilename();
        File file = new File(filename);
        mf.transferTo(file);
    }

    @PostMapping("part")
    public void uploadPart(Part file) throws IOException {
        String fileName = file.getSubmittedFileName();
        file.write(fileName);
    }
}
