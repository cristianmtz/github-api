package com.github.githubclient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.githubclient.dto.RepoList;
import com.github.githubclient.dto.UserDetailsDto;
import com.github.githubclient.http.GithubHttpClient;
import com.github.githubclient.service.GithubService;

import java.io.IOException;


public class GithubController {


    GithubHttpClient githubHttpClient =  new GithubHttpClient();

    ObjectMapper objectMapper = new ObjectMapper();
    GithubService githubService = new GithubService(githubHttpClient, objectMapper);

    public UserDetailsDto getUserDetails(String username) throws IOException, InterruptedException {
        return githubService.getUserDetails(username);
    }

    public RepoList getReposDetails(String username) throws IOException, InterruptedException {
        return githubService.getReposDetails(username);
    }
}
