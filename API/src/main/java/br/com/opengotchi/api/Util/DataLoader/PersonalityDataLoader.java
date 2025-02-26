package br.com.opengotchi.api.Util.DataLoader;

import br.com.opengotchi.api.Repository.PersonalityRepository;
import br.com.opengotchi.api.Util.List.GenderList;
import br.com.opengotchi.api.Util.Model.Personality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalityDataLoader {

    @Autowired
    private PersonalityRepository personalityRepository;

    public void load() {

        // MALE
        personalityRepository.save(new Personality(null, "Extrovertido", "Energético, sociável, gosta de interações sociais e ambientes dinâmicos.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Introvertido", "Reservado, prefere ambientes tranquilos e interações mais profundas.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Amigável", "Simpático, caloroso, prestativo e gentil com os outros.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Analítico", "Lógico, gosta de resolver problemas e tomar decisões com base em fatos e dados.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Criativo", "Imaginativo, inovador e expressivo, gosta de experimentar novas ideias.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Pragmático", "Prático, focado em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GenderList.MALE));
        personalityRepository.save(new Personality(null, "Impulsivo", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GenderList.MALE));

        // FEMALE
        personalityRepository.save(new Personality(null, "Extrovertida", "Energética, sociável, gosta de interações sociais e ambientes dinâmicos.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Introvertida", "Reservada, prefere ambientes tranquilos e interações mais profundas.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Amigável", "Simpática, calorosa, prestativa e gentil com os outros.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Analítica", "Lógica, gosta de resolver problemas e tomar decisões com base em fatos e dados.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Criativa", "Imaginativa, inovadora e expressiva, gosta de experimentar novas ideias.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Pragmática", "Prática, focada em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GenderList.FEMALE));
        personalityRepository.save(new Personality(null, "Impulsiva", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GenderList.FEMALE));

        // NEUTRAL
        personalityRepository.save(new Personality(null, "Extrovertide", "Energéticde, sociável, gosta de interações sociais e ambientes dinâmicos.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Introvertide", "Reservade, prefere ambientes tranquilos e interações mais profundas.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Amigável", "Simpáticde, calorosde, prestativde e gentil com os outros.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Analíticde", "Lógicde, gosta de resolver problemas e tomar decisões com base em fatos e dados.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Criativde", "Imaginativde, inovadorde e expressivde, gosta de experimentar novas ideias.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Pragmáticde", "Práticde, focadde em soluções simples e eficazes, realista sobre o que pode ser alcançado.", GenderList.NEUTRAL));
        personalityRepository.save(new Personality(null, "Impulsivde", "Toma decisões rapidamente, às vezes sem considerar as consequências.", GenderList.NEUTRAL));
    }
}
