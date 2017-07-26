package loginlogout.karumi.solidgear.es.loginlogout;

public class MockClock implements IClock {

    private long seconds;

    public MockClock(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public long getCurrentSeconds() {
        return seconds;
    }
}
