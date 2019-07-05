package com.iu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	//3. Spring 에서 제공하는 MultipartFile 클래스의 transferTo 메서드
	public String saveFile3(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//java UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		originalName=originalName.substring(originalName.lastIndexOf("."));
		fileSystemName= fileSystemName+originalName;
		//저장
		file = new File(realPath, fileSystemName);
		multipartFile.transferTo(file);
		return fileSystemName;
	}
	
	//2. Java 에서 제공하는 OutPutStream 연결해서 사용
	public String saveFile2(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//java UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		originalName=originalName.substring(originalName.lastIndexOf("."));
		fileSystemName= fileSystemName+originalName;
		//저장
		file = new File(realPath, fileSystemName);
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(multipartFile.getBytes());
		return fileSystemName;
	}

	//1. Spring 에서 제공하는 FileCopyUtils클래스의 copy 메서드 사용
	//저장경로, MultipartFile
	public String saveFile(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//java UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		//fileSystemName = fileSystemName+"-"+originalName; 방식으로 저장하는 사람들도 있음.
		originalName=originalName.substring(originalName.lastIndexOf("."));
		fileSystemName= fileSystemName+originalName;
		//저장
		file = new File(realPath, fileSystemName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		return fileSystemName;
	}
	
}
