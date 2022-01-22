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
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String address;
    private double credit;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    public void add()
    {
        String add="insert into client values("
                +id+","
                +"'"+nom+"',"
                +"'"+prenom+"',"
                +"'"+address+"',"
                +"'"+telephone+"',"
                +credit+" )";
        boolean isadd=dbase.Go.runNonQuery(add);
        if(isadd)
        {
            Tools.msgBox("Client enregestré");
        }else
        {
            Tools.msgBox(("Client Exist dejà!!"));
        }
    }
    public void update()
    {
        String update ="update client set "
                +"nom='"+nom+"',"
                +"prenom='"+prenom+"',"
                +"address='"+address+"',"
                +"telephone='"+telephone+"',"
                +"credit='"+credit+"' "
                +"where id_client = "+id;
        boolean isupdate=dbase.Go.runNonQuery(update);
        if(isupdate)
        {
            Tools.msgBox("Client Modifié");
        }else{
            Tools.msgBox("Impossible de modifier ce Client");
        }
    }
    public void delete()
    {
        String delete="delete from client where id_client = "+id;
        boolean isdelete=dbase.Go.runNonQuery(delete);
        if(isdelete){
            Tools.msgBox("Client Supprimé");
        }else{
            Tools.msgBox("Impossible de Supprimer ce Client");
        }
    }
    public void update_credit()
    {
        String update ="update client set "
                +"credit='"+credit+"' "
                +"where id_client = "+id;
        boolean isupdate=dbase.Go.runNonQuery(update);
        if(isupdate)
        {
           // Tools.msgBox("Credit Client Modifié");
        }else{
            Tools.msgBox("Impossible de modifier ce Client");
        }
    }
    
    
}
