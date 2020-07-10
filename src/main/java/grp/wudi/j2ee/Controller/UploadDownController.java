package grp.wudi.j2ee.Controller;


import com.alibaba.fastjson.JSON;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.entity.Result;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/picture")
public class UploadDownController {

    @Autowired
    HouseServiceImpl houseServiceImpl;


    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    @CrossOrigin(origins = "*")
    public String upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        System.out.println("表现层在执行上传图片");
        //获取文件在服务器的储存位置
        String path = request.getSession().getServletContext().getRealPath("/picture");
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }



        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");

            House house = new House();
            house.setHousePicture(path+fileName);

            //将文件在服务器的存储路径返回
            Result result = new Result(true,"/upload/" + fileName);
            String json=JSON.toJSONString(result);
            return json;
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            Result result = new Result(false, "上传失败");
            String json=JSON.toJSONString(result);
            return json;
        }
    }
}
