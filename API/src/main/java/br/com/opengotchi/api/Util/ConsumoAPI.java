package br.com.opengotchi.api.Util;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obterDadosAPI(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao obter dados da API" + e.getMessage());
        }
        return response.body();
    }
}
