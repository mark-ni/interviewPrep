package com.example.servingwebcontent.service.builder;

import com.example.servingwebcontent.model.dto.country.Country;
import com.example.servingwebcontent.model.dto.country.CountryWrapperResponse;
import com.example.servingwebcontent.service.data.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryBuilder {

    public final CountryService countryService;

    public CountryBuilder(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> getCountries() {
        CountryWrapperResponse response = countryService.getCountries();
        return Optional.ofNullable(response)
                .map(CountryWrapperResponse::getData)
                .map(CountryWrapperResponse.CountryWrapperData::getObjects)
                .orElse(List.of());
    }
}
