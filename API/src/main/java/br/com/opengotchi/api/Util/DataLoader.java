package br.com.opengotchi.api.Util;

import br.com.opengotchi.api.Repository.CorRepository;
import br.com.opengotchi.api.Repository.PersonalidadeRepository;
import br.com.opengotchi.api.Util.Model.Cor;
import br.com.opengotchi.api.Util.Model.Personalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CorRepository corRepository;
    private final PersonalidadeRepository personalidadeRepository;

    @Autowired
    public DataLoader(CorRepository corRepository, PersonalidadeRepository personalidadeRepository) {
        this.corRepository = corRepository;
        this.personalidadeRepository = personalidadeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Cores disponíveis no sistema
        corRepository.save(new Cor(null, "Branco", "#FFFFFF"));
        corRepository.save(new Cor(null, "Preto", "#000000"));
        corRepository.save(new Cor(null, "Cinza", "#808080"));
        corRepository.save(new Cor(null, "Vermelho", "#FF0000"));
        corRepository.save(new Cor(null, "Azul", "#0000FF"));
        corRepository.save(new Cor(null, "Verde", "#008000"));
        corRepository.save(new Cor(null, "Amarelo", "#FFFF00"));
        corRepository.save(new Cor(null, "Rosa", "#FFC0CB"));
        corRepository.save(new Cor(null, "Roxo", "#800080"));
        corRepository.save(new Cor(null, "Marrom", "#A52A2A"));
        corRepository.save(new Cor(null, "Bege", "#F5F5DC"));
        corRepository.save(new Cor(null, "Laranja", "#FFA500"));
        corRepository.save(new Cor(null, "Vinho", "#8B0000"));
        corRepository.save(new Cor(null, "Dourado", "#FFD700"));
        corRepository.save(new Cor(null, "Prata", "#C0C0C0"));
        corRepository.save(new Cor(null, "Verde Limão", "#32CD32"));
        corRepository.save(new Cor(null, "Verde Escuro", "#006400"));
        corRepository.save(new Cor(null, "Azul Claro", "#ADD8E6"));
        corRepository.save(new Cor(null, "Azul Escuro", "#00008B"));
        corRepository.save(new Cor(null, "Lavanda", "#E6E6FA"));
        corRepository.save(new Cor(null, "Salmão", "#FA8072"));
        corRepository.save(new Cor(null, "Turquesa", "#40E0D0"));
        corRepository.save(new Cor(null, "Ciano", "#00FFFF"));
        corRepository.save(new Cor(null, "Magenta", "#FF00FF"));
        corRepository.save(new Cor(null, "Oliva", "#808000"));
        corRepository.save(new Cor(null, "Mostarda", "#FFDB58"));
        corRepository.save(new Cor(null, "Castanho", "#654321"));
        corRepository.save(new Cor(null, "Marfim", "#FFFFF0"));
        corRepository.save(new Cor(null, "Caqui", "#F0E68C"));
        corRepository.save(new Cor(null, "Camurça", "#C19A6B"));
        corRepository.save(new Cor(null, "Caramelo", "#D2691E"));
        corRepository.save(new Cor(null, "Amêndoa", "#EADDCA"));
        corRepository.save(new Cor(null, "Champanhe", "#F7E7CE"));
        corRepository.save(new Cor(null, "Pêssego", "#FFE5B4"));
        corRepository.save(new Cor(null, "Terracota", "#E2725B"));
        corRepository.save(new Cor(null, "Café", "#6F4E37"));
        corRepository.save(new Cor(null, "Chocolate", "#D2691E"));
        corRepository.save(new Cor(null, "Ameixa", "#DDA0DD"));
        corRepository.save(new Cor(null, "Cobre", "#B87333"));
        corRepository.save(new Cor(null, "Púrpura", "#9B30FF"));
        corRepository.save(new Cor(null, "Fúcsia", "#FF00FF"));
        corRepository.save(new Cor(null, "Areia", "#F4A460"));
        corRepository.save(new Cor(null, "Cenoura", "#ED9121"));
        corRepository.save(new Cor(null, "Azeitona", "#808000"));
        corRepository.save(new Cor(null, "Verde Musgo", "#8A9A5B"));
        corRepository.save(new Cor(null, "Coral", "#FF7F50"));
        corRepository.save(new Cor(null, "Cinza Claro", "#D3D3D3"));
        corRepository.save(new Cor(null, "Cinza Escuro", "#A9A9A9"));
        corRepository.save(new Cor(null, "Petróleo", "#006363"));
        corRepository.save(new Cor(null, "Esmeralda", "#50C878"));
        corRepository.save(new Cor(null, "Verde Água", "#00FF7F"));
        corRepository.save(new Cor(null, "Antracite", "#293133"));
        corRepository.save(new Cor(null, "Jade", "#00A86B"));
        corRepository.save(new Cor(null, "Verde Menta", "#98FF98"));
        corRepository.save(new Cor(null, "Azul Marinho", "#000080"));
        corRepository.save(new Cor(null, "Azul Céu", "#87CEEB"));
        corRepository.save(new Cor(null, "Azul Bebê", "#89CFF0"));
        corRepository.save(new Cor(null, "Cobalto", "#0047AB"));
        corRepository.save(new Cor(null, "Índigo", "#4B0082"));
        corRepository.save(new Cor(null, "Safira", "#0F52BA"));
        corRepository.save(new Cor(null, "Amora", "#8A2BE2"));
        corRepository.save(new Cor(null, "Azul Royal", "#4169E1"));
        corRepository.save(new Cor(null, "Pérola", "#F0EAD6"));
        corRepository.save(new Cor(null, "Cinza Azulado", "#7393B3"));
        corRepository.save(new Cor(null, "Verde Neve", "#E8F6EF"));
        corRepository.save(new Cor(null, "Verde Místico", "#317873"));
        corRepository.save(new Cor(null, "Rosa Choque", "#FF69B4"));
        corRepository.save(new Cor(null, "Rosa Pálido", "#F4C2C2"));
        corRepository.save(new Cor(null, "Magenta Escuro", "#8B008B"));
        corRepository.save(new Cor(null, "Cinza Chumbo", "#36454F"));
        corRepository.save(new Cor(null, "Amarelo Ouro", "#FFD700"));
        corRepository.save(new Cor(null, "Azul Esverdeado", "#4682B4"));
        corRepository.save(new Cor(null, "Rosa Quartzo", "#F7CAC9"));
        corRepository.save(new Cor(null, "Vermelho Rubi", "#9B111E"));
        corRepository.save(new Cor(null, "Laranja Fogo", "#FF4500"));
        corRepository.save(new Cor(null, "Verde Lima", "#BFFF00"));
        corRepository.save(new Cor(null, "Lilás", "#C8A2C8"));
        corRepository.save(new Cor(null, "Roxo Profundo", "#9400D3"));
        corRepository.save(new Cor(null, "Verde Pastel", "#77DD77"));
        corRepository.save(new Cor(null, "Verde Menta Suave", "#AAF0D1"));
        corRepository.save(new Cor(null, "Cinza Prata", "#C0C0C0"));
        corRepository.save(new Cor(null, "Verde Limão Claro", "#DFFF00"));
        corRepository.save(new Cor(null, "Vermelho Tomate", "#FF6347"));
        corRepository.save(new Cor(null, "Cinza Ardoise", "#708090"));
        corRepository.save(new Cor(null, "Azul Petróleo", "#013220"));
        corRepository.save(new Cor(null, "Amarelo Canário", "#FFFF99"));
        corRepository.save(new Cor(null, "Pardo", "#CD853F"));
        corRepository.save(new Cor(null, "Azul Gelo", "#DAF7F9"));
        corRepository.save(new Cor(null, "Laranja Escuro", "#FF8C00"));
        corRepository.save(new Cor(null, "Verde Abacate", "#568203"));
        corRepository.save(new Cor(null, "Rosa Antigo", "#DCAE96"));
        corRepository.save(new Cor(null, "Amarelo Bebê", "#FDFD96"));
        corRepository.save(new Cor(null, "Verde Fluorescente", "#39FF14"));
        corRepository.save(new Cor(null, "Turquesa Escuro", "#00CED1"));
        corRepository.save(new Cor(null, "Bronze", "#CD7F32"));
        corRepository.save(new Cor(null, "Rosa Fúcsia", "#FF77FF"));
        corRepository.save(new Cor(null, "Azul Elétrico", "#7DF9FF"));
        corRepository.save(new Cor(null, "Roxo Lavanda", "#E6E6FA"));

        // Personalidades disponíveis no sistema

        //  MASCULINO
        personalidadeRepository.save(new Personalidade(null, "Extrovertido", "Energético, sociável, gosta de interações sociais e ambientes dinâmicos.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Introvertido", "Reservado, prefere ambientes tranquilos e interações mais profundas.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Amigável", "Simpático, caloroso, prestativo e gentil com os outros.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Analítico", "Lógico, gosta de resolver problemas e tomar decisões com base em fatos e dados.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Criativo", "Imaginativo, inovador e expressivo, gosta de experimentar novas ideias.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Pragmático", "Prático, focado em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GeneroList.MASCULINO));
        personalidadeRepository.save(new Personalidade(null, "Impulsivo", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GeneroList.MASCULINO));

        // FEMININO
        personalidadeRepository.save(new Personalidade(null, "Extrovertida", "Energética, sociável, gosta de interações sociais e ambientes dinâmicos.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Introvertida", "Reservada, prefere ambientes tranquilos e interações mais profundas.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Amigável", "Simpática, calorosa, prestativa e gentil com os outros.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Analítica", "Lógica, gosta de resolver problemas e tomar decisões com base em fatos e dados.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Criativa", "Imaginativa, inovadora e expressiva, gosta de experimentar novas ideias.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Pragmática", "Prática, focada em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GeneroList.FEMININO));
        personalidadeRepository.save(new Personalidade(null, "Impulsiva", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GeneroList.FEMININO));

        // NAO_BINARIO
        personalidadeRepository.save(new Personalidade(null, "Extroverte", "Energético(a), sociável, gosta de interações sociais e ambientes dinâmicos.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Introverte", "Reservado(a), prefere ambientes tranquilos e interações mais profundas.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Amigável", "Simpático(a), caloroso(a), prestativo(a) e gentil com os outros.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Analítico(a)", "Lógico(a), gosta de resolver problemas e tomar decisões com base em fatos e dados.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Criative", "Imaginativo(a), inovador(a) e expressivo(a), gosta de experimentar novas ideias.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Pragmátique", "Prático(a), focado(a) em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GeneroList.NAO_BINARIO));
        personalidadeRepository.save(new Personalidade(null, "Impulsive", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GeneroList.NAO_BINARIO));
    }
}
