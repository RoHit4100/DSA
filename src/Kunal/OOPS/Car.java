package Kunal.OOPS;

class Car implements Break,Engine{
    @Override
    public void starts() {
        System.out.println("I start like a normal care");
    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car"); }

    @Override
    public void brake() {
        System.out.println("I Brake like a normal car");
    }
}