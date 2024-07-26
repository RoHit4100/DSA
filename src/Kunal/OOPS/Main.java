package Kunal.OOPS;

public class Main {
    public static void main(String[] args) {
        Singleton obj  = Singleton.getInstance();
        Car car = new Car();
        car.starts();
        car.acc();
        car.stop();

        CarMedia newCar = new CarMedia();
        newCar.starts();
    }
}
