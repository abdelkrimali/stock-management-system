package dbase;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alilo
 */
public class Designer_interface extends JFrame{
    
    JFrame fenetre;
    JLabel helpme;
 
    
    
    public Designer_interface(String title)
    {
        super(title);
        this.setSize(950,800);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
        
                
                this.setVisible(true);
        
    }
    
    
    public static void main(String args[])
    {
        Designer_interface ds=new Designer_interface("interface ");
    }
    
}
