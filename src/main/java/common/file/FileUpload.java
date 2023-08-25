package common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	public static UUID saveCopyFile(MultipartFile file, HttpServletRequest request) {
		String filename = file.getOriginalFilename();
		
		//중복파일명을 처리하기 위한 난수발생
		UUID random = UUID.randomUUID();
		File ff = new File(urlPath(request), random + "_" + filename);
		
		try {
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return random;
		
	}//end saveCopyFile()
	
	public static String urlPath(HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root: " + root);
		String saveDirectory = root + "temp" + File.separator;
		//파일이 저장된 경로를 서버에 넘겨준다. 삭제할 때 필요하므로.
		
		File fe = new File(saveDirectory);
		if(!fe.exists())
			fe.mkdir();
		
		return saveDirectory;	
	}//end urlPath()

}//end class
