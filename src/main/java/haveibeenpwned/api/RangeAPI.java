package haveibeenpwned.api;

import haveibeenpwned.util.HashUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.security.NoSuchAlgorithmException;

public class RangeAPI {
    private static final String REST_URI = "https://api.pwnedpasswords.com/range";

    private Client client = ClientBuilder.newClient();

    /**
     * @param password
     * @return true if the password is pwned
     * @throws NoSuchAlgorithmException
     */
    public boolean isPwned(String password) throws NoSuchAlgorithmException {
        String hash = HashUtil.sha1(password).toUpperCase();
        long startTime = System.nanoTime();
        String requestResult = client
                .target(REST_URI)
                .path(hash.substring(0, 5))
                .request("text/plain")
                .get(String.class);
        long endTime = System.nanoTime();
        System.out.println("V1 Request: " + ((endTime - startTime) / 1000000) + " ms");
        startTime = System.nanoTime();
        boolean res = requestResult.contains(hash.substring(5));
        endTime = System.nanoTime();
        System.out.println("V1 Search: " + ((endTime - startTime) / 1000000) + " ms");
        return res;
    }
}
