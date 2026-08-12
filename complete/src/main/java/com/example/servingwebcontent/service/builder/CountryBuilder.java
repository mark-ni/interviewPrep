package com.example.servingwebcontent.service.builder;

import com.example.servingwebcontent.model.dto.country.Country;
import com.example.servingwebcontent.model.dto.country.CountryWrapperResponse;
import com.example.servingwebcontent.service.data.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component
public class CountryBuilder {

    public final CountryService countryService;

    private static final int PAGINATION_SIZE = 25;

    public CountryBuilder(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> getCountries() {
        int offset = 0;
        List<Country> countries = new LinkedList<Country>();
        List<Country> countriesPage;

        do {
            CountryWrapperResponse response = countryService.getCountries(offset, PAGINATION_SIZE);
            countriesPage = Optional.ofNullable(response)
                    .map(CountryWrapperResponse::getData)
                    .map(CountryWrapperResponse.CountryWrapperData::getObjects)
                    .orElse(List.of());
            countries.addAll(countriesPage);
            offset += PAGINATION_SIZE;
        } while (offset < 600 && !CollectionUtils.isEmpty(countriesPage));

        return countries;
    }
}
