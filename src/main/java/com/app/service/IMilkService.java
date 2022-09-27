package com.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.pojos.MilkCollection;
import com.app.pojos.Session;
import com.app.pojos.Users;

@Repository
public interface IMilkService {

MilkCollection SaveMilkCollection(MilkCollection collection);
/*
 * List<MilkCollection> findByIdAndDate(LocalDate startDate,LocalDate endDate);
 */

List<MilkCollection> findByIdAndDate(LocalDate startDate, LocalDate endDate,Users user);

List<MilkCollection> getDayWiseDetails(LocalDate date);

MilkCollection getbyUserDateAndSession(Users users, LocalDate entryDate, Session session, MilkCollection collection);

List<MilkCollection> getbyUserAndDate(Users user, LocalDate from, LocalDate to);
}
