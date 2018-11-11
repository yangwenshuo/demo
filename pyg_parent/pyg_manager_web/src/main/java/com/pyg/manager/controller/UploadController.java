package com.pyg.manager.controller;

import com.pyg.entity.Result;
import com.pyg.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class UploadController {
	
	@Value("${FILE_SERVER_URL}")
	private String serviceUrl;
	
	@RequestMapping("/upload")
	public Result upload(MultipartFile file) throws Exception {
		try {
			//1.取文件扩展名
			//取文件全名
			String originalFilename = file.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			
			//2.创建FastDFS客户端
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			//3.客户端上传图片后，将获取的路径拼接全路径后
			String uploadFile = client.uploadFile(file.getBytes(),extName);
			//4.进行Result返回，success的时候返回图片路径给页面
			String imageUrl = serviceUrl + uploadFile;
			return new Result(true,imageUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"上传失败");
		}
		
	}
}
