package it.epicode;

public class Main {
    public static void main(String[] args) {
        Animale animale = new Animale();
        animale.setNome("Pippo");
        animale.setColore("nero");
        System.out.println(animale);
        Animale animale2 = new Animale("marrone");
        System.out.println(animale2);
        animale2.setNome("Pluto");
        System.out.println(animale2);
    }
}