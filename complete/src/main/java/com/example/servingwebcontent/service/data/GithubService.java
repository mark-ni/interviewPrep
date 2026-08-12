package com.example.servingwebcontent.service.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GithubService {

    private final RestClient githubService;

    public GithubService(@Qualifier("githubClient") RestClient githubService) {
        this.githubService = githubService;
    }
}
