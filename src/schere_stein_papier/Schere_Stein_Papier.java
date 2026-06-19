/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schere_stein_papier;

/**
 *
 * @author abeling
 */
public class Schere_Stein_Papier {

    /**
     * @param args the command line arguments
     */
    public static Aktionen aktionen;
    public static GUI gui;
    public static void main(String[] args) {
        aktionen = new Aktionen();
        gui = new GUI(aktionen);
        
    }
    
}
