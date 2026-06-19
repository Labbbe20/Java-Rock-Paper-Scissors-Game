/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schere_stein_papier;

import static schere_stein_papier.Schere_Stein_Papier.aktionen;
import static schere_stein_papier.Schere_Stein_Papier.gui;

/**
 *
 * @author abeling
 */
public class Aktionen {
    boolean linkeSeiteAusgewaehlt = false;
    boolean rechteSeiteAusgewaehlt = false;
    String linksAuswahl;
    String rechtsAuswahl;
    public Aktionen(){
        
    }
    
    public void spielstart(){
        Schere_Stein_Papier.gui.buttonSchereLinks.setVisible(true);
        Schere_Stein_Papier.gui.buttonSteinLinks.setVisible(true);
        Schere_Stein_Papier.gui.buttonPapierLinks.setVisible(true);
        Schere_Stein_Papier.gui.buttonSchereRechts.setVisible(true);
        Schere_Stein_Papier.gui.buttonSteinRechts.setVisible(true);
        Schere_Stein_Papier.gui.buttonPapierRechts.setVisible(true);
        Schere_Stein_Papier.gui.spielStart.setVisible(false);
        linkeSeiteAusgewaehlt = false;
        rechteSeiteAusgewaehlt = false;
    }
    
    public void neuesSpielStarten(){
        Schere_Stein_Papier.gui.frame.dispose();
        Schere_Stein_Papier.gui.spielstart();
        spielstart();
    }
    
    public void auswaehlSetzter(String seite){
        switch(seite){
            case "links":
                linkeSeiteAusgewaehlt = true;
                
                break;
            case "rechts":
                rechteSeiteAusgewaehlt = true;
                break;
            default:
                System.out.println("Error Aktionen.auswaehlSetzer().switch");
        }
        if(linkeSeiteAusgewaehlt == true && rechteSeiteAusgewaehlt == true){
                ergebnisAusgabe();
        }
    }
    
    private void ergebnisAusgabe(){
        linksAuswahl = Schere_Stein_Papier.gui.auswahlLinks;
        rechtsAuswahl =  Schere_Stein_Papier.gui.auswahlRechts;
        System.out.println("links " + linksAuswahl);
        System.out.println("rechts " + rechtsAuswahl);
        
        //schere
        if(linksAuswahl == "schere" && rechtsAuswahl == "schere"){
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "schereGegenSchere");
            Schere_Stein_Papier.gui.gewinnmakierung("unendschieden");
            
        }
        if(linksAuswahl == "schere" && rechtsAuswahl == "papier"){
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "papierGegenSchere");
            Schere_Stein_Papier.gui.gewinnmakierung("links");
            
        }
        if(linksAuswahl == "schere" && rechtsAuswahl == "stein"){
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "schereGegenStein");
            Schere_Stein_Papier.gui.gewinnmakierung("rechts");
            
        }
        if(linksAuswahl == "stein" && rechtsAuswahl == "schere"){
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "schereGegenStein");
            Schere_Stein_Papier.gui.gewinnmakierung("links");
            
        }
        if(linksAuswahl == "papier" && rechtsAuswahl == "schere"){
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "papierGegenSchere");
            Schere_Stein_Papier.gui.gewinnmakierung("rechts");
            
        }
        
        //papier
        
        if(linksAuswahl == "papier" && rechtsAuswahl == "papier"){
            //Unendschieden Papier Papier
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "papierGegenPapier");
            Schere_Stein_Papier.gui.gewinnmakierung("unendschieden");
            
        }
        if(linksAuswahl == "papier" && rechtsAuswahl == "stein"){
            //Unendschieden Papier Papier
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "papierGegenStein");
            Schere_Stein_Papier.gui.gewinnmakierung("links");
            
        }
        if(linksAuswahl == "stein" && rechtsAuswahl == "papier"){
            //Unendschieden Papier Papier
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "papierGegenStein");
            Schere_Stein_Papier.gui.gewinnmakierung("rechts");
            
        }
        
        //stein
        if(linksAuswahl == "stein" && rechtsAuswahl == "stein"){
            //Unendschieden Papier Papier
            Schere_Stein_Papier.gui.spielzuganzeige("ergebnis", "steinGegenStein");
            Schere_Stein_Papier.gui.gewinnmakierung("unendschieden");
            
        }
        
        
    }
}
