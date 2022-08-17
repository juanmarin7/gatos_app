/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatos_app;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author SSSA
 */
public class Gatos_app {
    public static void main(String[] args) throws IOException {
        int opcionMenu = -1;
        String[] botones = {"1. Ver Gatos","2.Salir"};
        
        do {    
            //MENU PRINCIPAL
            String opcion = (String) JOptionPane.showInputDialog(null,"Gatitos java", "Menu Principal",JOptionPane.INFORMATION_MESSAGE,null,botones,botones[0]);
            
            //VALIDAMOS EL USUARIO
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])){
                    opcionMenu = i;
                }
            }
            
            switch (opcionMenu) {
                case 0:
                    System.out.println("Error D:");
                    GatosService.verGatos();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcionMenu != -1);
        
    }
}
