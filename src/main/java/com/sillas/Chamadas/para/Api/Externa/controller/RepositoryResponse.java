package com.sillas.Chamadas.para.Api.Externa.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
Aqui nos temos um record que vai mapear o retorno da API,
Aqui usamos o JsonProperty que vai nos possibilitar mapear do Json o nome do campo
e aqui dentro colocarmos o nome que quisermos, no caso abaixo a api tem um campo "Private"
que no java é palavra reservada no caso, indicamos o nome do campo vindo do Json
e depois colocamos o nome que quisermos para trabalhamos dentro da interface
 */

public record RepositoryResponse(
        String id,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("private") boolean isPrivate) {
}
