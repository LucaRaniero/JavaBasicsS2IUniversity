package javabasics;
import javabasics.controller.Controller;


public class Main {
	
	public static void main(String[] args) {
		//Introduzione al servizio + start dell'applicazione
		System.out.println("Ciao, Il servizio PoolingAround è nato per facilitare gli spostamenti di viaggiatori leggeri, ");
		System.out.println("studenti fuori sede e professionisti. Il servizio permette di risparmiare denaro ed emissioni, ");
		System.out.println("permettendo di dividere i costi del viaggio e di riempire i posti di una macchina che sarebbe ");
		System.out.println("altrimenti rimasta semivuota.");
		System.out.println("");
		
		Controller controller = new Controller();
		controller.start();
		
	}
}
