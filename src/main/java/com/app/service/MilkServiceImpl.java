package com.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IMilkDao;
import com.app.pojos.MilkCollection;
import com.app.pojos.Session;
import com.app.pojos.Users;

@Service
@Transactional
public class MilkServiceImpl implements IMilkService {
	@Autowired
	private IMilkDao milkDao;

	@Override
	public MilkCollection SaveMilkCollection(MilkCollection collection) {
		System.out.println("in milk service layer");
		
			MilkCollection milkcollction = milkDao.save(collection);
			return milkcollction;
			
		
		
		
	}

	@Override
	public List<MilkCollection> findByIdAndDate(LocalDate startDate,LocalDate endDate,Users user) 
	{ 
		System.out.println("in milk service layer");
		return milkDao.findByDateBetween(startDate, endDate,user);
	}

	@Override
	public List<MilkCollection> getDayWiseDetails(LocalDate date) {
		// TODO Auto-generated method stub
		return milkDao.findByDate(date);
	}

	@Override
	public MilkCollection getbyUserDateAndSession(Users user, LocalDate entryDate, Session session,MilkCollection collection) {
		// TODO Auto-generated method stub
		
		MilkCollection collectionToUpdate=milkDao.findbyDateUserAndSession(user,entryDate,session);
		collectionToUpdate.setFate(collection.getFate());
		collectionToUpdate.setLiter(collection.getLiter());
		collectionToUpdate.setSession(collection.getSession());
		collectionToUpdate.setPrice(collection.getFate()*collection.getLiter()*collection.getFateRate());
		
		return collectionToUpdate;
	}

	@Override
	public List<MilkCollection> getbyUserAndDate(Users user, LocalDate from, LocalDate to) {
	List<MilkCollection>list=milkDao.findByUserAndDate(user,from,to);
		return list;
	}

}
