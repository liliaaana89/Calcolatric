package com.example;


import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {


   public static void main(String[] args) throws Exception {


       // Connessione al server
       Socket socket = new Socket("10.22.10.17", 3000);
       Scanner scanner = new Scanner(System.in);


       // Per inviare dati al server
       PrintWriter out = new PrintWriter(
               socket.getOutputStream(), true
       );


       // Per ricevere la risposta dal server
       BufferedReader in = new BufferedReader(
               new InputStreamReader(socket.getInputStream())
       );


       System.out.println("Connesso al server!");


       boolean continua = true;


       while (continua) {


           System.out.println("MENU");
           System.out.println("1 - Addizione");
           System.out.println("2 - Sottrazione");
           System.out.println("3 - Moltiplicazione");
           System.out.println("4 - Divisione");
           System.out.println("5 - Potenza");
           System.out.println("6 - Radice");
           System.out.println("7 - Arrotondamento");
           System.out.println("8 - Espressione");
           System.out.println("0 - Esci");


           System.out.print("Scegli un'operazione: ");


           int scelta = scanner.nextInt();
           scanner.nextLine();


           String operazione = "";


           switch (scelta) {


               // ADDIZIONE
               case 1: {
                   System.out.print("Inserisci il primo numero: ");
                   String numero1 = scanner.nextLine();


                   System.out.print("Inserisci il secondo numero: ");
                   String numero2 = scanner.nextLine();


                   numero1 = numero1.replace(",", ".");
                   numero2 = numero2.replace(",", ".");


                   operazione = "1" + " " + numero1 + " "+ numero2 ;
                   break;
               }


               // SOTTRAZIONE
               case 2: {
                   System.out.print("Inserisci il primo numero: ");
                   String numero1 = scanner.nextLine();


                   System.out.print("Inserisci il secondo numero: ");
                   String numero2 = scanner.nextLine();


                   numero1 = numero1.replace(",", ".");
                   numero2 = numero2.replace(",", ".");


                   operazione = "2" + " " + numero1 + " "+ numero2 ;
                   break;
               }


               // MOLTIPLICAZIONE
               case 3: {
                   System.out.print("Inserisci il primo numero: ");
                   String numero1 = scanner.nextLine();


                   System.out.print("Inserisci il secondo numero: ");
                   String numero2 = scanner.nextLine();


                   numero1 = numero1.replace(",", ".");
                   numero2 = numero2.replace(",", ".");


                   operazione = "3" + " " + numero1 + " "+ numero2 ;
                   break;
               }


               // DIVISIONE
               case 4: {
                   System.out.print("Inserisci il primo numero: ");
                   String numero1 = scanner.nextLine();


                   System.out.print("Inserisci il secondo numero: ");
                   String numero2 = scanner.nextLine();


                   numero1 = numero1.replace(",", ".");
                   numero2 = numero2.replace(",", ".");


                   operazione = "4" + " " + numero1 + " "+ numero2 ;
                   break;
               }


               // POTENZA
               case 5: {
                   System.out.print("Inserisci la base: ");
                   String base = scanner.nextLine();


                   System.out.print("Inserisci l'esponente: ");
                   String esponente = scanner.nextLine();


                   base = base.replace(",", ".");
                   esponente = esponente.replace(",", ".");


                   operazione = "5" + " " + base + " "+ esponente ;
                   break;
               }


               // RADICE
               case 6: {
                   System.out.print("Inserisci il numero: ");
                   String numero = scanner.nextLine();


                   numero = numero.replace(",", ".");
                   int s = 0;


                   operazione = "6" + " " + numero + " " + s;
                   break;
               }


               // ARROTONDAMENTO
               case 7: {
                   System.out.print("Inserisci il numero: ");
                   String numero = scanner.nextLine();


                   System.out.print("Quante cifre decimali vuoi mantenere? ");
                   String decimali = scanner.nextLine();


                   numero = numero.replace(",", ".");


                   operazione = "7 " + " " + numero + " " + "," + decimali + " ";
                   break;
               }


               case 0: {
                   out.println("EXIT");
                   continua = false;
                   break;
               }


               default: {
                   System.out.println("Scelta non valida.");
                   break;
               }
           }


           if (!operazione.equals("")) {
    
               String richiesta =  operazione;
                   
               System.out.println("Richiesta: " + richiesta);
          
               out.println(richiesta);


               String risposta = in.readLine();


               System.out.println("Risultato: " + risposta);
           }
       }


       // Chiusura delle risorse
       scanner.close();
       in.close();
       out.close();
       socket.close();


       System.out.println("Client terminato.");
   }
}



