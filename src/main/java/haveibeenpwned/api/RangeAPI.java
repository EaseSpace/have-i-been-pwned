package haveibeenpwned.api;

import java.security.NoSuchAlgorithmException;

public interface RangeAPI {
    boolean isPwned(String password) throws NoSuchAlgorithmException;
}
