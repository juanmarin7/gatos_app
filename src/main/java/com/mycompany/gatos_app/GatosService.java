/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatos_app;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author SSSA
 */
public class GatosService {
    public static void verGatos() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();
        
        String elJSON = response.body().string();
        //QUITAR CONRCHETES
        elJSON = elJSON.substring(1,elJSON.length());
        elJSON = elJSON.substring(0,elJSON.length()-1);
        
        //objeto clase gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJSON, Gatos.class);
        
        //redimesionar imagen
        Image image = null;
         try {
            URL url = new URL(gatos.getURL());
        } catch (Exception e) {
        }
    }
}
