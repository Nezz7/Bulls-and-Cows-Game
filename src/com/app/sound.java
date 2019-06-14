/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Mes dossiers
 */
public class sound {
    public static void main (String [] args )
    {         new MenuJFrame().setVisible (true);

         try {
                    File file = new File ("/Images/Music.mp3");
                    FileInputStream fis = new FileInputStream (file);
                    BufferedInputStream bis = new BufferedInputStream (fis);
                   
                        Player player = new Player (bis);
                        player.play();
                        
                            
                }catch(Exception e ){System.out.println (e.toString());}
    }    
}
