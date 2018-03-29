package com.dsi.metier;

import com.dsi.model.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ICompteMetier extends Remote {

    public ArrayList<Compte> AfficherList() throws RemoteException;
    public void AjouterCompte(Compte c) throws RemoteException;
    public Compte RechercherParNum(int code) throws RemoteException;
    public void ModifierCompte(Compte c) throws RemoteException;
    public void ModifierSoldeCompte(int solde,int codeCompte) throws RemoteException;
}
