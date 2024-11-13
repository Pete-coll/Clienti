package com.mycompany.clienti;


import com.mycompany.clienti.ListaClienti;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author osamu
 */
public class MainPosta {

    /**
     *
     */
    public static final int NumeroSportelli = 3;
    public static void main (String[] args){
        
        ListaClienti ListaClienti = new ListaClienti();
        
        Thread arriviThread = new Thread(new Arrivi(ListaClienti));
        
        Thread sportelloThread = new Thread(new Sportello(ListaClienti));
        
        ArrayList<Thread> sportelloThreadList = new ArrayList<>();
        
       
        arriviThread.start();
        for(int i = 0; i<NumeroSportelli; i++){
            Thread sportelloThread = new Thread(new Sportello(ListaClienti, i+1));
            sportelloThreadList.add(sportelloThread);
            sportelloThread.start();
        }
        
    }
}
