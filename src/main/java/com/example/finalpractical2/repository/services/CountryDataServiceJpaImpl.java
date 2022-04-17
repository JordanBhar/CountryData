package com.example.finalpractical2.repository.services;


import com.example.finalpractical2.model.CountryData;
import com.example.finalpractical2.repository.CountryDataRepositoryJpa;
import com.example.finalpractical2.repository.CountryEntityJpa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryDataServiceJpaImpl implements CountryDataService {

    private final CountryDataRepositoryJpa countryDataRepositoryJpa;

    CountryDataServiceJpaImpl(CountryDataRepositoryJpa countryDataRepositoryJpa){
        this.countryDataRepositoryJpa = countryDataRepositoryJpa;
    }




    private static void copyFormToEntity(CountryData petData, CountryEntityJpa entityData){
        entityData.setId(petData.getId());
        entityData.setCountryName(petData.getCountryName());
        entityData.setContinent(petData.getContinent());
        entityData.setRegion(petData.getRegion());
        entityData.setSurfaceArea(entityData.getSurfaceArea());
        entityData.setPopulation(entityData.getPopulation());
    }

    private static void copyEntityToForm(CountryEntityJpa entityData, CountryData countryData){
        countryData.setId(entityData.getId());
        countryData.setCountryName(entityData.getCountryName());
        countryData.setContinent(entityData.getContinent());
        countryData.setRegion(entityData.getRegion());
        countryData.setSurfaceArea(entityData.getSurfaceArea());
        countryData.setPopulation(entityData.getPopulation());
    }


    @Override
    public List<CountryData> getAllCountryData() {
        List<CountryData> countryDataList = new ArrayList<>();
        List<CountryEntityJpa> dataList = countryDataRepositoryJpa.findAll();

        for(CountryEntityJpa country: dataList){
            CountryData countryData = new CountryData();
            copyEntityToForm(country, countryData);
            countryDataList.add(countryData);
        }
        return countryDataList;
    }

    @Override
    public CountryData getCountryData(int id) {

        Optional<CountryEntityJpa> query = countryDataRepositoryJpa.findById(id);
        if(query.isPresent()){
            CountryData countryForm = new CountryData();
            CountryEntityJpa countryEntity = query.get();
            copyEntityToForm(countryEntity, countryForm);
            return countryForm;
        }
        return null;

    }
}
