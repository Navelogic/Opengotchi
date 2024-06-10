package br.com.opengotchi.api.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDados {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertJsonToObject(String json, Class<T> classe) {
        try {
            return objectMapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para objeto" + e.getMessage());
        }
    }
}
