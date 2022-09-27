package com.app.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Users;
import com.app.service.IUserService;
import com.app.service.IimageService;

@Controller

///Images/ImageUpload/3
@RequestMapping("/Images")
public class ImageController {
	@Value("${project.image}")
	private String path;
	@Autowired
	private IimageService imageService;
	@Autowired
	private IUserService usersService;

	@GetMapping("/ImageUpload/{Id}")
	public String showImagepage(@PathVariable int Id,Model map) {
		System.out.println("id:"+Id);
		map.addAttribute("Id", Id);
		return "/UserImages/ImageUpload";
	}

	@PostMapping("/ImageUpload/{Id}")
	public String imageProcess(@RequestBody MultipartFile file,@PathVariable int Id,RedirectAttributes map) {
		System.out.println("fiel"+file+"  Id:"+Id);
		String msg="";
		try {
			String name=imageService.upLoadImage(path, file);
			Users user = usersService.getByIdAndSetName(Id,name);
			
			if(user.getImageUrl()!=null)
				msg="images uploded sucessfully";
			else 
				msg="image not uploaded try again";
			
			map.addFlashAttribute("ImageMsg", msg);
			
			System.out.println(name);
			return "redirect:/admin/viewAll";
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
              msg="image not uploaded try again";
			
			map.addFlashAttribute("ImageMsg", msg);
			return "redirect:/admin/viewAll";
		}
		
	}
}
