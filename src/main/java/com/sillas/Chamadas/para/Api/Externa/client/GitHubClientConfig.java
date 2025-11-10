package com.sillas.Chamadas.para.Api.Externa.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class GitHubClientConfig {

    /*
    Aqui criaremos o client para armazenar o endereço rais da chamada API,
    ou seja, vamos precisar apenas indicar os caminhos adjacentes em cada controller
    Controler de "User" vai usar o caminho "/user" o resto o nosso client abaixo vai indicar
    na chamada criando assim uma estrutura mais dinamica e segura
     */
    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();

        return HttpServiceProxyFactory
                 .builderFor(WebClientAdapter
                        .create(webClient)).build();
    }

    /*
    Aqui em baixo indicamos que Bean vai criar toda a vez que chamarmos a interface
    GiHubClient a configuração acima vai ser chamada como padrão, sempre indicando
    o caminho raiz da chamada API, antes das nossas @RequestMapping
    EX: https://api.github.com/*** o caminho que você solicitar na controller

     */

    @Bean
    public GitHubClient gitHubClient(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GitHubClient.class);
    }
}
