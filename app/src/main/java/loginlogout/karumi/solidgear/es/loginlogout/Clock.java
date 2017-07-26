package loginlogout.karumi.solidgear.es.loginlogout;

public class Clock implements IClock{

    public long getCurrentSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
