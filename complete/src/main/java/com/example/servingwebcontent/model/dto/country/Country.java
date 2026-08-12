package com.example.servingwebcontent.model.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private CountryName names;
    private Map<String, String> codes;
    private List<Capital> capitals;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Capital {
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CountryName {
        private List<String> alternates;
        private String common;
        private String official;
    }

    @Override
    public String toString() {
        String common = Optional.of(names)
                .map(CountryName::getCommon)
                .orElse("");
        return Optional.ofNullable(capitals)
                .stream()
                .flatMap(Collection::stream)
                .findFirst()
                .map(Capital::getName)
                .map((capital) -> capital + ", " + common)
                .orElse(common);
    }
}
