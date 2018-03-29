package com.dsi.client;

import com.dsi.metier.CompteMetier;
import com.dsi.metier.ICompteMetier;
import com.dsi.model.Compte;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client {
    public static void main(String[] args) throws MalformedURLException,NotBoundException{
        try{
            ICompteMetier client;
            client=(ICompteMetier)Naming.lookup("rmi://localhost:1099/BankJee");
            System.out.println("Ajouter un compte");
            Compte c=new Compte();
            c.setNumCp(2);
            c.setTypeCp("invite");
            c.setSolde(1300);
            client.AjouterCompte(c);
            CompteMetier Cm=new CompteMetier();
            System.out.println("compte avant mise a jour = "+c);
            Cm.ModifierSoldeCompte(c.getSolde()+1000,c.getNumCp());

            System.out.println("Rechercher Compte");
            System.out.println(client.RechercherParNum(2));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
