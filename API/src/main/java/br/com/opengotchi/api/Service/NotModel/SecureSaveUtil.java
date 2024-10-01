package br.com.opengotchi.api.Service.NotModel;

import br.com.opengotchi.api.Config.Exception.SecureSave.SecureSaveException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class SecureSaveUtil {

    public static String secureSavePassword(String password) {
        return hashString(password);
    }

    public static String secureSaveEmail(String email) {
        return hashString(email);
    }

    private static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new SecureSaveException("Erro ao criptografar string");
        }
    }
}