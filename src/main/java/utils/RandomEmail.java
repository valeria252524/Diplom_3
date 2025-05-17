package utils;
import java.util.Random;


public class RandomEmail {
    public static String randomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        email.append("@yandexx.ru");
        return email.toString();
    }
}