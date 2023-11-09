package esercitazioni.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * La classe Sportivo rappresenta un atleta iscritto in una competizione sportiva.
 */
public class Sportivo {

    private String cognome;
    private int rank;
    private Date dataDiIscrizione;

    /**
     * Costruttore per la classe Sportivo con tutti i dettagli disponibili.
     *
     * @param cognome          il cognome dello sportivo
     * @param rank             il rank dello sportivo
     * @param dataDiIscrizione la data di iscrizione dello sportivo
     */
    public Sportivo(String cognome, int rank, Date dataDiIscrizione) {
        this.setCognome(cognome);
        this.setRank(rank);
        this.setDataDiIscrizione(dataDiIscrizione);
    }

    /**
     * Costruttore per la classe Sportivo con cognome e rank.
     *
     * @param cognome il cognome dello sportivo
     * @param rank    il rank dello sportivo
     */
    public Sportivo(String cognome, int rank) {
        this.setCognome(cognome);
        this.setRank(rank);
    }

    /**
     * Restituisce il cognome dello sportivo.
     *
     * @return il cognome dello sportivo
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce il rank dello sportivo.
     *
     * @return il rank dello sportivo
     */
    public int getRank() {
        return rank;
    }

    /**
     * Imposta il rank dello sportivo.
     *
     * @param rank il rank dello sportivo
     */
    public void setRank(int rank) {
        if (rank >= 1 && rank <= 30) {
            this.rank = rank;
        } else {
            this.rank = 0;
        }
    }

    /**
     * Restituisce la lettera corrispondente al rank.
     *
     * @param rank il rank dello sportivo
     * @return la lettera corrispondente al rank
     */
    public char getLetterRanking(int rank) {
        char letterRank = ' ';

        if (rank >= 1 && rank <= 10) {
            letterRank = 'A';
        } else if (rank >= 11 && rank <= 20) {
            letterRank = 'B';
        } else if (rank >= 21 && rank <= 30) {
            letterRank = 'C';
        } else {
            letterRank = 'D';
        }
        return letterRank;
    }

    /**
     * Imposta la data di iscrizione dello sportivo.
     *
     * @param dataDiIscrizione la data di iscrizione dello sportivo
     */
    public void setDataDiIscrizione(Date dataDiIscrizione) {
        Optional<Date> data = Optional.ofNullable(dataDiIscrizione);
        if (!data.isEmpty()) {
            this.dataDiIscrizione = dataDiIscrizione;
        }
    }

    /**
     * Restituisce la data di iscrizione dello sportivo nel formato "dd/MM/yyyy".
     *
     * @return la data di iscrizione dello sportivo nel formato "dd/MM/yyyy"
     */
    public String getDataDiIscrizione() {
        String data = null;

        if (dataDiIscrizione != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat();
            dataFormat.applyPattern("dd/MM/yyyy");
            data = dataFormat.format(dataDiIscrizione);
        }

        return data;
    }

    /**
     * Acquisisce la data fornita.
     *
     * @param data la data da acquisire
     * @return la data acquisita
     */
    public Date acquisisciData(Date data) {
        return data;
    }

    /**
     * Imposta il cognome dello sportivo.
     *
     * @param cognome il cognome dello sportivo
     */
    public void setCognome(String cognome) {

        if (cognome.length() < 3) {
            this.cognome = "";
        } else {
            this.cognome = cognome;
        }
    }
}
