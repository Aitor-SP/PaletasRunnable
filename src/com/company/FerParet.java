package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class FerParet implements Runnable {

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        int numMaons = 10, ti, te;
        int numPaletes = 5;

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        //instanciem els paletes
        Paleta[] P = new Paleta[numPaletes];


        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();


        //Donem nom als paletes i els posem a fer fer la paret
        Runnable runnable = () -> {
            for (int i=0;i<numPaletes;i++) {
                P[i] = new Paleta("Paleta-"+i);
                P[i].posaMaons(numMaons);
            }
        };


        //Han acabat i agafem el temps final
        te = (int) System.currentTimeMillis();

        System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
    }
}
