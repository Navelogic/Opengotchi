package br.com.opengotchi.api.Util.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Imagem(
        @JsonAlias({"href", "url"}) String url
) {
}
