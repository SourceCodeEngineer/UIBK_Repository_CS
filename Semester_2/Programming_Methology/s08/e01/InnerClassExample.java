package at.ac.uibk.pm.gXX.zidUsername.s08.e01;

public class InnerClassExample {

    static class NestedClass {
        char c;
        public NestedClass(char c) {
            this.c = c;
        }
        public void print() {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        printContext(new NestedClass('A'));
        printContext(new NestedClass('B') {
            public void print() {
                System.out.print("(");
                super.print();
                System.out.print(")");
            }
        });
    }

    private static void printContext(NestedClass c) {
        c.print();
    }
}
