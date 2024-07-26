package it.epicode;

public class Cane extends Animale {
    private final String razza = "Cane";
    public Cane(String colore, String nome) {
        super(colore, nome);
    }

    @Override
    public String toString() {
        return super.toString()+" cane";
    }
}
