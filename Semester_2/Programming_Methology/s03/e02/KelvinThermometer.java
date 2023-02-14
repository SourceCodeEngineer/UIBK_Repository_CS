package at.ac.uibk.pm.gXX.zidUsername.s03.ex2;

public class KelvinThermometer extends Thermometer {

    public KelvinThermometer(int degree) {
        setDegreeKelvin(degree);
    }


    @Override
    public void printTemperature() {
        System.out.printf("%6.1f °K%n", getDegreeKelvin());
    }
}
