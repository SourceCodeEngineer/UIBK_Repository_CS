package at.ac.uibk.pm.gXX.zidUsername.s03.ex2;

public class ThermometerApplication {

    public static void main(String[] args) {
        Thermometer celsius = new CelsiusThermometer(10);
        celsius.printTemperature();
        celsius.degree = 20;
        celsius.printTemperature();
    }
}