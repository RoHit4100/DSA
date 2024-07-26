package Kunal.OOPS;

public class CarMedia implements MediaPlayer{
    @Override
    public void starts() {
        System.out.println("Media player is started");
    }

    @Override
    public void stop() {
        System.out.println("Media player is stopped");
    }
}
