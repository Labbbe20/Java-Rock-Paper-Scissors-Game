/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schere_stein_papier;

import com.sun.tools.javac.Main;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author abeling
 */
public class GUI { 
//Bildschirmgröße abfragen
    private final Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

//Größen zum rechnen
    private final int x_groeße =  screensize.width;
    private final int y_groeße =  (int)(0.95*screensize.height);

//Globale Variablen
    Aktionen aktion;
    String auswahlLinks;
    String auswahlRechts;
    JFrame frame;
    JButton spielStart;
    JButton neuesSpielStart;
    JLabel linkerSpielerSpielZugText;
    JLabel rechterSpielerSpielZugText;
    JLabel linkerSpielerSpielZug;
    JLabel rechterSpielerSpielZug;
    JLabel ergebnisBild;
    JPanel makierungLinks;
    JPanel makierungRechts;
    //Bilder
    ImageIcon iconSchere;
    ImageIcon iconStein;
    ImageIcon iconPapier;
    ImageIcon iconPapierGegenSchere;
    ImageIcon iconPapierGegenStein;
    ImageIcon iconSchereGegenStein;
    ImageIcon iconSchereGegenSchere;
    ImageIcon iconPapierGegenPapier;
    ImageIcon iconSteinGegenStein;
    
    //Schere
    JButton buttonSchereLinks;
    JButton buttonSchereRechts;
    //Stein
    JButton buttonSteinLinks;
    JButton buttonSteinRechts;
    //Papier
    JButton buttonPapierLinks;
    JButton buttonPapierRechts;
    
    
    public GUI(Aktionen aktionen){
        spielstart();
        
        aktion = aktionen;
    }
    
    public void spielstart(){
        fensterErzeugen();
        ueberschriften();
        bilder();
        buttons();
        
        //JFrame sichtbar machen
        frame.setVisible(true);
    }
    
    public void fensterErzeugen(){
       frame = new JFrame("Schere Stein Papier");
       frame.setSize(x_groeße, y_groeße);
       frame.setLayout(null);
       frame.setLocationRelativeTo(null);
       //frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void ueberschriften(){
        JLabel schereSteinPapier = new JLabel ("Schere Stein Papier",JLabel.CENTER);
        schereSteinPapier.setBounds(0, (int)(0.0001*y_groeße), x_groeße, (int)(0.1*y_groeße));
        schereSteinPapier.setFont(schereSteinPapier.getFont().deriveFont(40f));
        frame.add(schereSteinPapier);
        
        rechterSpielerSpielZugText = new JLabel("Spielzug", JLabel.CENTER);
        rechterSpielerSpielZugText.setBounds((int)(0.64*x_groeße), (int)(0.30*y_groeße), 150, 50);
        rechterSpielerSpielZugText.setFont(rechterSpielerSpielZugText.getFont().deriveFont(18f));
        rechterSpielerSpielZugText.setVisible(false);
        frame.add(rechterSpielerSpielZugText);
        
        linkerSpielerSpielZugText = new JLabel("Spielzug", JLabel.CENTER);
        linkerSpielerSpielZugText.setBounds((int)(0.27*x_groeße), (int)(0.30*y_groeße), 150, 50);
        linkerSpielerSpielZugText.setFont(linkerSpielerSpielZugText.getFont().deriveFont(18f));
        linkerSpielerSpielZugText.setVisible(false);
        frame.add(linkerSpielerSpielZugText);
    }
    
    public void bilder(){
        iconSchere = new ImageIcon(getClass().getResource("Bilder/Schere.jpg"));
        iconStein = new ImageIcon(getClass().getResource("Bilder/Stein.jpg"));
        iconPapier = new ImageIcon(getClass().getResource("Bilder/Papier.jpg"));
        iconPapierGegenSchere = new ImageIcon(getClass().getResource("Bilder/Papier_gegen_Schere.jpg"));
        iconPapierGegenStein = new ImageIcon(getClass().getResource("Bilder/Papier_gegen_Stein.jpg"));
        iconSchereGegenStein = new ImageIcon(getClass().getResource("Bilder/Schere_gegen_Stein.jpg"));
        iconSchereGegenSchere = new ImageIcon(getClass().getResource("Bilder/Unendschieden_Schere_gegen_Schere.jpg"));
        iconPapierGegenPapier = new ImageIcon(getClass().getResource("Bilder/Unendschieden_Papier_gegen_Papier.jpg"));
        iconSteinGegenStein = new ImageIcon(getClass().getResource("Bilder/Unendschieden_Stein_gegen_Stein.jpg"));
    }
    
    public void buttons(){
    //Spiel Start
        spielStart = new JButton("Spiel starten");
        spielStart.setBounds((int)(0.45*x_groeße), (int)(0.4*y_groeße), (int)(0.1*x_groeße), (int)(0.05*y_groeße));
        spielStart.addActionListener(e -> aktion.spielstart());
        frame.add(spielStart);
    
    //Neues Spiel
        neuesSpielStart = new JButton("Neues spiel starten");
        neuesSpielStart.setBounds((int)(0.45*x_groeße), (int)(0.6*y_groeße), (int)(0.1*x_groeße), (int)(0.05*y_groeße));
        neuesSpielStart.addActionListener(e -> aktion.neuesSpielStarten());
        neuesSpielStart.setVisible(false);
        frame.add(neuesSpielStart);
        
    //Links 
        //Schere
        buttonSchereLinks = new JButton(iconSchere);
        buttonSchereLinks.setBounds((int)(0.1*x_groeße), (int)(0.12*y_groeße), 150, 150);
        buttonSchereLinks.setBackground(Color.WHITE);
        buttonSchereLinks.addActionListener(e -> spielzugauswahl("links", "schere"));
        buttonSchereLinks.setVisible(false);
        frame.add(buttonSchereLinks);
        
        //Stein
        buttonSteinLinks = new JButton(iconStein);
        buttonSteinLinks.setBounds((int)(0.1*x_groeße), (int)(0.35*y_groeße), 150, 150);
        buttonSteinLinks.setBackground(Color.WHITE);
        buttonSteinLinks.addActionListener(e -> spielzugauswahl("links", "stein"));
        buttonSteinLinks.setVisible(false);
        frame.add(buttonSteinLinks);
        
        //Papier
        buttonPapierLinks = new JButton(iconPapier);
        buttonPapierLinks.setBounds((int)(0.1*x_groeße), (int)(0.58*y_groeße), 150, 150);
        buttonPapierLinks.setBackground(Color.WHITE);
        buttonPapierLinks.addActionListener(e -> spielzugauswahl("links", "papier"));
        buttonPapierLinks.setVisible(false);
        frame.add(buttonPapierLinks);
        
    //Rechts
        //Schere
        buttonSchereRechts = new JButton(iconSchere);
        buttonSchereRechts.setBounds((int)(0.8*x_groeße), (int)(0.12*y_groeße), 150, 150);
        buttonSchereRechts.setBackground(Color.WHITE);
        buttonSchereRechts.addActionListener(e -> spielzugauswahl("rechts", "schere"));
        buttonSchereRechts.setVisible(false);
        frame.add(buttonSchereRechts);
        
        //Stein
        buttonSteinRechts = new JButton(iconStein);
        buttonSteinRechts.setBounds((int)(0.8*x_groeße), (int)(0.35*y_groeße), 150, 150);
        buttonSteinRechts.setBackground(Color.WHITE);
        buttonSteinRechts.addActionListener(e -> spielzugauswahl("rechts", "stein"));
        buttonSteinRechts.setVisible(false);
        frame.add(buttonSteinRechts);
        
        //Papier
        buttonPapierRechts = new JButton(iconPapier);
        buttonPapierRechts.setBounds((int)(0.8*x_groeße), (int)(0.58*y_groeße), 150, 150);
        buttonPapierRechts.setBackground(Color.WHITE);
        buttonPapierRechts.addActionListener(e -> spielzugauswahl("rechts", "papier"));
        buttonPapierRechts.setVisible(false);
        frame.add(buttonPapierRechts);
    }
    
    private void spielzugauswahl(String spieler, String waffenwahl){
        if(spieler == "links"){
            switch(waffenwahl){
            case "schere":
                auswahlLinks = "schere";
                aktion.auswaehlSetzter("links");
                break;
            
            case "stein":
                auswahlLinks = "stein";
                aktion.auswaehlSetzter("links");
                break;
                
            case "papier":
                auswahlLinks = "papier";
                aktion.auswaehlSetzter("links");
                break;
            }
        }else if(spieler == "rechts"){
            switch(waffenwahl){
            case "schere":
                auswahlRechts = "schere";
                aktion.auswaehlSetzter("rechts");
                break;
            
            case "stein":
                auswahlRechts = "stein";
                aktion.auswaehlSetzter("rechts");
                break;
                
            case "papier":
                auswahlRechts = "papier";
                aktion.auswaehlSetzter("rechts");
                break;
            }
        }
        
        if(Schere_Stein_Papier.aktionen.linkeSeiteAusgewaehlt == true && Schere_Stein_Papier.aktionen.rechteSeiteAusgewaehlt == true){
            spielzuganzeige("links", auswahlLinks);
            spielzuganzeige("rechts", auswahlRechts);
        }
    }
    
    public void spielzuganzeige(String spieler, String waffenwahl){
        
        makierungLinks = new JPanel();
        makierungLinks.setBounds((int)(0.27*x_groeße), (int)(0.345*y_groeße), 155, 155);
        makierungLinks.setOpaque(false);
        makierungLinks.setVisible(false);
        frame.add(makierungLinks);
        
        makierungRechts = new JPanel();
        makierungRechts.setBounds((int)(0.64*x_groeße), (int)(0.345*y_groeße), 155, 155);
        makierungRechts.setOpaque(false); 
        makierungRechts.setVisible(false);
        frame.add(makierungRechts);
        
        linkerSpielerSpielZug = new JLabel();
        linkerSpielerSpielZug.setBounds((int)(0.27*x_groeße), (int)(0.35*y_groeße), 150, 150);
        frame.add(linkerSpielerSpielZug);
        
        rechterSpielerSpielZug = new JLabel();
        rechterSpielerSpielZug.setBounds((int)(0.64*x_groeße), (int)(0.35*y_groeße), 150, 150);
        frame.add(rechterSpielerSpielZug);
        
        ergebnisBild = new JLabel();
        ergebnisBild.setBounds((int)(0.42*x_groeße), (int)(0.29*y_groeße), 300, 300);
        frame.add(ergebnisBild);
        
        
        
    ergebnisBild = new JLabel();
        ergebnisBild.setBounds((int)(0.42*x_groeße), (int)(0.29*y_groeße), 300, 300);
        frame.add(ergebnisBild);
        if(spieler == "links"){
            switch(waffenwahl){
            case "schere":
                linkerSpielerSpielZug.setIcon(iconSchere);
                linkerSpielerSpielZug.setVisible(true);
                linkerSpielerSpielZugText.setVisible(true);
                break;
            
            case "stein":
                linkerSpielerSpielZug.setIcon(iconStein);
                linkerSpielerSpielZug.setVisible(true);
                linkerSpielerSpielZugText.setVisible(true);
                break;
                
            case "papier":
                linkerSpielerSpielZug.setIcon(iconPapier);
                linkerSpielerSpielZug.setVisible(true);
                linkerSpielerSpielZugText.setVisible(true);
                break;
            }
        }else if(spieler == "rechts"){
            switch(waffenwahl){
            case "schere":
                rechterSpielerSpielZug.setIcon(iconSchere);
                rechterSpielerSpielZug.setVisible(true);
                rechterSpielerSpielZugText.setVisible(true);
                break;
            
            case "stein":
                rechterSpielerSpielZug.setIcon(iconStein);
                rechterSpielerSpielZug.setVisible(true);
                rechterSpielerSpielZugText.setVisible(true);
                break;
                
            case "papier":
                rechterSpielerSpielZug.setIcon(iconPapier);
                rechterSpielerSpielZug.setVisible(true);
                rechterSpielerSpielZugText.setVisible(true);
                break;
            }
        }else if(spieler == "ergebnis"){
            switch(waffenwahl){
            case "papierGegenSchere":
                System.out.println("wurde ausgewührt");
                ergebnisBild.setIcon(iconPapierGegenSchere);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
            
            case "papierGegenStein":
                ergebnisBild.setIcon(iconPapierGegenStein);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
                
            case "schereGegenStein":
                ergebnisBild.setIcon(iconSchereGegenStein);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
            
            case "schereGegenSchere":
                ergebnisBild.setIcon(iconSchereGegenSchere);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
             
            case "papierGegenPapier":
                ergebnisBild.setIcon(iconPapierGegenPapier);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
                
            case "steinGegenStein":
                ergebnisBild.setIcon(iconSteinGegenStein);
                ergebnisBild.setVisible(true);
                neuesSpielStart.setVisible(true);
                break;
        }
        }
        
    }
    
    public void gewinnmakierung(String gewinner){
        
        switch(gewinner){
            case "links":
                //Gewinner Links
                //links
                makierungLinks.setVisible(true);
                makierungLinks.setBorder(BorderFactory.createLineBorder(Color.green, 5));
                //rechts
                makierungRechts.setVisible(true);
                makierungRechts.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                break;
            case "rechts":
                //Gewinner Rechts
                //links
                makierungLinks.setVisible(true);
                makierungLinks.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                //rechts
                makierungRechts.setVisible(true);
                makierungRechts.setBorder(BorderFactory.createLineBorder(Color.green, 5));
                break;
                
            case "unendschieden":
                //Unendschieden
                //links
                makierungLinks.setVisible(true);
                makierungLinks.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                //rechts
                makierungRechts.setVisible(true);
                makierungRechts.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                break;
                
            default:
                System.out.println("error GUI.gwinnmakierung");
        }
        
    }
}

