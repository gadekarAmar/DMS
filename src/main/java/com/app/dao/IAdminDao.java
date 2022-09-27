package com.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.pojos.Admin;

public interface IAdminDao extends CrudRepository<Admin, Integer>{

	Admin findByEmailAndPassword(String  uname,String password);
     @Query(value="select email from admin_tbl where email=?1",nativeQuery = true)
	 String findByEmail(String email);
	Admin getByEmail(String emailId);

}
