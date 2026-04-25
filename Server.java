package com.EVMP.EMMA;

public class Server {
	
	double CPU_MIPS;
	double MEMORY;
	double NETWORK;

	public Server() {
		this.CPU_MIPS = (int)(Math.random()*1000)+3000;
		this.MEMORY   =  (int)(Math.random()*8)+24;
		this.NETWORK = (int)(Math.random()*50)+150;
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

	public void afficheServer() {
		System.out.println("Le CPU_MIPS_Server"+this.CPU_MIPS+"\t"+
	                        "La mémoire Server"+this.MEMORY+"\t"+
				             "Le Network"+this.NETWORK);
	}
	
}
