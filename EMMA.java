package com.EVMP.EMMA;

import java.util.ArrayList;
import java.util.List;

public class EMMA {
	
	List<VM> listVM;
	List<Server> listSV;
	public EMMA() {
		listVM = new ArrayList<>();
		listSV = new ArrayList<>();
	}
	
	public void generateListVM(int n) {
		
		
		for(int i=0;i<n;i++) {
			listVM.add(new VM());
		}
		
	}
	
	public void generListVM(int n, List<VM>v) {
		
		
		for(int i=0;i<n;i++) {
			v.add(new VM());
		}
		
	}
	
	public void affcheListVM() {
		for(int i=0;i<listVM.size();i++) {
			System.out.println("Le CPU_VM:"+i+"\t"+listVM.get(i).getCPU_MIPS()+"\t"
					+"Le Mémoire_VM:"+i+"\t"+listVM.get(i).getMEMORY()+"\t"
					+"Le Network_VM:"+i+"\t"+listVM.get(i).getNETWORK());
		}
	}
	
	public void affcheListVM(List<VM> v) {
		for(int i=0;i<v.size();i++) {
			System.out.println("Le CPU_VM:"+i+"\t"+v.get(i).getCPU_MIPS()+"\t"
					+"Le Mémoire_VM:"+i+"\t"+v.get(i).getMEMORY()+"\t"
					+"Le Network_VM:"+i+"\t"+v.get(i).getNETWORK());
		}
	}
	
   public void generateListSV(int n) {
		
		for(int i=0;i<n;i++) {
			listSV.add(new Server());
		}
		
	}
	
	public void affcheListsv() {
		for(int i=0;i<listSV.size();i++) {
			System.out.println("Le CPU_SV:"+i+"\t"+listSV.get(i).getCPU_MIPS()+"\t"
					+"Le Mémoire_SV:"+i+"\t"+listSV.get(i).getMEMORY()+"\t"
					+"Le Network_SV:"+i+"\t"+listSV.get(i).getNETWORK());
		}
	}
	
	public void afficheServer(Server s) {
		System.out.println("Le CPU_SV:"+s.getCPU_MIPS()+
				"\t"+"La Mémoire:"+s.getMEMORY()+"\t"
				+"Le network:"+s.getNETWORK());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	void sortListVM() {
		int n = listVM.size();
		double tmp1 = 0;
		double tmp2 = 0;
		
		for(int i=0;i<n;i++) {
			
			for(int j=1;j<(n-i);j++) {
				
				if(listVM.get(j-1).CPU_MIPS >listVM.get(j).CPU_MIPS) {
					
				  
				   tmp1 = listVM.get(j-1).getCPU_MIPS();
				   tmp2 = listVM.get(j).getCPU_MIPS();
				   listVM.get(j-1).setCPU_MIPS(tmp2);
				   listVM.get(j).setCPU_MIPS(tmp1);
				 
				}
			}
		}
		
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
    			mem = mem- v.getMEMORY();
    		 
    		 UtilRAMHost = UtilRAMHost+v.getMEMORY();
    		 
    	 }
		return UtilRAMHost;
    	 
     }
     
     
   public List getVMlist(List<VM> v) {
    	 
    	 List<VM> vm = new ArrayList<>();
    	 
    	 for(VM vv:v) {
    		 vm.add(vv);
    	 
    	 }
		return vm;
     }
	
	public static void main(String args[]) {
		EMMA emma = new EMMA();
		emma.generateListVM(10);
		emma.affcheListVM();
		
		System.out.println("-----------------------------------------------------------------------");
		emma.generateListSV(4);
		emma.affcheListsv();
		System.out.println("-----------------------------------------------------------------------");
	    
	    emma.affcheListVM();
		
	    System.out.println("-----------------------------------------------------------------------");
	    
	    Server sv = new Server();
	    emma.afficheServer(sv);
	    
	    List<VM> vm = new ArrayList<>();
	     emma.generListVM(4, vm);
	    emma.affcheListVM(vm);
	    System.out.println("----------------------------Get VM List-------------------------------------------------");
	    List<VM> vv;
	    vv = emma.getVMlist(vm);
	    emma.affcheListVM(vv);
	    
	    System.out.println("------------------------------------------------------------------------------");
	    double utilH = emma.getUtilCPUHost(sv, vm);
	    System.out.println(utilH);
	    
	    System.out.println("-------------------------------------------------------------------------");
	    
		double utilRAM = emma.getUtilRAMHost(sv, vm);
		System.out.println(utilRAM);
		System.out.println("-------------------------------------------------------------------------");
		
		VM bestvm = new VM();
		bestvm.afficheVM();
		System.out.println("-------------------------------------------------------------------------");
		VM vvv = new VM();
		vvv= null;
		vvv = bestvm;
		vvv.afficheVM();
			
	}

}
