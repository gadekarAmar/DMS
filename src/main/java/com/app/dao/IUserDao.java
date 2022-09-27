package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.MilkCollection;
import com.app.pojos.Users;

public interface IUserDao extends CrudRepository<Users, Integer>{
   Users findByNameAndId(String name,int user_id);

Users findByEmailAndPassword(String username, String password);

	Users findByIdAndEmail(int id,String trim);
    
   
}
