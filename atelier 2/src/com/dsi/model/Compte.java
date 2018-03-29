package com.dsi.model;

import java.io.Serializable;

public class Compte   implements Serializable {

    private int numCp;
    private String typeCp;
    private int solde;

    public Compte(){

    }

    public int getNumCp() {
        return numCp;
    }

    public void setNumCp(int numCp) {
        this.numCp = numCp;
    }

    public String getTypeCp(){
        return typeCp;
    }

    public void setTypeCp(String typeCp) {
        this.typeCp = typeCp;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }


    public String toString(){
        return "Num cp = "+this.numCp+" type cp =  "+this.typeCp+" solde cp =  "+this.solde;
    }

}
