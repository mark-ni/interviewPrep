package com.example.servingwebcontent.model.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryWrapperResponse {

    private CountryWrapperData data;

    @Data
    public class CountryWrapperData {
        private List<Country> objects;
    }
}
