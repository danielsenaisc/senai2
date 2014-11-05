/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo Calandrini
 */
public class ImageSaver {
    
    public static void saveImage(/* File image */){
        String targetDirectoryToSaveTheImage = ""/*+image.name()*/;
        //TODO imlementar metodo que salva a imagem no servidor
    }
    
    public static File retrieveImageFile(String url){
        //TODO implementar regras para recuperação de imagem
        return new File(url);
    }
    
    public static ImageIcon retrieveImageIcon(String url){
        //TODO implementar regras para recuperação de imagem
        return new ImageIcon(url);
    }
    
    public static byte[] retrieveImageBytecode(String url){
        byte[] imageBytecode = new byte[(int) retrieveImageFile(url).length()];
        
        //TODO implementar regras para recuperação de imagem

        try {
            FileInputStream fileInputStream = new FileInputStream(retrieveImageFile(url));
            fileInputStream.read(imageBytecode);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return imageBytecode;
    }
     
    //Pode-se substituir a String url por qualquer variação como URL, File...
    
    
}
