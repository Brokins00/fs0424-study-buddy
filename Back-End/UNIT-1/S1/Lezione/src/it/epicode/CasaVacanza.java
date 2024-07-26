package it.epicode;

public class CasaVacanza {
    private static double numero2;
    public static void main(String[] args) {
        String string;
        int numero = 5;
        double numero3 = numero+0.9;
        System.out.println(numero3);
        int numero4 = (int) numero3;
        System.out.println(numero4);

        ///////////

        String[] array = new String[5];
        array[0] = "test";
        array[1] = "test 1";
        System.out.println(array[0]);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        test1();
        test2();
    }

    public static void test1() {
        if (getNumero2() <= 5.0) {
            if (getNumero2() == 2.0) {
                System.out.println("test");
            } else {
                System.err.println("test fallito");
            }
        } else if (getNumero2() > 5.0 && getNumero2() <= 10.0) {
            System.out.println("test 2");
        } else {
            System.out.println("test 3");
        }
    }

    public static void test2() {
        while (getNumero2() < 2.0) {
            System.out.println(getNumero2());
            setNumero2(getNumero2()+0.5);
            if (getNumero2() > 1.0) {
                break;
            }
        }
        System.err.println("ciclo interrotto");
    }

    public static double getNumero2() {
        // ritorna un double
        return numero2;
    }

    public static void setNumero2(double numero2) {
        CasaVacanza.numero2 = numero2;
    }

    public void doSomething() {
        // fa cose
    }
}