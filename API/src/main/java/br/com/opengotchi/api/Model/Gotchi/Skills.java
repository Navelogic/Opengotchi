package br.com.opengotchi.api.Model.Gotchi;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Skills {
    private int charisma; // Carisma
    private int comedy; // Comédia
    private int cooking; // Culinária
    private int fishing; // Pesca
    private int fitness; // Boa Forma
    private int gardening; // Jardinagem
    private int gourmetCooking; // Culinária Gourmet
    private int guitar; // Violão
    private int handiness; // Conserto
    private int logic; // Lógica
    private int mischief; // Travessura
    private int mixology; // Mixologia
    private int painting; // Pintura
    private int piano; // Piano
    private int photography; // Fotografia
    private int programming; // Programação
    private int rocketScience; // Ciência Espacial
    private int videoGaming; // Jogos Eletrônicos
    private int violin; // Violino
    private int writing; // Escrita
    private int baking; // Confeitaria
    private int dancing; // Dança
    private int singing; // Canto
    private int acting; // Atuação
    private int djMixing; // DJ
    private int mediaProduction; // Produção de Mídia
    private int robotics; // Robótica
    private int wellness; // Bem-estar
    private int knitting; // Tricô
    private int romance; // Romance
    private int gemology; // Gemologia
    private int nectarMaking; // Produção de Néctar
    private int horseRiding; // Equitação
    private int archery; // Arco e Flecha
    private int researchDebate; // Pesquisa e Debate

    // Toddler Skills
    private int communication; // Comunicação
    private int imagination; // Imaginação
    private int movement; // Movimento
    private int potty; // Banheiro
    private int thinking; // Pensamento

    // Child Skills
    private int creativity; // Criatividade
    private int mental; // Mental
    private int motor; // Motor
    private int socialChild; // Social da Crianaça
    private int emotional; // Emocional
}
