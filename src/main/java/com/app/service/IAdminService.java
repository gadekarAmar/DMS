package com.app.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Users;


public interface IAdminService {

	Admin authenticateAdmin(String uname, String password);

	

	

}
