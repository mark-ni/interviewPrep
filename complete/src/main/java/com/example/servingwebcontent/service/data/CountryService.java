package com.example.servingwebcontent.service.data;

import com.example.servingwebcontent.model.dto.country.CountryWrapperResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CountryService {
    private final RestClient countryService;

    public CountryService(@Qualifier("countryClient") RestClient countryService) {
        this.countryService = countryService;
    }

    public CountryWrapperResponse getCountries() {
        return countryService.get()
                .uri("")
                .header("Authorization", "Bearer rc_live_b8418777ee754a21ae787aa2d12b1936")
                .retrieve()
                .body(CountryWrapperResponse.class);
    }
}
