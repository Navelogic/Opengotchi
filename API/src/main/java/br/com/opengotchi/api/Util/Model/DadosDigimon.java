package br.com.opengotchi.api.Util.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDigimon(
        @JsonAlias("id") String id,
        @JsonAlias("name") String nome,
        @JsonAlias("xAntibody") String xAntibody,
        @JsonAlias("releaseDate") String DataLancamento,
        @JsonAlias("images") List<Imagem> imagens
) {
}