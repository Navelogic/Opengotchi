package br.com.opengotchi.api.Util.DataLoader;

import br.com.opengotchi.api.Repository.ColorRepository;
import br.com.opengotchi.api.Util.Model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorDataLoader {

    @Autowired
    private ColorRepository colorRepository;

    public void load() {
        colorRepository.save(new Color(null, "Branco", "#FFFFFF"));
        colorRepository.save(new Color(null, "Preto", "#000000"));
        colorRepository.save(new Color(null, "Cinza", "#808080"));
        colorRepository.save(new Color(null, "Vermelho", "#FF0000"));
        colorRepository.save(new Color(null, "Azul", "#0000FF"));
        colorRepository.save(new Color(null, "Verde", "#008000"));
        colorRepository.save(new Color(null, "Amarelo", "#FFFF00"));
        colorRepository.save(new Color(null, "Rosa", "#FFC0CB"));
        colorRepository.save(new Color(null, "Roxo", "#800080"));
        colorRepository.save(new Color(null, "Marrom", "#A52A2A"));
        colorRepository.save(new Color(null, "Bege", "#F5F5DC"));
        colorRepository.save(new Color(null, "Laranja", "#FFA500"));
        colorRepository.save(new Color(null, "Vinho", "#8B0000"));
        colorRepository.save(new Color(null, "Dourado", "#FFD700"));
        colorRepository.save(new Color(null, "Prata", "#C0C0C0"));
        colorRepository.save(new Color(null, "Verde Limão", "#32CD32"));
        colorRepository.save(new Color(null, "Verde Escuro", "#006400"));
        colorRepository.save(new Color(null, "Azul Claro", "#ADD8E6"));
        colorRepository.save(new Color(null, "Azul Escuro", "#00008B"));
        colorRepository.save(new Color(null, "Lavanda", "#E6E6FA"));
        colorRepository.save(new Color(null, "Salmão", "#FA8072"));
        colorRepository.save(new Color(null, "Turquesa", "#40E0D0"));
        colorRepository.save(new Color(null, "Ciano", "#00FFFF"));
        colorRepository.save(new Color(null, "Magenta", "#FF00FF"));
        colorRepository.save(new Color(null, "Oliva", "#808000"));
        colorRepository.save(new Color(null, "Mostarda", "#FFDB58"));
        colorRepository.save(new Color(null, "Castanho", "#654321"));
        colorRepository.save(new Color(null, "Marfim", "#FFFFF0"));
        colorRepository.save(new Color(null, "Caqui", "#F0E68C"));
        colorRepository.save(new Color(null, "Camurça", "#C19A6B"));
        colorRepository.save(new Color(null, "Caramelo", "#D2691E"));
        colorRepository.save(new Color(null, "Amêndoa", "#EADDCA"));
        colorRepository.save(new Color(null, "Champanhe", "#F7E7CE"));
        colorRepository.save(new Color(null, "Pêssego", "#FFE5B4"));
        colorRepository.save(new Color(null, "Terracota", "#E2725B"));
        colorRepository.save(new Color(null, "Café", "#6F4E37"));
        colorRepository.save(new Color(null, "Chocolate", "#D2691E"));
        colorRepository.save(new Color(null, "Ameixa", "#DDA0DD"));
        colorRepository.save(new Color(null, "Cobre", "#B87333"));
        colorRepository.save(new Color(null, "Púrpura", "#9B30FF"));
        colorRepository.save(new Color(null, "Fúcsia", "#FF00FF"));
        colorRepository.save(new Color(null, "Areia", "#F4A460"));
        colorRepository.save(new Color(null, "Cenoura", "#ED9121"));
        colorRepository.save(new Color(null, "Azeitona", "#808000"));
        colorRepository.save(new Color(null, "Verde Musgo", "#8A9A5B"));
        colorRepository.save(new Color(null, "Coral", "#FF7F50"));
        colorRepository.save(new Color(null, "Cinza Claro", "#D3D3D3"));
        colorRepository.save(new Color(null, "Cinza Escuro", "#A9A9A9"));
        colorRepository.save(new Color(null, "Petróleo", "#006363"));
        colorRepository.save(new Color(null, "Esmeralda", "#50C878"));
        colorRepository.save(new Color(null, "Verde Água", "#00FF7F"));
        colorRepository.save(new Color(null, "Antracite", "#293133"));
        colorRepository.save(new Color(null, "Jade", "#00A86B"));
        colorRepository.save(new Color(null, "Verde Menta", "#98FF98"));
        colorRepository.save(new Color(null, "Azul Marinho", "#000080"));
        colorRepository.save(new Color(null, "Azul Céu", "#87CEEB"));
        colorRepository.save(new Color(null, "Azul Bebê", "#89CFF0"));
        colorRepository.save(new Color(null, "Cobalto", "#0047AB"));
        colorRepository.save(new Color(null, "Índigo", "#4B0082"));
        colorRepository.save(new Color(null, "Safira", "#0F52BA"));
        colorRepository.save(new Color(null, "Amora", "#8A2BE2"));
        colorRepository.save(new Color(null, "Azul Royal", "#4169E1"));
        colorRepository.save(new Color(null, "Pérola", "#F0EAD6"));
        colorRepository.save(new Color(null, "Cinza Azulado", "#7393B3"));
        colorRepository.save(new Color(null, "Verde Neve", "#E8F6EF"));
        colorRepository.save(new Color(null, "Verde Místico", "#317873"));
        colorRepository.save(new Color(null, "Rosa Choque", "#FF69B4"));
        colorRepository.save(new Color(null, "Rosa Pálido", "#F4C2C2"));
        colorRepository.save(new Color(null, "Magenta Escuro", "#8B008B"));
        colorRepository.save(new Color(null, "Cinza Chumbo", "#36454F"));
        colorRepository.save(new Color(null, "Amarelo Ouro", "#FFD700"));
        colorRepository.save(new Color(null, "Azul Esverdeado", "#4682B4"));
        colorRepository.save(new Color(null, "Rosa Quartzo", "#F7CAC9"));
        colorRepository.save(new Color(null, "Vermelho Rubi", "#9B111E"));
        colorRepository.save(new Color(null, "Laranja Fogo", "#FF4500"));
        colorRepository.save(new Color(null, "Verde Lima", "#BFFF00"));
        colorRepository.save(new Color(null, "Lilás", "#C8A2C8"));
        colorRepository.save(new Color(null, "Roxo Profundo", "#9400D3"));
        colorRepository.save(new Color(null, "Verde Pastel", "#77DD77"));
        colorRepository.save(new Color(null, "Verde Menta Suave", "#AAF0D1"));
        colorRepository.save(new Color(null, "Cinza Prata", "#C0C0C0"));
        colorRepository.save(new Color(null, "Verde Limão Claro", "#DFFF00"));
        colorRepository.save(new Color(null, "Vermelho Tomate", "#FF6347"));
        colorRepository.save(new Color(null, "Cinza Ardoise", "#708090"));
        colorRepository.save(new Color(null, "Azul Petróleo", "#013220"));
        colorRepository.save(new Color(null, "Amarelo Canário", "#FFFF99"));
        colorRepository.save(new Color(null, "Pardo", "#CD853F"));
        colorRepository.save(new Color(null, "Azul Gelo", "#DAF7F9"));
        colorRepository.save(new Color(null, "Laranja Escuro", "#FF8C00"));
        colorRepository.save(new Color(null, "Verde Abacate", "#568203"));
        colorRepository.save(new Color(null, "Rosa Antigo", "#DCAE96"));
        colorRepository.save(new Color(null, "Amarelo Bebê", "#FDFD96"));
        colorRepository.save(new Color(null, "Verde Fluorescente", "#39FF14"));
        colorRepository.save(new Color(null, "Turquesa Escuro", "#00CED1"));
        colorRepository.save(new Color(null, "Bronze", "#CD7F32"));
        colorRepository.save(new Color(null, "Rosa Fúcsia", "#FF77FF"));
        colorRepository.save(new Color(null, "Azul Elétrico", "#7DF9FF"));
        colorRepository.save(new Color(null, "Roxo Lavanda", "#E6E6FA"));
    }

}
