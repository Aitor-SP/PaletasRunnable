package com.company;

import java.util.concurrent.*;

public class FerParet {


    public static void main(String[] args) {
        int numMaons = 10, ti;
        final int[] te = new int[1];
        int numPaletes = 5;
        //Definim l'executor dels processos
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        //instanciem els paletes
        Paleta[] paletaList = new Paleta[numPaletes];

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();

        //Donem nom als paletes i els posem a fer fer la paret
        for (int i=0;i<numPaletes;i++) {
            paletaList[i] = new Paleta("Paleta-"+i, numMaons);
            Runnable runnable = paletaList[i];
            executor.schedule(runnable,0, TimeUnit.SECONDS);
        }
        //Tanquem l'executor
        executor.shutdown();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (executor.isTerminated()) {
                        //Han acabat i agafem el temps final
                        te[0] = (int) System.currentTimeMillis();
                        System.out.println("Han afegit: " + (te[0] - ti)/1000 + " segons");
                        break;
                    }
                }
            }
        };
        runnable.run();
    }
}
