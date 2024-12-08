/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.servicios;

/**
 *
 * @author chris
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AuthService {

 private static final String USERNAME = "MONSTER";
    private static final String HASHED_PASSWORD = "26591d262ae2c3d2320ff92ad90864d78e067022532041e8304688db882e7c69"; // Contraseña "password" en SHA-256

    // Método para verificar credenciales
    public boolean authenticate(String username, String password) {
        if (!USERNAME.equals(username)) {
            return false;
        }

        String hashedInput = hashPassword(password);
        return HASHED_PASSWORD.equals(hashedInput);
    }

       public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println("Request recibido: " +  hexString.toString());
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

    public static boolean validatePassword(String plainPassword, String hashedPassword) {
        return hashPassword(plainPassword).equals(hashedPassword);
    }
}
