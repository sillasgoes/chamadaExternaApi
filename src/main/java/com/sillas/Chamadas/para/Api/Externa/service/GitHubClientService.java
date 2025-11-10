package com.sillas.Chamadas.para.Api.Externa.service;


import com.sillas.Chamadas.para.Api.Externa.client.GitHubClient;
import com.sillas.Chamadas.para.Api.Externa.controller.RepositoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubClientService {

    private final GitHubClient  gitHubClient;

    public GitHubClientService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<RepositoryResponse> getRepos(String token){
        return gitHubClient.listRepos("Bearer " + token, null, "");
    }
}
