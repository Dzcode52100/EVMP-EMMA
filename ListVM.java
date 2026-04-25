package com.EVMP.EMMA;

import java.util.ArrayList;
import java.util.List;

public class ListVM {

	int NbrVM;
	List<VM> VMlist;
	
	public ListVM(int n) {
		this.NbrVM = n;
		VMlist = new ArrayList<VM>();
		
		for(int i=0;i<n;i++) {
			
			VMlist.add(new VM());
		}
	}
	
	public int getSizeVM() {
		return VMlist.size();
	}
	public VM getIndexVM(int i) {
		return VMlist.get(i);
	}
	
	public double getValueCPUinListVM(int i) {
		return VMlist.get(i).getCPU_MIPS();
	}
	
	public double getValueMEMinListVM(int i) {
		return VMlist.get(i).getMEMORY();
	}
	public double getValueNETinListVM(int i) {
		return VMlist.get(i).getNETWORK();
	}
	
	public void afficheListVM() {
		for(VM v : VMlist) {
			System.out.println("Le CPU_MIPS_VM:"+v.getCPU_MIPS()+"\t"+
		                       "La mémoire_VM:"+v.getMEMORY()+"\t"+
					           "Le Network_VM:"+v.NETWORK);
		}
	}
}
