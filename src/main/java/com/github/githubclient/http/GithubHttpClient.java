package com.github.githubclient.http;


import com.github.githubclient.exception.ApiException;
import com.github.githubclient.exception.UserNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GithubHttpClient {


    private final HttpClient httpClient;

    public GithubHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String sendRequest(String uri) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return switch (response.statusCode()) {
            case 200 -> response.body();
            case 404 -> throw new UserNotFoundException("User not found: " + uri);
            default -> throw new ApiException("Error: " + response.statusCode() + " - " + response.body());
        };

    }
}
