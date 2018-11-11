package com.pyg.shop.controller;

import com.pyg.entity.Result;
import com.pyg.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class UploadController {



	//value字符串的配置文件值注入
	//这个value就是用来注入配置文件的内容的,如果写死的我直接写不就行了
	@Value("${FILE_SERVER_URL}")
	private String serviceUrl;



	//看到了这里的接收文件的方法的参数是multipartfile file


	//该方法的意思就是收到客户端上传来的图片,
	@RequestMapping("/upload")
	public Result upload(MultipartFile file) throws Exception {
		try {
			//取文件扩展名
			String originalFilename = file.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			
			//2.创建FastDFS客户端
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			//3.客户端上传图片后，将获取的路径拼接全路径后


			//这个方法的参数是file.getbytes()字节数组和文件的扩展名
			String uploadFile = client.uploadFile(file.getBytes(),extName);



			//将fastdfs的IP和fastdfs服务器返回的字节标识符返回给前端
			//通过这俩东西就能定位出文件的位置
			String imageUrl = serviceUrl + uploadFile;
			return new Result(true,imageUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"上传失败");
		}
		
	}
}
