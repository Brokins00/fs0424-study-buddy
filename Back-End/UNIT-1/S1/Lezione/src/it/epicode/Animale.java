package it.epicode;

public class Animale {
    private String colore;
    private String nome;
    private StatoBiglietto statoBiglietto;

    public Animale() {
    }

    public Animale(String colore) {
        this.colore = colore;
        this.statoBiglietto = StatoBiglietto.SCADUTO;
    }

    public Animale(String colore, String nome) {
        this.colore = colore;
        this.nome = nome;
        System.out.println(this.colore.equals(this.nome));
    }

    public String getColore() {
        return this.colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Animale{" +
                "colore='" + this.colore + '\'' +
                ", nome='" + this.nome + '\'' +
                '}';
    }
}
