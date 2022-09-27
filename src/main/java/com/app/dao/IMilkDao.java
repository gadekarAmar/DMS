package com.app.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.pojos.MilkCollection;
import com.app.pojos.Session;
import com.app.pojos.Users;

public interface IMilkDao extends CrudRepository<MilkCollection, Integer> {

	@Query("select m from MilkCollection m where m.date between ?1 and ?2 and m.user=?3")

	List<MilkCollection> findByDateBetween(LocalDate startDate, LocalDate endDate,Users user);
	//select id,sum(price) from milk_tbl where date between '2022-01-01' and '2022-07-11' and user_id=1 group by user_id;
	//querryy to find out sum
	@Query(value = "delete from milk_tbl where user_id=?1",nativeQuery = true)
	void deleteAllByUser(int  id);
	List<MilkCollection> findByDate(LocalDate date);
	@Query(value="select m from MilkCollection m where m.user=?1 and m.date=?2 and m.session=?3")
	MilkCollection findbyDateUserAndSession(Users user, LocalDate entryDate, Session session);
	@Query("select m from MilkCollection m where m.date between ?1 and ?2 ")
	List<MilkCollection> findAllBetweenDates(LocalDate form, LocalDate to);
	@Query("select m from MilkCollection m where m.user=?1 and m.date between ?2 and ?3")
	List<MilkCollection> findByUserAndDate(Users user, LocalDate from, LocalDate to);

}
