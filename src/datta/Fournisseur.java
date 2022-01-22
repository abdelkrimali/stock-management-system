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
public class Fournisseur {
    private int id;
    private String nom;
    private String prenom;
    private String address;
    private String telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public void add()
    {
        String add="insert into fournisseur values("
                +id+","
                +"'"+nom+"',"
                +"'"+prenom+"',"
                +"'"+address+"',"
                +"'"+telephone+"')";
        boolean isadd=dbase.Go.runNonQuery(add);
        if(isadd)
        {
            Tools.msgBox("Fournisseur Enregistré ");
        }
        else
        {
            Tools.msgBox("Fournisseur Exist deja!");
        }
                
    }
    public void update()
    {
        String update="update fournisseur set "
                +"nom='"+nom+"',"
                +"prenom='"+prenom+"',"
                +"address='"+address+"',"
                +"telephone='"+telephone+"' "
                +"where id_fournisseur ="+id;
        boolean isupdate=dbase.Go.runNonQuery(update);
        if(isupdate)
        {
            Tools.msgBox("Fournisseur Modifié");
        }else{
            Tools.msgBox("Impossible de modifier les informations");
        }
    }
    public void delete()
    {
        String delete="delete from fournisseur where id_fournisseur="+id;
        boolean isdelete=dbase.Go.runNonQuery(delete);
        if(isdelete)
        {
            Tools.msgBox("Fournisseur Supprimé");
        }else{
            Tools.msgBox("Impossible de Supprimer ce fournisseur!!");
        }
    }
}
