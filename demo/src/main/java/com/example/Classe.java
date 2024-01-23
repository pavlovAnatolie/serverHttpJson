package com.example;

import java.util.ArrayList;

public class Classe {
     private int numero;
    private String sezione;
    private String aula;
    private ArrayList<Studente> studenti;

    public Classe(int numero, String sezione, String aula) {
        this.numero = numero;
        this.sezione = sezione;
        this.aula = aula;
        studenti = new ArrayList();
    }

    

    public Classe() {
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSezione() {
        return sezione;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }

    public void addStudente(Studente s){
        studenti.add(s);
    }

    @Override
    public String toString() {
        String s = "Classe:"+numero+sezione+"\tPosizione:"+aula+"\n";
        for (Studente studente : studenti) {
            s = s+ studente+"\n";
        }

        return s;
    }

}
