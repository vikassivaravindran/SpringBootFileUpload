package com.accenture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private static final Logger logger = Logger.getLogger(UploadController.class);
	private static String UPLOADED_FOLDER = "C://Users/vikas.sivaravindran/Documents/";

	@GetMapping("/")
	public String Welcome(){
		if(logger.isInfoEnabled()){
			logger.info("Accessing the welcome page");
		}
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadaSinglefile(@RequestParam("file") MultipartFile file,Model model)
	{
		
		if(file.isEmpty()){
			if(logger.isInfoEnabled()){
				logger.info("Empty file");
			}
			model.addAttribute("message","Please choose a valid file to upload");
		return "redirect:upload";
		
		}
		try{
			byte b[] = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
			Files.write(path,b);
			model.addAttribute("message","Your file has been successfully uploaded");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Result";
	
	}
	
	@GetMapping("/Result")
	public String Result(){
		return "Result";
	}
	
}
