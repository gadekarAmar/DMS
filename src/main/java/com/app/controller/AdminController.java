package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Cattle;
import com.app.pojos.FatePrice;
import com.app.pojos.MilkCollection;
import com.app.pojos.Role;
import com.app.pojos.Users;
import com.app.service.IAdminService;
import com.app.service.IFateRateService;
import com.app.service.IMilkService;
import com.app.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService usersService;
	@Autowired
	private IFateRateService fateRateService;
	@Autowired
	private IMilkService milkService;

	
	public AdminController() {
		System.out.println("in admin controller");
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in showLoginForm ");
		return "/admin/login";
	}
     @GetMapping("/home")
     public String home()
     {
    	 return "/admin/Home";
     }
     @PostMapping("/register")
     public String register(@RequestParam String name, @RequestParam String lastName, @RequestParam String password,
 			@RequestParam String address, @RequestParam String email, 
 			RedirectAttributes flashMap)
     {
    	 

    	 String msg = "";
 		try {
 			
 			
 //(@NotBlank String name, @NotBlank String lastName, String address, String password, Cattle cattle,String email,Role role)
 			
 			Users user = new Users(name.trim(), lastName.trim(), address, password.trim(), Cattle.valueOf("NA"), email.trim().toLowerCase(),Role.valueOf("ADMIN"));
 			Users savedUser = usersService.addUser(user);
 			if (savedUser == null) {
 				msg = "Admiin is not registered try again!!!!!!";
 				flashMap.addFlashAttribute("Regmsg", msg);
 			} else {
 				msg = "Admin registered successfull Name:" + savedUser.getName() + " " + savedUser.getLastName();
 				flashMap.addFlashAttribute("Regmsg", msg);
 			}

 			return "redirect:/admin/login";
 		}

 		catch (Exception e) {
 			msg = "Admin is not added try again !!!!!!";
 			
 			flashMap.addFlashAttribute("Regmsg", msg);
 			System.out.println(e.getMessage());
 			return "redirect:/admin/login";

 		}
     }
     @GetMapping("/register")
     public String register()
     {
    	 return "/admin/register";
     }
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String uname, @RequestParam String password, Model map,HttpSession session) {
		
		System.out.println("in processLoginForm user" + uname + "  pass:" + password);
		String msg = "";
		 Users admin = usersService.authenticateUser(uname.trim(), password.trim());
		// System.out.println(admin.getEmail());

		if (admin == null) {
			msg = "You have Entred wrong usrname or password , please try again!!!!!!!!";
			map.addAttribute("LoginMsg", msg);
			return "/admin/login";
		} else if(admin.getRole().equals(Role.valueOf("ADMIN"))) {
			System.out.println("admin"+admin);
			msg = "Sucessfully loged in as Admin!!!!!!!!";
			map.addAttribute("LoginMsg", msg).addAttribute("admin", admin);
			session.setAttribute("admin", admin);
			return "/admin/Home";
		}else {
			System.out.println("In users");
			msg = "Sucessfully loged in as User!!!!!!!!";
			map.addAttribute("LoginMsg", msg).addAttribute("admin", admin);
			session.setAttribute("user", admin);
			return "/customer/details";
		}

	}

	@GetMapping("/viewAll")
	public String viewAllUsers(Model map) {
		System.out.println("viewAllusers methods");
		String msg = "";
		List<Users> users = usersService.getAllUsers();
		// System.out.println(users);
		if (users == null) {

			msg = "no users avaiable";
			map.addAttribute("msg", msg);
			return "/admin/Home";
		}

		map.addAttribute("users", users);
		return "/admin/viewAll";
	}

	@GetMapping("/AddUser")
	public String AddUser() {
		System.out.println("adduser method");
		return "/admin/AddUser";
	}

	@PostMapping("/AddUser")
	public String AddUser(@RequestParam String name, @RequestParam String lastName, @RequestParam String password,
			@RequestParam String address, @RequestParam String email, @RequestParam String cattleType,@RequestParam String role,
			RedirectAttributes flashMap) {
		String msg = "";
		try {
			Cattle cattle = Cattle.valueOf(cattleType.toUpperCase());
			Role newRole=Role.valueOf(role.toUpperCase().trim());
//(@NotBlank String name, @NotBlank String lastName, String address, String password, Cattle cattle,String email,Role role)
			if(newRole.equals(Role.valueOf("ADMIN".toUpperCase().trim())))
			{
				cattle = Cattle.valueOf("NA");
			}
			Users user = new Users(name.trim(), lastName.trim(), address, password.trim(), cattle, email.trim().toLowerCase(),newRole);
			Users savedUser = usersService.addUser(user);
			if (savedUser == null) {
				msg = "User is not added try again!!!!!!";
				flashMap.addFlashAttribute("Addmsg", msg);
			} else {
				msg = "user added successfull Name:" + savedUser.getName() + " " + savedUser.getLastName();
				flashMap.addFlashAttribute("Addmsg", msg);
			}

			return "redirect:/admin/viewAll";
		}

		catch (Exception e) {
			msg = "User is not added try again!!!!!!";
			
			flashMap.addFlashAttribute("Addmsg", msg);
			System.out.println(e.getMessage());
			return "redirect:/admin/viewAll";

		}
	}

	
@GetMapping("/UserDetails/{Id}")	
public String UserDetails(@PathVariable int Id,Model map)
{   System.out.println("id:"+Id);
  Users user = usersService.getById(Id);
  System.out.println(user.getImageUrl());
   map.addAttribute("user", user);
	return "/admin/UserDetails";
}
	@GetMapping("/DeleteUser/{id}")
	public String deleteUser(@PathVariable int id, RedirectAttributes flashMap) {
		System.out.println(id);
		String msg = "";

		try {
			usersService.deleteUser(id);
			msg = "user with id:" + id + "   deleted";
			flashMap.addFlashAttribute("deleteMsg", msg);

			return "redirect:/admin/viewAll";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = "user with id:" + id + "  not  deleted";
			flashMap.addFlashAttribute("deleteMsg", msg);
			return "redirect:/admin/viewAll";
		}

	}

	@GetMapping("/UpdateUser/{id}")
	public String UpdateUser(@PathVariable int id, Model map, RedirectAttributes flashMap) {
		try {System.out.println("In updateuser");
			Users user = usersService.getById(id);
			map.addAttribute("user", user);
			System.out.println(user);
			if(user.getRole().equals(Role.valueOf("ADMIN")))
			return "/admin/update";
			if(user.getRole().equals(Role.valueOf("USER"))) {
				System.out.println("In user role");
				return "/admin/update";
			}
		} catch (Exception e) {
			System.out.println("In catch updateuser");
			flashMap.addFlashAttribute("updateMsg", "invalid id plz try again");
			System.out.println(e.getMessage());
			return "redirect:/admin/viewAll";

		}
		return "redirect:/admin/viewAll";
	}

	@PostMapping("/UpdateUser/{id}")
	public String UpdateUser(@PathVariable int id, @RequestParam String name, @RequestParam String lastName,
			@RequestParam String password, @RequestParam String address, @RequestParam String email,String role,
			@RequestParam String cattleType, RedirectAttributes flashMap) {
		System.out.println("post update method");
		String updateMsg = "";
		try {
			Cattle cattle = Cattle.valueOf(cattleType.toUpperCase());
			Role newRole=Role.valueOf(role.toUpperCase());
			// String name, @NotBlank String lastName, String address, String mobileNo,
			// Cattle cattle,String email
			if(newRole.equals(Role.valueOf("ADMIN".toUpperCase().trim())))
			{
			
				cattle = Cattle.valueOf("NA");
			}
			Users user = new Users(name, lastName, address, password, cattle, email,newRole);
			Users updatedUser = usersService.updateUser(id, user);
			updateMsg = "user updated Id:" + id;
			
			if(user.getRole().equals(Role.valueOf("ADMIN"))) {
			flashMap.addFlashAttribute("updateMsg", updateMsg);
			return "redirect:/admin/viewAll";
			}
		 	if(user.getRole().equals(Role.valueOf("USER"))) {
		 		System.out.println("In userrole update user");
					flashMap.addFlashAttribute("updateMsg", updateMsg);
					return "redirect:/admin/viewAll";
					}
			
			
		} catch (Exception e) {
			updateMsg = "user updetion failed ";
			flashMap.addFlashAttribute("updateMsg", updateMsg);
			System.out.println(e.getMessage());
			return "redirect:/admin/viewAll";
		}
		return "redirect:/admin/viewAll";
	}
	


	@GetMapping("/setFate")
	public String setFate(Model map) {
		try {
			List<FatePrice> list = fateRateService.getAll();
			if (list == null)
				return "/admin/Home";
			else {
				map.addAttribute("list", list);
				return "/admin/setFate";
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return "/admin/Home";
		}

	}
	@PostMapping("/setFate")
     public String setFateRate(Model map)
     {
		return setFate(map);
     }

	@GetMapping("/updateFateRate/{id}")
	public String UpdateFateRate(@PathVariable int id, Model map) {
		System.out.println("get update fate rate");
		String msg = "";
		try {
			FatePrice rate = fateRateService.getById(id);
			map.addAttribute("rate", rate);
			return "/admin/updateFateRate";
		} catch (Exception e) {
			msg = "invalid id try again !!!!";
			map.addAttribute("msg", msg);
			System.out.println(e.getMessage());
			return "/admin/setFate";

		}
	}

	@PostMapping(value="/updateFateRate/{id}") 
	public String UpdateFateRate(@PathVariable int id, @RequestParam String fateRate, RedirectAttributes map) {
		
		System.out.println("post update fate rate"+"     rate="+fateRate+"    id"+id);
		String msg = "";
		try {
			double fateRate1=Double.parseDouble(fateRate);
			if(fateRate1<=0)
				throw new NumberFormatException();
			
			System.out.println("faterate"+fateRate);
			FatePrice rate = fateRateService.updateFateRate(id, fateRate1);
			if (rate == null) {
				msg = "invalid id try again !!!!";
				map.addFlashAttribute("msg", msg);
				return "redirect:/admin/setFate";
			}
			
			msg = "fateRate Updated !!!!";
			map.addFlashAttribute("msg", msg);
			return "redirect:/admin/setFate";
		} 
		catch (NumberFormatException e) {
			
			msg = "format  should be number and and fateRate must greater than 0 !!!!";
			map.addFlashAttribute("msg", msg);
					System.out.println(e.getMessage());
					return "redirect:/admin/setFate";
			
		}
		
		
		catch (Exception e) {
		msg = "invalid id try again !!!!";
	map.addFlashAttribute("msg", msg);
			System.out.println(e.getMessage());
			return "redirect:/admin/setFate";

		}
	}
	@GetMapping("/DayWiseDetails")
	public String DayWiseDetails()
	{
		
		return "/admin/viewDetailsDayWise";
	}
	@PostMapping("/DayWiseDetails")
	public String DayWiseDetails(@RequestParam String date,Model map)
	{
		System.out.println("Date :"+date);
		
		List<MilkCollection> list=milkService.getDayWiseDetails(LocalDate.parse(date));
		System.out.println(list);
		if(list.isEmpty()) {
			map.addAttribute("msg", "no any records found at date:"+date);
			return "/admin/viewDetailsDayWise";
	
		}
		double bill=list.stream().mapToDouble(p->p.getPrice()).sum();
		
		map.addAttribute("dayWiseList", list).addAttribute("totalBill", Math.round(bill));
		return "/admin/showDayWiseReport";
	}
	
	
	@GetMapping("/logout")
	public String adminLogout(HttpSession session,Model map,HttpServletResponse resp,HttpServletRequest request)
	{
		System.out.println("in log out");
		map.addAttribute("admin", session.getAttribute("admin")).addAttribute("user",session.getAttribute("user"));
		//invalidate session
		session.invalidate();
		//How to auto redirect the clnt to the  home page , after some dly ?
		//Http Resp : header  : refresh : dly in secs , url
		//API of HttpServletResponse : public void setHeader(String name,String val)
		System.out.println("ctx path "+request.getContextPath());
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		return "/admin/logout";//AVN : /WEB-INF/views/user/logout.jsp
	}
}
