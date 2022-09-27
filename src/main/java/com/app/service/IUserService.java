package com.app.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin;
import com.app.pojos.MilkCollection;
import com.app.pojos.Users;

public interface IUserService  {
	Users findUserById(int user_id);

	Users findUserByIdAndName(int user_id, String name);

	List<Users> getAllUsers();

	Users addUser(Users user);

	void deleteUser(int id);

	 Users  getById(int id);

	Users updateUser(int id,Users user);

	Users getByIdAndSetName(int id, String name);

	Users authenticateUser(String username, String password);
	Users getByIdAndEmail(int id, String email);

	String changePassword(Integer id, String emailId, String password);

	List<MilkCollection> getCollectionBetweenDates(LocalDate parse, LocalDate parse2);

	

	
}
