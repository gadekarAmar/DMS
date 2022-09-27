package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Cattle;
import com.app.pojos.FatePrice;

public interface IFateRateDao extends JpaRepository<FatePrice, Integer>{
 @Query("select f.fateRate from FatePrice f where f.cattle=?1")
 int findByCattle(Cattle cattle);
}
