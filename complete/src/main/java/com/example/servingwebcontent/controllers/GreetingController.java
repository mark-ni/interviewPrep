package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.model.dto.country.Country;
import com.example.servingwebcontent.service.builder.CountryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
    private CountryBuilder countryBuilder;

	@GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		String countries = countryBuilder.getCountries().stream()
				.map(Country::toString)
				.reduce((A, B) -> A + "\n" + B)
				.orElse("");

		model.addAttribute("countries", countries);
		return "greeting";
	}
}
