package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements IimageService {

	@Override
	public String upLoadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		//file name
		String name=file.getOriginalFilename();
		//file path full
		String filePath=path+File.separator+name;
		//create folder if not created
		System.out.println("file path:"+filePath);
		File f=new File(path);
		if(!f.exists())
			f.mkdir();
		//file copy
		
			Files.copy(file.getInputStream(), Paths.get(filePath));
		
			// TODO Auto-generated catch block
			
		
		return name;
	}

}
