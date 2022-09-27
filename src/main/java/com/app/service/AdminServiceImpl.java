package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.dao.IUserDao;
import com.app.pojos.Admin;
import com.app.pojos.Users;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminDao adminDao;
	private IUserDao userDao;
	

	@Override
	public Admin authenticateAdmin(String uname, String password) {
		// TODO Auto-generated method stub
		return adminDao.findByEmailAndPassword(uname,password);
	}




}








