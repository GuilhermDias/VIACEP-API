package com.alura.guilherme.Service;

import com.alura.guilherme.Models.CEP;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public CEP busca(String cep){
        URI url = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder().uri(url).build();
        try {
           HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CEP.class);
        } catch(Exception exception){
            throw new RuntimeException("Erro na API");
        }

    }
}
