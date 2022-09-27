package com.app.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.app.pojos.Cattle;
import com.app.pojos.MilkCollection;
import com.app.pojos.Role;
import com.app.pojos.Session;
import com.app.pojos.Users;
import com.app.service.IFateRateService;
import com.app.service.IMilkService;
import com.app.service.IUserService;

@Controller
//@Transactional
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IMilkService milkService;
	@Autowired
	private IFateRateService fateRateService;

	public UserController() {
		System.out.println("in customer controller");
	}

	@GetMapping("/showForm")
	public String showForm() {

		System.out.println("in showForm");
		return "/customer/showForm";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String uname, @RequestParam String password, Model map,HttpSession session) {

		/*
		 * System.out.println("in processLoginForm user" + uname + "  pass:" +
		 * password); String msg = ""; Admin admin =
		 * adminService.authenticateAdmin(uname.trim(), password.trim()); //
		 * System.out.println(admin.getEmail());
		 * 
		 * if (admin == null) { msg =
		 * "You have Entred wrong usrname or password , please try again!!!!!!!!";
		 * map.addAttribute("LoginMsg", msg); return "/admin/login"; } else { msg =
		 * "Sucessfully loged in !!!!!!!!"; map.addAttribute("msg",
		 * msg).addAttribute("admin", admin); session.setAttribute("admin", admin);
		 * return "/admin/Home"; }
		 */
		return "/admin/login";	
	}


	@PostMapping(("/showForm"))
	public String processForm(@RequestParam String dailyDate, @RequestParam int user_id, @RequestParam String fate,
			@RequestParam String liter, @RequestParam String session ,RedirectAttributes map,HttpSession hs) {

		System.out.println("in process form in");
		// (Session session, @NotBlank double liter, @NotBlank double fate, @NotBlank
		// double fateRate,
		// Users user,LocalDate date)
		
		
		MilkCollection collection=new MilkCollection();
		Users user =new Users();
		String msg="";
		try {
			System.out.println("fate:"+fate+"     liter:"+liter);
			double fate1=Double.parseDouble(fate);
			double liter1=Double.parseDouble(liter);
			if(fate1<=0 || liter1<=0)
				throw new NumberFormatException();
			 user = userService.findUserById(user_id);
			System.out.println(user);
			Cattle cattle = user.getCattle();
			Role role=user.getRole();
           if(cattle.equals(Cattle.valueOf("NA")) || role.equals(Role.valueOf("ADMIN")))
           {    msg="not allowed to add entry since user's role<br> is admin or cattle type is not applicable";
        	   map.addFlashAttribute("Milkmsg", msg);
        	   return "redirect:/customer/showForm";
           }
           
			int fateRate = fateRateService.FindRateByCattle(cattle);

			 collection = new MilkCollection(Session.valueOf(session), liter1, fate1, fateRate, user,
					LocalDate.parse(dailyDate));

			MilkCollection milkcollection = milkService.SaveMilkCollection(collection);
			// milkcollection.setUser(user);
			System.out.println(milkcollection);
			System.out.println("process form ended");
			msg="milk entry added";
			map.addFlashAttribute("Milkmsg", msg);
			return "redirect:/customer/showForm";

		} catch (NumberFormatException e) {
			 msg="fate and milk in liter should be in number and greater than 0";
      	   map.addFlashAttribute("Milkmsg", msg);
      	   return "redirect:/customer/showForm";
		}
		
		
		
		
		catch (Exception e) {
			
			System.out.println("in controller catch");
			if(user.getId()==null)
	           {
	        	   msg="user not found with id:"+user_id;
	        	   map.addFlashAttribute("Milkmsg", msg);
	        	   return "redirect:/customer/showForm";
	           }
			msg="Duplicate entry found plz check<br>Do you want to update this record <br>1)<a  href='/project/customer/updateRecord'>Yes</a ><br>2)<a href='/project/customer/showForm'>No</a>";
			map.addFlashAttribute("Milkmsg", msg);
			hs.setAttribute("collection", collection);
			return "redirect:/customer/showForm";

		}
		
	}
	
	@GetMapping("/details")
	public String userDetails(HttpSession session){
		Users user=(Users)session.getAttribute("user");
		System.out.println("In user dertails");
		return "/customer/details";
	}
	
	
	
   @GetMapping("/updateRecord")
   public String updateRecord(HttpSession hs,RedirectAttributes map)
   {  
	   String msg="";
	   try {MilkCollection collection=(MilkCollection) hs.getAttribute("collection");
	   System.out.println(collection);
	   
	   MilkCollection collectionToUpdate=milkService.getbyUserDateAndSession(collection.getUser(),collection.getDate(),collection.getSession(),collection);
	   System.out.println(collectionToUpdate);
	   msg="collection updated of user :"+collection.getUser().getName()+" "+collection.getUser().getLastName();
	   map.addFlashAttribute("Milkmsg", msg);
	   return "redirect:/customer/showForm";
		
	} catch (Exception e) {
		msg="not updated";
		 map.addFlashAttribute("Milkmsg", msg);
		return "redirect:/customer/showForm";
	}
	   
   }
	@GetMapping("/bill")
	public String showBillingPage() {
		System.out.println("in billing page");
		return "/customer/bill";
	}

	@PostMapping("/bill")
	public String processBill(@RequestParam int user_id, @RequestParam String name, @RequestParam String form,
			@RequestParam String to, Model map, HttpSession session) {
		System.out.println(name + user_id);
		Users user = userService.findUserByIdAndName(user_id, name.trim());
		System.out.println(user);
		System.out.println(form + " " + to);
		// System.out.println("user in billing page" + user);
		if (user == null) {
			String Msg = "User id And Username is Not Valid!!!!!!!!!!! plz try again with valid details";
			map.addAttribute("Billmsg", Msg);
			return "/customer/bill";
		}else if (user.getRole().equals(Role.valueOf("ADMIN"))){
			String Msg = "Id :"+user.getId()+" belongs to admin.. ";
			map.addAttribute("Billmsg", Msg);
			return "/customer/bill";
			
		}

		else {
			String msg = "User name:" + name + "  " + "User Id:" + user_id;

			List<MilkCollection> list = milkService.findByIdAndDate(LocalDate.parse(form), LocalDate.parse(to), user);

			System.out.println("list :" + list);

			// session.setAttribute("milklist", list);

			double bill = list.stream().mapToDouble(p -> p.getPrice()).sum();

			System.out.println("sum is :" + bill);
			String emailBody = "<table border='1'style='border-collapse:collapse' ><tr><th>Date</th><th>Session</th><th>Milk in Liters</th><th>fate</th><th>fateRate</th><th>Total price</th></tr>";
			for (MilkCollection m : list) {
				emailBody += "<tr><td>" + m.getDate() + "</td><td>" + m.getSession() + "</td><td>" + m.getLiter()
						+ "</td><td>" + m.getFate() + "</td><td>" + m.getFateRate() + "</td><td>" + m.getPrice()
						+ "</td><tr>";
			}
			emailBody += "<tr'><td></td><td></td><td></td><td></td><td>" + bill + "rs</td></tr>";
			emailBody += "</table>";
			map.addAttribute("user", user).addAttribute("msg", msg).addAttribute("startDate", form)
					.addAttribute("endDate", to).addAttribute("milklist", list).addAttribute("bill", bill)
					.addAttribute("emailBody", emailBody);
			return "/customer/finalbill";
		}
	}

	@GetMapping("/viewAll")
	public String viewAllUsers() {
		return "/admin/viewAll";
	}
	
	@GetMapping("/milkReport/{id}")
	public String milkReport(@PathVariable int id){
		
		System.out.println("ID:"+id);
		
		return "/customer/userbill";
	}
	
	@PostMapping("/milkReport/{id}")
	public String milkReport(@PathVariable int id,@RequestParam String from,@RequestParam String to,HttpSession session,Model map){
		System.out.println("from"+from+" to "+to);
		System.out.println("ID:"+id);
		Users user=(Users)session.getAttribute("user");
		try { 
			
			if(user==null) {
				return "/customer/userbill";
			}
			List<MilkCollection>list=milkService.getbyUserAndDate(user,LocalDate.parse(from),LocalDate.parse(to));
			System.out.println(list);
			if(list.isEmpty()) {
				map.addAttribute("userBill","User bill list is Empty..");
				return "/customer/userbill";
			}
			if(list!=null) {
				double bill = list.stream().mapToDouble(p -> p.getPrice()).sum();
				map.addAttribute("milklist",list).addAttribute("bill",bill);
				return "/customer/billDetails";
				}
			
			
		} catch (Exception e) {
		
		}
	
		return "/customer/userbill";
	}
	
}
