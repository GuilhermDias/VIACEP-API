package com.alura.guilherme.App;

import com.alura.guilherme.Models.CEP;
import com.alura.guilherme.Service.ConsultaCEP;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        ConsultaCEP consultaCEP = new ConsultaCEP();
        List<CEP> list = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        int op;

        do {
            System.out.println("[1] - Consultar CEP\n[2] - Gerar arquivo JSON\n[3] - Fim");
            System.out.print("Escolha sua opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    try {
                        System.out.print("Informe o CEP: ");
                        String endereco = sc.next();
                        CEP cep = consultaCEP.busca(endereco);
                        list.add(cep);
                        System.out.println(cep);
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    FileWriter fileWriter = new FileWriter("CEP.json");
                    fileWriter.write(gson.toJson(list));
                    fileWriter.close();
                    System.out.println("Arquivo criado");
                    break;
                case 3:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while(op != 3);

        sc.close();
    }
}