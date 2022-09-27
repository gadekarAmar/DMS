package com.app.service;

import java.util.List;

import com.app.pojos.Cattle;
import com.app.pojos.FatePrice;

public interface IFateRateService {
  int FindRateByCattle(Cattle cattle);

List<FatePrice> getAll();

FatePrice getById(int id);


FatePrice updateFateRate(int id, double fateRate);
}
