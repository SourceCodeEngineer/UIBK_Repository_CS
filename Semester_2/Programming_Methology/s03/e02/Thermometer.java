package at.ac.uibk.pm.gXX.zidUsername.s03.ex2;

public abstract class Thermometer {
    public double degree;

    public final double getDegreeCelsius() {
        return Temperature.kelvinToCelsius(degree);
    }

    public final double getDegreeFahrenheit() {
        return Temperature.kelvinToFahrenheit(degree);
    }

    public final double getDegreeKelvin() {
        return degree;
    }

    public final void setDegreeCelsius(double degreeCelsius) {
        this.degree = Temperature.celsiusToKelvin(degreeCelsius);
    }

    public final void setDegreeFahrenheit(double degreeFahrenheit) {
        this.degree = Temperature.fahrenheitToKelvin(degreeFahrenheit);
    }

    public final void setDegreeKelvin(double degree) {
        this.degree = degree;
    }

    public abstract void printTemperature();
}
