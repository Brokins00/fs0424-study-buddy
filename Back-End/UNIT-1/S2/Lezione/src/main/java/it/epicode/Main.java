package it.epicode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Conto conto1 = new Conto("Kassandra Falsitta");
        conto1.deposita(50.00);
        Conto conto2 = new Conto("Mirko Abozzi");
        conto2.deposita(20.00);
        try {
            conto1.ritira(20.00);
            System.out.println("test 2");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        conto1.trasferimento(20.00, conto2);
        System.out.println("test");
        List<String> transazioniConto1 = conto1.getTransazioni();
        transazioniConto1.forEach(System.out::println);
        System.err.println("----------------------");
        List<String> sorted = transazioniConto1.stream().sorted((s1, s2) -> {
            Boolean s1piu = s1.startsWith("+");
            Boolean s2piu = s2.startsWith("+");

            if ((s1piu && s2piu) || (!s1piu && !s2piu) ) {
                return s1.compareTo(s2);
            } else {
                return s1piu ? -1 : 1;
            }
        }).toList();


        sorted.forEach(System.out::println);

        List<String> mapped = transazioniConto1.stream().map((stringa) -> stringa + "@").toList();

        mapped.forEach(System.out::println);

        Map<String, Conto> mappatura = new HashMap<>();

        mappatura.put("Kassandra Falsitta", conto1);
        mappatura.put("Mirko Abozzi", conto2);

        mappatura.forEach((chiave, valore) -> {
            System.out.println(chiave);
            System.out.println(valore);
        });
    }
}