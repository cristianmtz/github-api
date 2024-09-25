package com.github.githubclient.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.githubclient.dto.RepoDto;
import com.github.githubclient.dto.RepoList;
import com.github.githubclient.dto.UserDetailsDto;
import com.github.githubclient.exception.UserNotFoundException;
import com.github.githubclient.http.GithubHttpClient;


import java.io.IOException;
import java.util.List;

public class GithubService {

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/users/";
    private final GithubHttpClient githubHttpClient;

    private final ObjectMapper objectMapper;


    public GithubService(GithubHttpClient githubHttpClient, ObjectMapper objectMapper) {
        this.githubHttpClient = githubHttpClient;
        this.objectMapper = objectMapper;
    }

    public UserDetailsDto getUserDetails(String username) throws IOException, InterruptedException {

        String uri = GITHUB_API_BASE_URL + username;

        try {
            String response =  githubHttpClient.sendRequest(uri);
            return objectMapper.readValue(response, UserDetailsDto.class);
        }catch (UserNotFoundException e){
            return null;// or handle appropriately
        }
    }

    public RepoList getReposDetails(String username) throws IOException, InterruptedException {
        String uri = GITHUB_API_BASE_URL + username + "/repos";

        try {
            String response = githubHttpClient.sendRequest(uri);
            List<RepoDto> repositories = objectMapper.readValue(response, new TypeReference<List<RepoDto>>() {});
            return new RepoList(repositories);
        }catch (UserNotFoundException e){
            return null;
        }

    }

}

