package haveibeenpwned.util;

import java.util.concurrent.ThreadLocalRandom;

public class StringUtil {

    private final static String PASSWORD_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

    public static String generateRandomPassword() {
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i=0; i < 30; i++)
            passwordBuilder.append(PASSWORD_CHARACTERS.charAt(ThreadLocalRandom.current().nextInt(0, PASSWORD_CHARACTERS.length())));
        return passwordBuilder.toString();
    }
}
