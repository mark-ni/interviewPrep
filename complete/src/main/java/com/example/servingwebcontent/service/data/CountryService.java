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

    public CountryWrapperResponse getCountries(int offset, int limit) {
        return countryService.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .build())
                .header("Authorization", "scrubbed")
                .retrieve()
                .body(CountryWrapperResponse.class);
    }
}
