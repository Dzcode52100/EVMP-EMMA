package com.EVMP.EMMA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
	
	public static void main(String [] args) {
	
		
        List<VM> v = new ArrayList<VM>();
		
		List<Server> svr = new ArrayList<Server>();
		
		int n;
		int m;	
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nombre de la liste VM :");
		n = sc.nextInt();
		
		
		System.out.println("-----------------------------VMs------------------------------");
		
        for(int i=0;i<n;i++) {
			
			v.add(new VM());
		    System.out.println(i+"-CPU de VM:"+"\t"+v.get(i).getCPU_MIPS()+"\t"+
		    		i+"-Memoire de VM:"+"\t"+v.get(i).getMEMORY()+"\t"+
		    		i+"-Network de VM:"+i+"\t"+v.get(i).getNETWORK());
		    System.out.println("-------------------------********---------------------------------");
		    
		   }
       
        
        System.out.println("-------------------------Serveurs---------------------------------");
		
		System.out.println("Entrez le nombre de la liste Serveur :");
		m = sc.nextInt();	
		for(int i=0;i<m;i++) {
	      svr.add(new Server());
	      System.out.println("CPU de Serveur:"+i+"\t"+svr.get(i).getCPU_MIPS()+"\t"+
		    		         "Memoire de Serveur:"+i+"\t"+svr.get(i).getMEMORY()+"\t"+"\t"+
		    		         "Network de serveur:"+i+"\t"+svr.get(i).getNETWORK());
	      System.out.println("-------------------------*******---------------------------------");
		}
			
		   List<VM>lvm;
		   
	       EVMP_EMMA evmp = new EVMP_EMMA();
	      
	       lvm = evmp.sortingVMList(v);
	       System.out.println("----------------------Le triage de la liste VMs--------------------------------");
	       
	       evmp.afficheListVM(lvm);
	       
	       System.out.println("--------------------------------------------------------------------------------------------");
	       
           evmp.InserVMinServer(svr, lvm);
       	   System.out.println("\n");
          System.out.println("------------------------------Totale Utilisation de serveurs-----------------------------------");
       	   
       	  evmp.getTotalUtilisation(svr, lvm); 
       	 
          System.out.println("---------------------- Consomation d'énergé-------------------------------------------------");
           
          evmp.Energy(svr, lvm);
       	  System.out.println("\n");
           
       	 System.out.println("---------------------- Le Moyne dutilisation des ressource ----------------------------------");
       	 evmp.IR(svr, lvm);
       	
    	 System.out.println("\n");
     	 System.out.println("----------------------Equilibrage Muli Demension-----------------------------------");
     	 evmp.IUV(svr, lvm);
     	
     	 System.out.println("\n");
     	 
    	 System.out.println("----------------------Equilibrage Utilisation et Consomation d'énergé -----------------------------------");
    	 
    	 evmp.SMi(svr, lvm);
    	
     	System.out.println("--------------------------------------------Ajoute VM par le contrainte SMi-----------------------------------------------------------------");
     	evmp.ajoutVMEVMP(svr, lvm);
     	System.out.println("----------------------------------------------------------------------------------------------------");

       
       evmp.migrationList(svr, lvm);
          
       
	}
	
  
        	 
        	 
         }
  
	

	

