package com.sillas.Chamadas.para.Api.Externa.client;

import com.sillas.Chamadas.para.Api.Externa.controller.RepositoryResponse;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GitHubClient {

    @GetExchange("/user/repos")
    List<RepositoryResponse> listRepos(
            @RequestHeader("Authorization") String token,
            @RequestHeader(value = "X-GitHub-Api-Version", defaultValue = "2022-11-28") String apiVersion,
            @RequestParam(value = "visibility", defaultValue = "public") String visibility
    );

}
