/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.thuan.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import dev.thuan.Main;

/**
 * @author benbac
 */

public class PasswordUtility {
    private static final SecretKey key = genetateKey();

    public static SecretKey genetateKey() {
        try {
            DESKeySpec keySpec = new DESKeySpec(
                    "My secret Key phrase".getBytes(StandardCharsets.UTF_8));
            SecretKeyFactory keyFactory =
                    SecretKeyFactory.getInstance("DES");
            return keyFactory.generateSecret(keySpec);
            //return KeyGenerator.getInstance("DES").generateKey();        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String SECRET_KEY = "your_secret_key_here"; // Đặt khóa bí mật của bạn ở đây

    public static String encodeString(String plainTextPassword) {
        try {
            byte[] cleartext = plainTextPassword.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("DES");
            Key key = generateKey();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(cleartext);
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decodeString(String encryptedPwd) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPwd);
            Cipher cipher = Cipher.getInstance("DES");
            Key key = generateKey();
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static Key generateKey() throws Exception {
        DESKeySpec keySpec = new DESKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(secretKey.getEncoded(), "DES");
    }


    public static void passwordGenerator() {
        System.out.println("This command takes a string and encodes it" +
                "for use in jrdesktop config files\n\n" +
                "Please enter the password:\n");
        String password;

        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);
            password = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            password = "";
        }

        System.out.println("Encoded this password:\n '" + password + "'");
        System.out.println("Enter this encoded string into config files:\n" +
                encodeString(password));
        Main.exit();
    }
}