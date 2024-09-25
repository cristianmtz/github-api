package com.github.githubclient.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDetailsDto(

        String login,

        String html_url,

        Integer public_repos

) {
}
