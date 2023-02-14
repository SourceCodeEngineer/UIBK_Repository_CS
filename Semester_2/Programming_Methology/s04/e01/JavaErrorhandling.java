package at.ac.uibk.pm.gXX.zidUsername.s04.e01;

public class JavaErrorhandling {
    public static int sumPositiveInts(int... ints) {
        int sum = 0;
        for (int anInt : ints) {
            if (anInt < 0) {
                System.err.println("only positive values are allowed!");
                return -1;
            }
            sum += anInt;
            if (sum < 0) {
                System.err.println("overflow!");
                return -2;
            }
        }
        return sum;
    }

}
