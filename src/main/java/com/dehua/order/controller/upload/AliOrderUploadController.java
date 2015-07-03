package com.dehua.order.controller.upload;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller("aliOrderUploadController")
@RequestMapping(value="/ali")
public class AliOrderUploadController {
	// 处理文件上传一  
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)  
    public ModelAndView fileUpload(  
            @RequestParam("fileUpload") CommonsMultipartFile file) {  
        // 获取文件类型  
        System.out.println(file.getContentType());  
        // 获取文件大小  
        System.out.println(file.getSize());  
        // 获取文件名称  
        System.out.println(file.getOriginalFilename());  
  
        // 判断文件是否存在  
        if (!file.isEmpty()) {  
            String path = "D:/" + file.getOriginalFilename();  
            File localFile = new File(path);  
            /*try {  
                file.transferTo(localFile);  
            } catch (IllegalStateException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  */
        }  
        return new ModelAndView("home");  
    }
}
