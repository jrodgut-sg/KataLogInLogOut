package loginlogout.karumi.solidgear.es.loginlogout;

import org.junit.Test;

import static org.junit.Assert.*;


public class ApiClientTest {

    private static final String VALID_EMAIL = "pedro@karumi.com";
    private static final String VALID_PASSWORD = "123456";


    @Test
    public void shouldReturnTrueOnCorrectCredentials() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(0));

        boolean result = apiClient.login(VALID_EMAIL, VALID_PASSWORD);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseOnBothIncorrectCredentials() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(0));

        boolean result = apiClient.login("foo1", "foo2");

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseOnOnlyIncorrectLogin() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(0));

        boolean result = apiClient.login("foo1", VALID_PASSWORD);

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseOnOnlyIncorrectPassword() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(0));

        boolean result = apiClient.login(VALID_EMAIL, "foo2");

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueOnEvenSeconds() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(12));

        boolean result = apiClient.logout();

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseOnOddSeconds() throws Exception {
        ApiClient apiClient = new ApiClient(new MockClock(13));

        boolean result = apiClient.logout();

        assertFalse(result);
    }
}