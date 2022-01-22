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
public class Detaille {
    private int commande;
    private int reference;
    private double qte;

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }
    
    public void add()
    {
         String add="insert into detaille_commande values("
                +reference+","
                +commande+","
                +qte+" )";
        boolean isadd=dbase.Go.runNonQuery(add);
        if(isadd){
            System.out.println("commande enregistré");
        }else
        {
             System.out.println("commande Non enregistré");
        }
    }
    
}
