/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datta;

/**
 *
 * @author Alilo
 */
public class Commande {
    private int id_commande;
    private int client;
    private String date_commande;

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }
    public void add()
    {
        String add="insert into commande values("
                +id_commande+","
                +client+","
                +"'"+date_commande+"')";
        boolean isadd=dbase.Go.runNonQuery(add);
        if(isadd){
            System.out.println("commande enregistré");
        }else
        {
             System.out.println("commande Non enregistré");
        }
    }
    
}
