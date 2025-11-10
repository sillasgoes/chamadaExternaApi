package com.sillas.Chamadas.para.Api.Externa.controller;

import com.sillas.Chamadas.para.Api.Externa.service.GitHubClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GitHubController {

    private final GitHubClientService gitHubClientService;

    public GitHubController(GitHubClientService gitHubClientService) {
        this.gitHubClientService = gitHubClientService;
    }

    @GetMapping("/repos")
    ResponseEntity<List<RepositoryResponse>> getRepos(@RequestHeader(value = "token") String token){
        return ResponseEntity.ok(gitHubClientService.getRepos(token));
    }

}
