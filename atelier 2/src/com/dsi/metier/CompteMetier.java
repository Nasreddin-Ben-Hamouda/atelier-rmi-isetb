package com.dsi.metier;

import com.dsi.model.Compte;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompteMetier extends UnicastRemoteObject implements ICompteMetier {
    private Connection con=null;
    private PreparedStatement  st=null;
    private ResultSet result=null;

    public CompteMetier() throws RemoteException{
        super();
        con=SingletonConnection.getConnection();
    }

    @Override
    public ArrayList<Compte> AfficherList() throws RemoteException {
        return null;
    }

    @Override
    public void AjouterCompte(Compte c) throws RemoteException {
      try {
        this.st = this.con.prepareStatement("INSERT INTO compte (numcp,typecp,solde) VALUES (?,?,?)");
        this.st.setInt(1, c.getNumCp());
        this.st.setString(2, c.getTypeCp());
        this.st.setInt(3, c.getSolde());
        this.st.executeUpdate();
      }catch(SQLException e){
         e.printStackTrace();
      }
    }

    @Override
    public Compte RechercherParNum(int code) throws RemoteException {
      Compte c=new Compte();
      try {
        this.st = this.con.prepareStatement("SELECT * FROM compte WHERE numcp = ?");
        this.st.setInt(1, code);
        this.result=st.executeQuery();
        while(this.result.next()){
          System.out.println("Num Compte ==> "+this.result.getInt("numcp"));
          System.out.println("Type Compte ==> "+this.result.getString("typecp"));
          System.out.println("Solde Compte ==> "+this.result.getInt("solde"));
          c.setTypeCp(this.result.getString("typecp"));
          c.setSolde(this.result.getInt("solde"));
          c.setNumCp(this.result.getInt("numcp"));
        }
      }catch (SQLException e){
        e.printStackTrace();
      }
        return c;
    }

    @Override
    public void ModifierCompte(Compte c) throws RemoteException {
      try {
        this.st = this.con.prepareStatement("UPDATE compte SET numcp=?,typecp=?,solde=1 WHERE numcp=?");
        this.st.setInt(1, c.getNumCp());
        this.st.setString(2, c.getTypeCp());
        this.st.setInt(3, c.getSolde());
        this.st.setInt(4, c.getNumCp());
        this.result=st.executeQuery();
      }catch (SQLException e){
        e.printStackTrace();
      }
    }

    @Override
    public void ModifierSoldeCompte(int solde, int codeCompte) throws RemoteException {
         try{
              this.st=this.con.prepareStatement("UPDATE compte SET solde = ? WHERE numcp = ?");
              this.st.setDouble(1,solde);
              this.st.setInt(2,codeCompte);
              this.st.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
         }
    }
}
