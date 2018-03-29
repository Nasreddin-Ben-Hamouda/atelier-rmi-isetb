package com.dsi.server;

import com.dsi.metier.CompteMetier;
import com.dsi.model.Compte;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String [] args){
        try{
            LocateRegistry.createRegistry(1099);
            CompteMetier Cm = new CompteMetier();
            Naming.rebind("rmi://localhost:1099/BankJee", Cm);
            Compte c=new Compte();
            c.setNumCp(1);
            c.setTypeCp("administrateur");
            c.setSolde(1200);
           // Cm.AjouterCompte(c);
            Compte res=Cm.RechercherParNum(1);
            System.out.println("Affiche du compte avec ToString"+res);

        }catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
