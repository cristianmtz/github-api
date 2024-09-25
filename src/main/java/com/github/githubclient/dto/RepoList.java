package com.github.githubclient.dto;

import java.util.List;

public record RepoList(
        List<RepoDto> repositories
) {

    @Override
    public String toString() {
        return "RepoList{" +
                "repositories=" + repositories +
                '}';
    }
}
