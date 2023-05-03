package org.example.ch06_oop2.sec_05_abstract_class;

public class E_CarSpeedMeter extends D_SpeedMeter {
    private double radius;

    public E_CarSpeedMeter(double radius) {
        this.radius = radius;
    }

    @Override
    public double calGirth() {
        return radius * 2 * Math.PI;
    }

    public static void main(String[] args) {
        var csm = new E_CarSpeedMeter(0.34);
        csm.setTurnRate(15);
        System.out.println(csm.getSpeed());
    }
}
