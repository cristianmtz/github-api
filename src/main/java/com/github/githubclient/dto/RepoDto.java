package com.github.githubclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RepoDto(

        @JsonProperty("full_name")
        String fullName,

        @JsonProperty("html_url")
        String htmlUrl,

        String description,
        String language,

        @JsonProperty("stargazers_count")
        int stargazersCount,

        @JsonProperty("forks_count")
        int forksCount,

        @JsonProperty("open_issues_count")
        int openIssuesCount,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("updated_at")
        String updatedAt
) {

        @Override
        public String toString() {
                return "RepoDto{" +
                        "fullName='" + fullName + '\'' +
                        ", htmlUrl='" + htmlUrl + '\'' +
                        ", description='" + description + '\'' +
                        ", language='" + language + '\'' +
                        ", stargazersCount=" + stargazersCount +
                        ", forksCount=" + forksCount +
                        ", openIssuesCount=" + openIssuesCount +
                        ", createdAt='" + createdAt + '\'' +
                        ", updatedAt='" + updatedAt + '\'' +
                        '}';
        }
}
