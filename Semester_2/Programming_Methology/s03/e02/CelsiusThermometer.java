package at.ac.uibk.pm.gXX.zidUsername.s03.ex2;

public class CelsiusThermometer extends Thermometer {

    public CelsiusThermometer(int degree) {
        setDegreeCelsius(degree);
    }

    @Override
    public void printTemperature() {
        System.out.printf("%6.1f °C%n", getDegreeCelsius());
    }
}
