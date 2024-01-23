package com.example;

import java.util.Date;

public class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;

   
    public Studente(String nome, String cognome, Date dataDiNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    } 

    

    public Studente() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }


    @Override
    public String toString() {
        return "Nome: "+nome+" \tCognome: "+cognome+" \tNato il: "+dataDiNascita;
    }
}
