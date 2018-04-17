package haveibeenpwned.api;

import haveibeenpwned.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangeAPIITest {

    private final static String WEAK_PASSWORD = "12345678";
    private RangeAPI rangeAPI;

    @BeforeEach
    public void beforeEach() {
        rangeAPI = new RangeAPIImpl();
    }

    @Test
    public void isPwnedWeakPassword() throws Exception {
        assertTrue(rangeAPI.isPwned(WEAK_PASSWORD));
    }

    @Test
    public void isNotPwnedStrongPassword() throws Exception {
        assertFalse(rangeAPI.isPwned(StringUtil.generateRandomPassword()));
    }

}