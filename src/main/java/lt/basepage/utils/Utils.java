package lt.basepage.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Utils {
    private static final String[] FIRST_NAMES = {
            "Galva", "Bulve", "Audra", "Mikis", "Joglis", "Chiukcia", "Gudzius", "Jessica"
    };

    private static final String[] LAST_NAMES = {
            "Failas", "Johnson", "Slaunis", "Brown", "Petraitis", "Snikers", "Ulker", "Shy"
    };
    private static final String EMAIL_DOMAIN = "uhoo.com";
    private static final Random RANDOM = new Random();

    public static String generateFistName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    public static String generateLastName() {
        return FIRST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    public static String generateEmail(String firstName, String lastName ) {
        int number = RANDOM.nextInt(1000);
        return String.format("%s.%s%d@%s",firstName.toLowerCase(), lastName.toLowerCase(), number, EMAIL_DOMAIN);
    }

    public static String generatePassword() {
        int lenght = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder passowrd = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) {
            passowrd.append(characters.charAt(RANDOM.nextInt(characters.length())));
        }
        return passowrd.toString();
    }

    public static void appendUserToCSV(String firstName, String lastName, String email, String password, String expectedResult) {
        String filePath = "src/main/resources/loginData.csv";
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(String.format("%s,%s,%s,%s,%s", firstName, lastName, email, password, expectedResult));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
