package it.epicode;

import java.util.ArrayList;
import java.util.List;

public class Conto {
    private String proprietario;
    private Double totale;
    private List<String> transazioni;

    public Conto(String proprietario) {
        this.proprietario = proprietario;
        this.totale = 0.0;
        this.transazioni = new ArrayList<>();
        this.transazioni.add("-100.0 €");
    }

    public Conto() {
        this.totale = 0.0;
        this.transazioni = new ArrayList<>();
        this.transazioni.add("-100.0 €");
    }

    public void deposita(Double deposito) {
        transazioni.add("+"+deposito+" €");
        totale = totale + deposito;
    }

    public void ritira(Double ritiro) throws FondiNonDisponibiliException {
        if (this.totale >= ritiro) {
            transazioni.add("-"+ritiro+" €");
            this.totale = this.totale - ritiro;
        } else {
            throw new FondiNonDisponibiliException("Non ci sono abbastanza soldi nel conto");
        }
    }

    public void trasferimento(Double cifra, Conto conto) {
        if (this.totale >= cifra) {
            this.totale = this.totale - cifra;
            transazioni.add("-"+cifra+" €");
            conto.deposita(cifra);
        } else {
            throw new TrasferimentoNonRiuscitoException("Trasferimento non riuscito");
        }
    }

    public List<String> getTransazioni() {
        return transazioni;
    }

    @Override
    public String toString() {
        return "Conto{" +
                "proprietario='" + proprietario + '\'' +
                ", totale=" + totale +
                '}';
    }
}
