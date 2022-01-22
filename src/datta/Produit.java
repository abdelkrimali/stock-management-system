/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datta;

import stock.Tools;

/**
 *
 * @author Alilo
 */
public class Produit {
    private int id;
    private int fournisseur;
    private String designation;
    private double qtetotal;
    private double prix_achat;
    private double prix_vente;
    private double qtereste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getQtetotal() {
        return qtetotal;
    }

    public void setQtetotal(double qtetotal) {
        this.qtetotal = qtetotal;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public double getQtereste() {
        return qtereste;
    }

    public void setQtereste(double qtereste) {
        this.qtereste = qtereste;
    }
    
    public void add()
    {
        String add="insert into produit values ("
                +id+","
                 +fournisseur+","
                +"'"+designation+"',"
                +qtetotal+","
                +prix_achat+","
                +prix_vente+","
                +qtereste+")";
        boolean isadd=dbase.Go.runNonQuery(add);
        if(isadd)
        {
            Tools.msgBox("Produit Enregistré");
        }else
        {
            Tools.msgBox("Impossible d'enregistrer le produit!!");
        }
    }
    public void update()
    {
        String update="update produit set "
                +"designation='"+designation+"',"
                +"quantite_totale="+qtetotal+","
                +"quantite_reste="+qtereste+","
                +"prix_achat="+prix_achat+","
                +"prix_vente="+prix_vente+" where reference = "+id;
        boolean isupdate=dbase.Go.runNonQuery(update);
        if(isupdate)
        {
            Tools.msgBox("Informations Enregistré");
        }
        else{
            Tools.msgBox("Impossible de modifier les informations du produit");
        }
    }
    public void delete()
    {
        String delete="delete from produit where reference="+id;
        boolean isdelete=dbase.Go.runNonQuery(delete);
        if(isdelete)
        {
            Tools.msgBox("Prduit Supprimé");
        }else
        {
            Tools.msgBox("Impossible de supprimer le produit");
        }
    }
    
    public void update_qterest()
    {
        String update="update produit set quantite_reste="+qtereste+" where reference="+id;
         boolean isupdate=dbase.Go.runNonQuery(update);
        if(isupdate)
        {
           // Tools.msgBox("Quantité Modifié");
        }
        else{
            Tools.msgBox("Impossible de modifier quantité produit");
        }
    }
    
    
    
}
