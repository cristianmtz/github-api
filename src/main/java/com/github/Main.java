package com.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.githubclient.controller.GithubController;
import com.github.githubclient.dto.RepoList;
import com.github.githubclient.dto.UserDetailsDto;

import java.io.IOException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    private enum Commad {

        USER_DETAILS,

        REPOS_DETAILS,

        HELP,

        EXIT
    }


    public static void main(String[] args) throws IOException, InterruptedException {


        GithubController githubController = new GithubController();
        Scanner scanner = new Scanner(System.in);

        String inputUser;
        boolean keepRunning = true;
        Commad commad;

        while (keepRunning) {

            System.out.print("github-activity>");
            commad = Commad.valueOf(scanner.nextLine().toUpperCase());


            switch (commad) {
                case USER_DETAILS:
                    System.out.println("Please enter the username");
                    inputUser = scanner.nextLine();
                    UserDetailsDto userDetailsDto = githubController.getUserDetails(inputUser);
                    if (userDetailsDto != null) {
                        System.out.println(userDetailsDto);
                    } else {
                        System.out.println("User not found or an error occurred.");
                    }
                    break;
                case REPOS_DETAILS:
                    System.out.println("Please enter the username");
                    inputUser = scanner.nextLine();
                    RepoList repositories = githubController.getReposDetails(inputUser);

                    if(repositories != null){
                        ObjectMapper mapper = new ObjectMapper();
                        mapper.enable(SerializationFeature.INDENT_OUTPUT);
                        String jsonString = mapper.writeValueAsString(repositories);
                        System.out.println(jsonString);
                    }else {
                        System.out.println("No repository details available or an error occurred.");
                    }
                    break;
                case HELP:
                    System.out.println("Available commands: USER_DETAILS, REPOS_DETAILS, HELP, EXIT");
                    break;
                case EXIT:
                    keepRunning = false;
                    break;

            }
        }
    }
}
