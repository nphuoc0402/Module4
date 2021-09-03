package stackjava.com.springmvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import stackjava.com.springmvc.model.MyFile;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("myFile", new MyFile());

		return "index";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MyFile myFile, Model model) {
		model.addAttribute("message", "upload success");
		model.addAttribute("description", myFile.getDescription());
		
		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("F:/JAVA", fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "upload failed");
		}
		return "result";
	}

}
