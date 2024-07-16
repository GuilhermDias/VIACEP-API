package com.alura.guilherme.Models;

import com.google.gson.Gson;

public record CEP(String cep, String logradouro, String bairro, String localidade, String uf) {
}
