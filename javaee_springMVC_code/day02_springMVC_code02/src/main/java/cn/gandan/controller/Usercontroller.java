package cn.gandan.controller;

import cn.gandan.domain.User;
import com.sun.deploy.util.SessionState;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("login")
public class Usercontroller {

    @RequestMapping("/upload")
    public String login(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");

        String realPath = request.getSession().getServletContext().getRealPath("/upload/");

        File file = new File(realPath);

        if(!file.exists()){
            file.mkdirs();
        }

        // 10

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);

            for(FileItem item:items){
                // 进行判断，当前item对象是否是上传文件项
                if(item.isFormField()){
                    // 说明普通表单向
                }else{
                    // 说明上传文件项
                    // 获取上传文件的名称
                    String filename = item.getName();

                    Date date = new Date();

                    String s = date.toString();
                    // 把文件的名称设置唯一值，uuid
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    filename = uuid +"_"+ filename;
                    // 完成文件上传
                    item.write(new File(realPath,filename));
                    // 删除临时文件
                    item.delete();
                    System.out.println(filename);
                }
            }


            return "success";
    }

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMVC文件上传....");

        String realPath = request.getSession().getServletContext().getRealPath("/upload/");

        File file = new File(realPath);

        if(!file.exists()){
            file.mkdirs();
        }


        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid +"_"+ filename;

        // 上传方法
        upload.transferTo(new File(realPath, filename));

        System.out.println(filename);

        return "success";
    }

    @RequestMapping("/fileuploadOther")
    public String fileuploadOther(MultipartFile upload) throws Exception {

        String path = "http://localhost:9090/file/uploads/";

        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid +"_"+ filename;

        Client client = Client.create();

        WebResource resource = client.resource(path + filename);

        System.out.println("springMVC跨服务器文件上传....");

        resource.put(upload.getBytes());

        System.out.println(filename);

        return "success";
    }

}
