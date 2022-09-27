package com.app.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Users;
import com.app.service.IAdminService;
import com.app.service.IUserService;
import com.app.service.emailService;

@Controller
@RequestMapping("/forgot")
public class forgotPassword {
	public forgotPassword() {
	}

	Random random = new Random(1000);
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService userService;
	@Autowired
	private emailService eService;

	@GetMapping("/Password")
	public String showForgotPassword() {
		return "/admin/forgotPassword";
	}

	@PostMapping("/Password")
	public String showForgotPassword(@RequestParam int id,@RequestParam String email, HttpSession session, Model map) {
		String msg = "";
		try {
			int otp = random.nextInt(999999);
			System.out.println(otp);
			String body = String.valueOf(otp);
			session.setAttribute("Otp", body);

			Users validatedUser = userService.getByIdAndEmail(id,email);

			if (validatedUser == null) {
				msg = "plz try with registred email id";
				map.addAttribute("msg", msg);
				return "/admin/forgotPassword";
			}
			session.setAttribute("email", validatedUser.getEmail());
			session.setAttribute("id", validatedUser.getId());
			boolean flag = eService.SendEmail(email, body, "Password Recovery Otp");
			if(flag) {
				msg = "email verified and otp is send to registered email id plz verify otp";
			map.addAttribute("msg", msg);

			return "/admin/verifyOtp";
				
			}
			else
			{
				msg = "something went wrong otp not sent ";
			map.addAttribute("msg", msg);
			return "/admin/forgotPassword";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "plz try with registred email id something is going wrong";
			map.addAttribute("msg", msg);
			return "/admin/forgotPassword";
		}

	}

	@PostMapping("/verify")
	public String verifyEmailAndOtp(@RequestParam String email, @RequestParam String Otp, HttpSession session,
			Model map) {
		
		
		try {
			
			System.out.println("in verify Controller");
			String originalOtp = (String) session.getAttribute("Otp");
			
			String msg = "something went wrong";
			
			System.out.println(!originalOtp.equals(Otp));
			if (!originalOtp.equals(Otp)) {
				msg = "Wrong otp enterd plz try  again!!!";
				map.addAttribute("msg", msg);
				return "/admin/login";
			} else if (originalOtp.equals(Otp)) {
				msg = "otp verified sucessfully";
				map.addAttribute("msg", msg);
				return "/admin/resetPassword";
			}
			else
			return "/admin/login";
			
		} catch (Exception e) {
			e.printStackTrace();
		
			map.addAttribute("msg", "something went wrong  plz try  again!!!");
			return "/admin/login";
			
		}
		
	}
	@PostMapping("/resetPassword")
  public String resetPassword(@RequestParam String password,HttpSession session,Model map)
  {  
		System.out.println("in reset passord method");
		String resetPasswordMsg="";
		try {
			String emailId = (String) session.getAttribute("email");
			//Integer id=Integer.parseInt((String) session.getAttribute("id"));
			int id= (int) session.getAttribute("id");
		
			System.out.println("id="+id);
//			resetPasswordMsg="password reset sucessfully";
			resetPasswordMsg=userService.changePassword(id,emailId,password);
			map.addAttribute("resetPasswordMsg", resetPasswordMsg);
			return "/admin/login";
		} catch (Exception e) {
			e.printStackTrace();
			resetPasswordMsg="password  not resetted error occourred";
			map.addAttribute("resetPasswordMsg", resetPasswordMsg);
			return "/admin/login";
		}
	
  }
}
