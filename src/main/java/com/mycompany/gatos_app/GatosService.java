/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatos_app;

import com.google.gson.Gson;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Response;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 *  
 OkHttpClient client = new OkHttpClient().newBuilder().build();
    Request request = new Request.Builder()
    .url(“https://api.thecatapi.com/v1/images/search”)
    .method(“GET”, null)
    .build();
    Response response = client.newCall(request).execute();
 */
public class GatosService {
    public static void verGatos() throws IOException {
        //1. vamos a traer los datos de la API
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();

        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        //cortar los corchetes
        elJson = elJson.substring(1, elJson.length() - 1);

        //crear u objeto de la clase Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        //redimensionar en caso de necesitar
        Image image = null;
            try{
        URL url = new URL(gatos.getUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.addRequestProperty("User-Agent", "");
        BufferedImage bufferedImage = ImageIO.read(http.getInputStream());
        ImageIcon fondoGato = new ImageIcon(bufferedImage);
        
        if(fondoGato.getIconWidth() > 800 || fondoGato.getIconHeight() > 400){
            
            Image fondo = fondoGato.getImage();
            Image modificada = fondo.getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH);
            fondoGato = new ImageIcon(modificada);
        }   
            
        String menu =  "Opciones: \n1.- Cambiar Gatitos \n2.-Favorito \n3.-Volver ";
        String botones[] = { "Ver Otra imagen", "Favoritos", "Volver"};
        String id_gato = gatos.getId();
        String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE
                ,fondoGato,botones,botones[0]);
        
        int seleccion = -1;
        
        for(int i = 0; i < botones.length;i++){
            if(opcion.equals(botones[i])){
                seleccion = i;
            }
        }
        
        switch(seleccion){
            case 0:
                //verGatitos();
                break;
            case 1:
             //   favoritos(gatos);
                break;
            default:
                break;             
        }
        
    }catch(IOException e){
        System.out.println(e);
    }
      
    
}
    
    public static void favoritoGato(Gatos gato){
    
    }
}
