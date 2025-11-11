package com.viacep.challenge.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.viacep.challenge.domain.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaCep {
    Scanner scan = new Scanner (System.in);
    private int numeroCep = -1;
    private String url;
    List<Endereco> cep = new ArrayList<>();

    public void menuCep()throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        while(numeroCep != 0){
            System.out.println("informe o cep que deseja consultar: ");
            this.numeroCep = scan.nextInt();
            if (numeroCep == 0){
                break;
            }
            this.url = "https://viacep.com.br/ws/"+numeroCep+"/json/";


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest resquest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(resquest, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
//              System.out.println(json);

            CepViaCep meuCepViaCep = gson.fromJson(json, CepViaCep.class);
            Endereco endereco = new Endereco(meuCepViaCep);
            cep.add(endereco);


        }
        FileWriter salveArquivo = new FileWriter("enderecos.json");
        salveArquivo.write(gson.toJson(cep));
        salveArquivo.close();

        System.out.println("encerrando com sucesso");

    }

//    public void buscaCep() throws IOException, InterruptedException {
//
//
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest resquest = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .build();
//            HttpResponse<String> response = client
//                    .send(resquest, HttpResponse.BodyHandlers.ofString());
//
//                String json = response.body();
////              System.out.println(json);
//
//            CepViaCep meuCepViaCep = gson.fromJson(json, CepViaCep.class);
//            Endereco endereco = new Endereco(meuCepViaCep);
//            cep.add(endereco);
    //  }

}
