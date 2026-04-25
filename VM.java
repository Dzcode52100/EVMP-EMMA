package com.EVMP.EMMA;

public class VM {

	double CPU_MIPS;
	double MEMORY;
	double NETWORK;
	boolean isAllocated;
	
	public VM() {
		
		this.CPU_MIPS = (int)(Math.random()*400)+100;
		this.MEMORY = (int)(Math.random()*3)+1;
		this.NETWORK =(int)(Math.random()*30)+10;
	}

	
	public void setCPU_MIPS(double cPU_MIPS) {
		CPU_MIPS = cPU_MIPS;
	}


	public void setMEMORY(double mEMORY) {
		MEMORY = mEMORY;
	}


	public void setNETWORK(double nETWORK) {
		NETWORK = nETWORK;
	}


	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}


	public double getCPU_MIPS() {
		return CPU_MIPS;
	}

	public double getMEMORY() {
		return MEMORY;
	}

	public double getNETWORK() {
		return NETWORK;
	}
	
	public void afficheVM() {
		
		System.out.println("CPU_MIPS_VM:"+this.CPU_MIPS+"\t"+
				"La mémoire VM:"+this.MEMORY+"\t"+
				"Le Network VM:"+this.NETWORK);
	}
	
	
}
