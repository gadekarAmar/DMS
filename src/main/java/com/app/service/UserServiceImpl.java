package com.app.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dao.IMilkDao;
import com.app.dao.IUserDao;
import com.app.pojos.MilkCollection;
import com.app.pojos.Users;

@Service
@Transactional
public class UserServiceImpl  implements IUserService{
@Autowired
private IUserDao userDao;
@Autowired
private IMilkDao milkDao;
	@Override
	public Users findUserById(int user_id) {
		// TODO Auto-generated method stub
	
	return userDao.findById(user_id).orElseThrow(()->new RuntimeException("invalid userid"));
	}
	@Override
	public Users findUserByIdAndName(int user_id, String name) {
		 
		return  userDao.findByNameAndId(name,user_id) ;
	}
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<Users>) userDao.findAll();
	}
	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}
	@Override
	public void deleteUser(int id) 
	{  
		
		//milkDao.deleteAllByUser(id);	
		userDao.deleteById(id);
		
		

	}
	@Override
	public Users getById(int id) {
		// TODO Auto-generated method stub
		Users user=userDao.findById(id).orElseThrow(() -> new RuntimeException("Invalid id!!!!"));
		return user;
	}
	@Override
	public Users updateUser(int id,Users user) {
		// TODO Auto-generated method stub
		Users userToUpdate=getById(id);
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setCattle(user.getCattle());
		userToUpdate.setRole(user.getRole());
		
		return userToUpdate;
	}
	@Override
	public Users getByIdAndSetName(int id, String name) {
		// TODO Auto-generated method stub
		Users user=getById(id);
		user.setImageUrl(name);
		return user;
	}
	@Override
	public Users authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPassword(username,password);
	}
	@Override
	public Users getByIdAndEmail(int id, String email) {
		// TODO Auto-generated method stub
				System.out.println("in admin service");
				Users ValidatedUser= userDao.findByIdAndEmail(id,email.trim());
				//System.out.println(ValidatedUser.getEmail()+" :eamid and id is:"+ValidatedUser.getId());
				return ValidatedUser;
	}
	@Override
	public String changePassword(Integer id, String emailId, String password) {
		// TODO Auto-generated method stub
		Users userToUpdatePassword=getByIdAndEmail(id,emailId);
		if(userToUpdatePassword==null)
			return "password not updated";
		else {
			userToUpdatePassword.setPassword(password);
			return "password Updated sucessfully";
		}
		
	}
	
	@Override
	public List<MilkCollection> getCollectionBetweenDates(LocalDate form,LocalDate to) {
		// TODO Auto-generated method stub
		return milkDao.findAllBetweenDates(form, to);
	}
	
	
	

}










