package com.example.finalpractical2.controller;



import com.example.finalpractical2.model.CountryData;
import com.example.finalpractical2.repository.services.CountryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CountryDataController {

    private final Logger logger = LoggerFactory.getLogger(CountryDataController.class);
    private final CountryDataService countryDataService;


    public CountryDataController(CountryDataService countryDataService) {
        this.countryDataService = countryDataService;
    }

    //List Navigation
    @GetMapping(value={"/", "/country-list"})
    public ModelAndView petList(){
        logger.trace("pet-list is called");
        List<CountryData> countryDataList = countryDataService.getAllCountryData();
        return new ModelAndView("CountryList", "country" , countryDataList);
    }


    //Details Navigation
    @GetMapping("/country-details")
    public ModelAndView editPet(@RequestParam String id , Model model){
        logger.trace("pet-edit is called");
        CountryData countryData = countryDataService.getCountryData(Integer.parseInt(id));
        return new ModelAndView("CountryDetails", "countryData" , countryData);
    }

}
