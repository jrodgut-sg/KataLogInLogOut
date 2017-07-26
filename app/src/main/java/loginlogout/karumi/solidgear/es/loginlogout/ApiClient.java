package loginlogout.karumi.solidgear.es.loginlogout;

public class ApiClient {

    private static final String VALID_EMAIL = "pedro@karumi.com";
    private static final String VALID_PASSWORD = "123456";

    private IClock clock;

    public ApiClient(IClock clock) {
        this.clock = clock;
    }

    public boolean login(String login, String password) {
        return VALID_EMAIL.equals(login) && VALID_PASSWORD.equals((password));
    }

    public boolean logout() {
        return clock.getCurrentSeconds() % 2 == 0;
    }
}
