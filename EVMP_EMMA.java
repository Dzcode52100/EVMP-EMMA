package com.EVMP.EMMA;

import java.util.ArrayList;
import java.util.List;

public class EVMP_EMMA {
	
	void afficheListVM(List<VM>vm) {
		for(int i=0;i<vm.size();i++) {
			System.out.println("------------------------------------------------");
			System.out.println("Le CPU_VM:"+i+"\t"+vm.get(i).getCPU_MIPS()+"\t"
					+"Le M�moire_VM:"+i+"\t"+vm.get(i).getMEMORY()+"\t"
					+"Le Network_VM:"+i+"\t"+vm.get(i).getNETWORK());
			System.out.println("--------------------------------------------------");
		}
	}
	
	
public void InserVMinServer(List<Server> lsv, List<VM> lisvm) {
	
	double cpu = 0;
	double mem = 0;
	double net = 0;
	
	int i=-1;
	int j=-1;
	boolean isAlocated;
	
	for(Server sv : lsv) { 
		i=i+1;
		cpu = cpu+sv.getCPU_MIPS();
		mem = mem+sv.getMEMORY();
		net = net+sv.getNETWORK();
		
	
	 for(VM vm: lisvm) {
			isAlocated = false;
			
			 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
				
			isAlocated = true;
			 j=j+1;
		}
			
		
		if((isAlocated == true) &&(j<lisvm.size())) {
				
				System.out.println("VM:"+j+"\t"+"ajoute dans serveure:"+i);
				
				 cpu = cpu-vm.CPU_MIPS;
				 mem = mem-vm.MEMORY;
				 net = net-vm.NETWORK;
				 
				 System.out.println("------------------------------------------------------------");
				 
				 System.out.println("Le Reste CPU de serveur"+i+" \t"+cpu);
				 System.out.println("Le Reste RAM de serveur"+i+" \t"+mem);
				 System.out.println("Le Reste NET de serveur"+i+" \t"+net);
				 
				 System.out.println("-------------------------------------------------------------");
				 
	 }
		
				
	}
	 cpu =0;
	 mem = 0;
	 net = 0;
  }        
}


 public void Energy(List<Server> lsv, List<VM> lisvm) {
	 
	 
	    double Energy;
	    double EnergyTotal;
	    double avgCPUSV;
	    double cpuvm;
	    
	    double cpu = 0;
		double mem = 0;
		double net = 0;
		
		int i=-1;
		int j=-1;
		boolean isAlocated;
		
		for(Server sv : lsv) { 
			i=i+1;
			cpu = cpu+sv.getCPU_MIPS();
			mem = mem+sv.getMEMORY();
			net = net+sv.getNETWORK();
			avgCPUSV = 0;
			Energy = 0;
			EnergyTotal = 0;
		
		 for(VM vm: lisvm) {
				isAlocated = false;
				
				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
					
				isAlocated = true;
				 j=j+1;
			}
				
			
			if((isAlocated == true) &&(j<lisvm.size())) {
				
				cpuvm = vm.getCPU_MIPS();
				avgCPUSV = cpu/cpuvm;
				
				Energy = getEnergyConsumption(avgCPUSV);
				EnergyTotal = EnergyTotal+Energy;
				System.out.println("Ener� consom� dans Server:"+i+"\t"+Energy+"W");
				
				 cpu = cpu-vm.CPU_MIPS;
				 mem = mem-vm.MEMORY;
				 net = net-vm.NETWORK;
					 
		 }
			
		}
		 
		 cpu = 0;
		 mem = 0;
		 net = 0;
		 
		 System.out.println("La valeur d'Energ� Total de serveur:"+i+"est:"+EnergyTotal+"w");
		 System.out.println("--------------------------------------------------------------------");
		 System.out.println("\n");
		 
	  }        
 }

 public double getEnergyConsumption(double avgCPU) {
	 
	double P;
	double kPmax = 175;
	double kp = 75;
	
	P = kPmax + (kp*avgCPU);
     
     return P;
     
    	
  }
 
 public void IR(List<Server> lsv, List<VM> lisvm) {
	 
	  double IR;
	  double IRTotale;
	  double avgCPUSV;
	  double avgRAMSV;
	  double avgNETSV;
	  
	  double cpuvm;
	  double memvm;
	  double netvm;
	    
	    double cpu = 0;
		double mem = 0;
		double net = 0;
		
		int i=-1;
		int j=-1;
		boolean isAlocated;
		
		for(Server sv : lsv) { 
			i=i+1;
			
			cpu = cpu+sv.getCPU_MIPS();
			mem = mem+sv.getMEMORY();
			net = net+sv.getNETWORK();
			
			avgCPUSV = 0;
			avgRAMSV = 0;
			avgNETSV = 0;
			
			IR = 0;
			IRTotale = 0;
		
		 for(VM vm: lisvm) {
				isAlocated = false;
				
				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
					
				isAlocated = true;
				 j=j+1;
			}
				
			
			if((isAlocated == true) &&(j<lisvm.size())) {
				
				cpuvm = vm.getCPU_MIPS();
				memvm = vm.getMEMORY();
				netvm = vm.getNETWORK();
				
				avgCPUSV = cpu/cpuvm;
				avgRAMSV =  mem/memvm;
				avgNETSV = net/netvm;
				
				IR = IR_ResouseUtlisation(avgCPUSV,avgRAMSV,avgNETSV);
				IRTotale = IRTotale+IR;
				
				System.out.println("Le moyene des ressources util� dans Server:"+""+i+" "+IR);
				 System.out.println("--------------------------------------------------------------------");
				 System.out.println("\n");
				
				 cpu = cpu-vm.CPU_MIPS;
				 mem = mem-vm.MEMORY;
				 net = net-vm.NETWORK;
					 
		 }
			
		}
		 
		 cpu = 0;
		 mem = 0;
		 net = 0;
		 
		 System.out.println("La valeur Totale de IR de serveur"+" "+i+"est: "+IRTotale);
	  }        
	 
 }
 
 public double IR_ResouseUtlisation(double cpu, double mem, double net) {

	
    	int a = 3;
    	double IR = (cpu+mem+net)/a;
		return IR;
    }
  
 
 public void IUV(List<Server> lsv, List<VM> lisvm) {
	 
	
	 double IUVTotale = 0;
	  double IUV;
	  double IR;
	  
	  double avgCPUSV;
	  double avgRAMSV;
	  double avgNETSV;
	  
	  double cpuvm;
	  double memvm;
	  double netvm;
	    
	    double cpu = 0;
		double mem = 0;
		double net = 0;
		
		int i=-1;
		int j=-1;
		boolean isAlocated;
		
		for(Server sv : lsv) { 
			i=i+1;
			
			cpu = cpu+sv.getCPU_MIPS();
			mem = mem+sv.getMEMORY();
			net = net+sv.getNETWORK();
			
			avgCPUSV = 0;
			avgRAMSV = 0;
			avgNETSV = 0;
			
			IUV = 0;
			IUVTotale = 0;
		    IR = 0;
		 for(VM vm: lisvm) {
				isAlocated = false;
				
				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
					
				isAlocated = true;
				 j=j+1;
			}
				
			
			if((isAlocated == true) &&(j<lisvm.size())) {
				
				cpuvm = vm.getCPU_MIPS();
				memvm = vm.getMEMORY();
				netvm = vm.getNETWORK();
				
				avgCPUSV = cpu/cpuvm;
				avgRAMSV =  mem/memvm;
				avgNETSV = net/netvm;
				
				IR = IR_ResouseUtlisation(avgCPUSV,avgRAMSV,avgNETSV);
				IUV = IUV_Ubalance(avgCPUSV, avgRAMSV, avgNETSV, IR);
				
				IUVTotale = IUVTotale+ IUV;
				System.out.println("Equilibrage Multi D�mension dans Server:"+i+"\t"+IUV);
				
				
				 cpu = cpu-vm.CPU_MIPS;
				 mem = mem-vm.MEMORY;
				 net = net-vm.NETWORK;
					 
		 }
			
				
		}
		 cpu = 0;
		 mem = 0;
		 net = 0;
		 
		 System.out.println("La valeur Totale IUV de Serveur"+i+"est:"+IUVTotale);
		 System.out.println("--------------------------------------------------------------------");
		 System.out.println("\n");
		
	  }        
	 
 }
 
     public double IUV_Ubalance(double cpu, double mem, double net, double ir) {
    	 
	  double iuv = 0;
	  double c;
	  double m;
	  double n;
	  
	  double pw = 2; 
	  double a=3;
	  
	  c = cpu-ir;
	  m = mem -ir;
	  n = net-ir;
	  
	  iuv = ((Math.pow(c, pw)+Math.pow(m, pw)+Math.pow(n, pw))/a);
	  
	  return iuv;
	  
    	 
     }
     

     public void SMi(List<Server> lsv, List<VM> lisvm) {
    	
      double smTotale = 0;
      double SMi;
      double w1 = 0.5;
      double w2 = 0.5;
      double P;
      
      double IUV;
   	  double IR;
   	  
   	  double avgCPUSV;
   	  double avgRAMSV;
   	  double avgNETSV;
   	  
   	  double cpuvm;
   	  double memvm;
   	  double netvm;
   	    
   	  double cpu = 0;
   	  double mem = 0;
   	  double net = 0;
   		
   		int i=-1;
   		int j=-1;
   		boolean isAlocated;
   		
   		for(Server sv : lsv) { 
   			i=i+1;
   			
   			cpu = cpu+sv.getCPU_MIPS();
   			mem = mem+sv.getMEMORY();
   			net = net+sv.getNETWORK();
   			
   			SMi = 0;
   			smTotale = 0;
   			P=0;
   			
   			avgCPUSV = 0;
   			avgRAMSV = 0;
   			avgNETSV = 0;
   			
   			IUV = 0;
   		    IR = 0;
   		 for(VM vm: lisvm) {
   				isAlocated = false;
   				
   				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
   					
   				isAlocated = true;
   				 j=j+1;
   			}
   				
   			if((isAlocated == true) &&(j<lisvm.size())) {
   				
   				cpuvm = vm.getCPU_MIPS();
   				memvm = vm.getMEMORY();
   				netvm = vm.getNETWORK();
   				
   				avgCPUSV = cpu/cpuvm;
   				avgRAMSV =  mem/memvm;
   				avgNETSV = net/netvm;
   				
   				P = getEnergyConsumption(avgCPUSV);
   				IR = IR_ResouseUtlisation(avgCPUSV,avgRAMSV,avgNETSV);
   				IUV = IUV_Ubalance(avgCPUSV, avgRAMSV, avgNETSV, IR);
   				SMi = w1*IUV* + w2*P;
   		      	smTotale = smTotale+SMi;	
   				System.out.println("des�quilibrage Multi D�mension dans Server SM:"+i+"\t"+SMi);
   				
   				
   				 cpu = cpu-vm.CPU_MIPS;
   				 mem = mem-vm.MEMORY;
   				 net = net-vm.NETWORK;
   				
   			 }
   			
   				
   		}
   		 System.out.println(" La valeur Totale SMi de Sreveur:"+i+"est:"+smTotale);
   		 System.out.println("--------------------------------------------------------------------");
		 System.out.println("\n");
   		 
   	  } 
   }
     public void ajoutVMEVMP(List<Server> lsv, List<VM> lisvm) {
    	 
    	 double SM = 10000000;
    	 double smTotale = 0;
         double SMi;
         double w1 = 0.5;
         double w2 = 0.5;
         double P;
         
         double IUV;
      	 double IR;
      	  
      	  double avgCPUSV;
      	  double avgRAMSV;
      	  double avgNETSV;
      	  
      	  double cpuvm;
      	  double memvm;
      	  double netvm;
      	    
      	  double cpu = 0;
      	  double mem = 0;
      	  double net = 0;
      		
      		int i=-1;
      		int j=-1;
      		boolean isAlocated;
      		
      		for(Server sv : lsv) { 
      			i=i+1;
      			
      			cpu = cpu+sv.getCPU_MIPS();
      			mem = mem+sv.getMEMORY();
      			net = net+sv.getNETWORK();
      			
      			SMi = 0;
      			smTotale = 0;
      			P=0;
      			
      			avgCPUSV = 0;
      			avgRAMSV = 0;
      			avgNETSV = 0;
      			
      			IUV = 0;
      		    IR = 0;
      		 for(VM vm: lisvm) {
      				isAlocated = false;
      				
      				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
      					
      				isAlocated = true;
      				 j=j+1;
      			}
      				
      			if((isAlocated == true) &&(j<lisvm.size())) {
      				
      				cpuvm = vm.getCPU_MIPS();
      				memvm = vm.getMEMORY();
      				netvm = vm.getNETWORK();
      				
      				avgCPUSV = cpu/cpuvm;
      				avgRAMSV =  mem/memvm;
      				avgNETSV = net/netvm;
      				
      				P = getEnergyConsumption(avgCPUSV);
      				IR = IR_ResouseUtlisation(avgCPUSV,avgRAMSV,avgNETSV);
      				IUV = IUV_Ubalance(avgCPUSV, avgRAMSV, avgNETSV, IR);
      				SMi = w1*IUV* + w2*P;
      		      
      				 cpu = cpu-vm.CPU_MIPS;
      				 mem = mem-vm.MEMORY;
      				 net = net-vm.NETWORK;
      				 if(SMi<SM) {
      					 SM = SMi;
      				 }
      				System.out.println("VM:"+j+"\t"+"ajoute dans serveure:"+i);
      				
      			 }		
      		}
      		 
      		 cpu = 0;
      		 mem = 0;
      		 net = 0;
      		 
      	  } 
    	 
     }
     
     public List EMMA(List<Server> lsv, List<VM> lisvm) {
    	 
    	 List<VM> VMlistMigration = null;
    	 double hostCPUtil = 0;
    	 List<VM> vmList;
    	 List<VM> vmListSort;
    	 VM bestVM;
    	 double THRESH_UP = 3000;
    	 double THRESH_LOW = 950;
    	 double bestFitUtil = 450;
    	 double def = 0;
    	 double t = 0;
    	 
    	 for(Server sv : lsv) {
    		 vmList = getVMlist(lisvm);
    		 vmListSort = sortingVMList(vmList);
    		 hostCPUtil = getUtilCPUHost(sv, vmListSort);
    		
    		 bestVM = null;
    		 
    		if(hostCPUtil > THRESH_UP) {
    			 
    			 for(VM vm : vmListSort) {
    				 def = hostCPUtil - THRESH_UP;
    				 if(vm.getCPU_MIPS() > def) {
    					 t = vm.getCPU_MIPS() - hostCPUtil + THRESH_UP;
    					 if(t <  bestFitUtil) {
    						 bestFitUtil = t;
    						 bestVM = vm;
    					 }
    				 }else {
    					 if(vm.getCPU_MIPS() >= bestFitUtil) {
    						 bestVM = vm;
    						 break;
    					 }
    				 }
    				 
    			 }
    			 
    			 hostCPUtil =  hostCPUtil - bestVM.getCPU_MIPS();
    			 VMlistMigration.add(bestVM);
    			 vmListSort.remove(bestVM);
    		 }
    		 if( hostCPUtil < THRESH_LOW) {
    			 VMlistMigration = getVMlist(vmListSort);
    			// vmListSort.remove(vmList);
    		 }
    	 }
		return VMlistMigration;
		
     }

     
	 public double getUtilCPUHost(Server sv, List<VM> vm) {
    	 
    	 double cpu = 0;
    	 double mem = 0;
    	 double net = 0;
    	 double UtilCPUHost = 0;
    	 
    	 cpu = cpu +sv.getCPU_MIPS();
		 mem = mem +sv.getMEMORY();
		 net = net +sv.getNETWORK();
    	 
    	 for(VM v : vm) {
    		
    		 if((v.getCPU_MIPS() < cpu) && (v.getMEMORY() < mem) && (v.getNETWORK() < net)) 
    			 
    		 cpu = cpu-v.getCPU_MIPS();
			 mem = mem-v.getCPU_MIPS();
			 net = net-v.getNETWORK();
    		 
    		 UtilCPUHost = UtilCPUHost+v.getCPU_MIPS();
    		 
    	 }
		return UtilCPUHost;
    	 
     }
     
	 public double getUtilRAMHost(Server sv, List<VM> vm) {
		 
	  	 double cpu = 0;
    	 double mem = 0;
    	 double net = 0;
    	 double UtilRAMHost = 0;
    	 
    	 cpu = cpu +sv.getCPU_MIPS();
		 mem = mem +sv.getMEMORY();
		 net = net +sv.getNETWORK();
    	 
    	 for(VM v : vm) {
    		
    		 if((v.getCPU_MIPS() < cpu) && (v.getMEMORY() < mem) && (v.getNETWORK() < net)) 
    		 cpu = cpu-v.getCPU_MIPS();
			 mem = mem-v.getMEMORY();
			 net = net-v.getNETWORK();
    		 
    		 UtilRAMHost = UtilRAMHost+v.getMEMORY();
    		 
    	 }
		return UtilRAMHost;
    	 
     }
	 
	 public double getUtilNETHost(Server sv, List<VM> vm) {
		 
	  	 double cpu = 0;
    	 double mem = 0;
    	 double net = 0;
    	 double UtilNETHost = 0;
    	 
    	 cpu = cpu +sv.getCPU_MIPS();
		 mem = mem +sv.getMEMORY();
		 net = net +sv.getNETWORK();
    	 
    	 for(VM v : vm) {
    		
    		 if((v.getCPU_MIPS() < cpu) && (v.getMEMORY() < mem) && (v.getNETWORK() < net)) 
    		 cpu = cpu-v.getCPU_MIPS();
			 mem = mem-v.getMEMORY();
			 net = net-v.getNETWORK();
    		 
    		 UtilNETHost = UtilNETHost+v.getNETWORK();
    		 
    	 }
		return UtilNETHost;
    	 
     }
	 
	 
 public List getVMlist(List<VM> v) {
    	 
    	 List<VM> vm =new ArrayList<>();
    	 for(VM vv:v) {
    		 vm.add(vv);
    	 }
		return vm;
     }
 
     public List sortingVMList(List<VM> lsvm) {
    	 
    	 int n = lsvm.size();
    	 
    	 VM tmp1;
    	 VM tmp2;
    	 
    	 for(int i= 0;i < n; i++) {
    		 for(int j  =0; j < n-1; j++) {
    			 if(lsvm.get(j).getCPU_MIPS() < lsvm.get(j+1).getCPU_MIPS()) {
    				 tmp1 = lsvm.get(j);
    				 tmp2 = lsvm.get(j+1);
    				 setVM(lsvm,tmp1, j+1);
    				 setVM(lsvm, tmp2,j);
    			 }
    		 }
    	 }
    	 
		return lsvm;
    	 
     }
     
     public void setVM(List<VM>lsvm,VM vm, int index) {
    	 lsvm.set(index, vm);
     }
     
     public void getTotalUtilisation(List<Server> lsv, List<VM> lisvm) {
    	 
    	    double cpu = 0;
    		double mem = 0;
    		double net = 0;
            double TotalUtilHost;
            double TotalRAMHost;
            double TotalNETHost;
            List<VM> vmList;
    		int i=-1;
    		int j=-1;
    		boolean isAlocated;
    		
    		for(Server sv : lsv) { 
    			i=i+1;
    			
    			vmList = sortingVMList(lisvm);
    			cpu = cpu+sv.getCPU_MIPS();
    			mem = mem+sv.getMEMORY();
    			net = net+sv.getNETWORK();
    			
    			TotalUtilHost = 0;
    			TotalRAMHost = 0;
    			TotalNETHost = 0;
    		   
    			
    		 for(VM vm:  vmList) {
    				isAlocated = false;
    				
    				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
    					
    				isAlocated = true;
    				 j=j+1;
    			}
    				
    			if((isAlocated == true) &&(j<lisvm.size())) {
    					
    					
    				TotalUtilHost = TotalUtilHost + vm.getCPU_MIPS();
    				TotalRAMHost = TotalRAMHost + vm.getMEMORY();
    				TotalNETHost = TotalNETHost + vm.getNETWORK();
    				cpu = cpu-vm.CPU_MIPS;
    				mem = mem-vm.MEMORY;
    				net = net-vm.NETWORK;
    		}
    			 			
    		}
    		 
    		 System.out.println("Le totale d'utilisation de CPU de server:"+i +"\t"+TotalUtilHost +"\t"+
    		 "Le Totale d'utilisation de RAM de serveur:"+i+"\t"+TotalRAMHost+"\t"+
    			"Le Totale d'utilisation de NET de serveur:"+i+" "+TotalNETHost);
    		 
    		 System.out.println("------------------------------------------------------------------------");
    		 TotalUtilHost = 0;
    		 TotalRAMHost = 0;
    		 TotalNETHost = 0;
    		 
    		 cpu =0;
    		 mem = 0;
    		 net = 0;
    		
    	  }
    		
    		
    		
    	
     }
     
     public void migrationList(List<Server> lsv, List<VM> lisvm) {
    	 
    	double cpu = 0;
  		double mem = 0;
  		double net = 0;
        double TotalUtilHost;
        double TotalRAMHost;
        double TotalNETHost;
        List<VM> vmList;
  		int i=-1;
  		int j=-1;
  		boolean isAlocated;
  		////////////////////////////////////////////////////////////////////
  		List<VM> migrationVMList = new ArrayList<>();
  		double BestFitUtil;
  		double THRESH_UP = 3000;
  		double THRESH_LOW = 800;
  		
  		int k= 0;
  		VM BestVM = new VM();
  		
  		for(Server sv : lsv) { 
  			i=i+1;
  			
  			vmList = sortingVMList(lisvm);
  			cpu = cpu+sv.getCPU_MIPS();
  			mem = mem+sv.getMEMORY();
  			net = net+sv.getNETWORK();
  			////////////////////////////////////////////////
  			TotalUtilHost = 0;
  			TotalRAMHost = 0;
  			TotalNETHost = 0;
  		   /////////////////////////////////////////////////////////
  			BestFitUtil = 450;
  		
  			
  		 for(VM vm:  vmList) {
  				isAlocated = false;
  				
  				 if(( vm.CPU_MIPS < cpu && (vm.MEMORY < mem) && (vm.NETWORK < net))) { 
  					
  				isAlocated = true;
  				 j=j+1;
  			}
  				
  			if((isAlocated == true) &&(j<lisvm.size())) {
  					
  					
  				TotalUtilHost = TotalUtilHost + vm.getCPU_MIPS();
  				TotalRAMHost = TotalRAMHost + vm.getMEMORY();
  				TotalNETHost = TotalNETHost + vm.getNETWORK();
  				cpu = cpu-vm.CPU_MIPS;
  				mem = mem-vm.MEMORY;
  				net = net-vm.NETWORK;
  		}
  			 			
  		}
  		
  		 while(TotalUtilHost > THRESH_UP) {
  			  k = k+1;
  			  BestVM = null;
  			  for(VM vm:  vmList) {
  				 if(vm.getCPU_MIPS()>= BestFitUtil) {
  					 BestVM = vm;
  					 break;
  				 }
  			 }
  			 
  			TotalUtilHost = TotalUtilHost- BestVM.getCPU_MIPS();
  			
  			System.out.println("Le reste de Totale d'utilisation de server qui fait migration:"+i+" "+TotalUtilHost);
  			
  			System.out.println("---------------------Best VM ------------------------------");
  			
  			BestVM.afficheVM();
  			
  			migrationVMList.add(BestVM);
  			
  			/*for(VM v : migrationVMList) {
  				k = k+1;
  				System.out.println("VM_Migration_CPU"+v.getCPU_MIPS()+" "+"VM_Migration_RAM"+v.getMEMORY()+
  						" "+"VM_Migration_NET"+v.getNETWORK());
  			}*/
  			 System.out.println("Le nombre de VM migr�"+" "+k);
  		 }
  		 
  		 if(TotalUtilHost < THRESH_LOW) {
  			 migrationVMList = getVMlist(vmList);
  			 //vmList.removeAll(vmList);
  			 System.out.println("Le serveur:"+i+"en �tat OFF");
  		 }
  		//System.out.println("Le reste de Totale d'utilisation de server qui fait migration:"+i+" "+TotalUtilHost);
  		 //System.out.println("Le nombre de VM migr�"+" "+k);
  		 
  		 TotalUtilHost = 0;
  		 TotalRAMHost = 0;
  		 TotalNETHost = 0;
  		 
  		 cpu =0;
  		 mem = 0;
  		 net = 0;
  		
  	  }
  		
     
     }
}

