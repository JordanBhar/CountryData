package com.example.finalpractical2.repository.services;


import com.example.finalpractical2.model.CountryData;

import java.util.List;

public interface CountryDataService {

    List<CountryData> getAllCountryData();

    CountryData getCountryData(int id);

}
