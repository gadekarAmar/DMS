package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFateRateDao;
import com.app.pojos.Cattle;
import com.app.pojos.FatePrice;
@Service
@Transactional
public class fateRateService  implements IFateRateService{
@Autowired
private IFateRateDao fateRateDao;
	@Override
	public int FindRateByCattle(Cattle cattle) {
		// TODO Auto-generated method stub
		return fateRateDao.findByCattle(cattle);
	}
	@Override
	public List<FatePrice> getAll() {
		// TODO Auto-generated method stub
		return fateRateDao.findAll();
	}
	@Override
	public FatePrice getById(int id) {
		// TODO Auto-generated method stub
		FatePrice rate=fateRateDao.findById(id).orElseThrow();
		return rate;
	}
	@Override
	public FatePrice updateFateRate(int id, double fateRate) {
		// TODO Auto-generated method stub++
		FatePrice rate=fateRateDao.findById(id).orElseThrow();
		rate.setFateRate(fateRate);
		
		FatePrice rate1 =fateRateDao.save(rate);
		System.out.println(rate1);
		return rate1;
	}

}
