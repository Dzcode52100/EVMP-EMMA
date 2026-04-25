package com.EVMP.EMMA;

import java.util.ArrayList;
import java.util.List;

public class ListServer {

	int nbrServer;
	List<Server> ServerList;
	
	public ListServer(int n) {
		this.nbrServer = n;
		ServerList = new ArrayList();
		for(int i=0;i<n;i++) {
			ServerList.add(new Server());
		}
	}
	
	public int getSizeServer() {
		return ServerList.size();
	}
	
	public Server getIndexServer(int i) {
		return ServerList.get(i);
	}
	
	public double getValueCPUinListServer(int i) {
		return ServerList.get(i).getCPU_MIPS();
	}
	
	public double getValueMEMinListServer(int i) {
		return ServerList.get(i).getMEMORY();
	}
	
	public double getValueNETinListServer(int i) {
		return ServerList.get(i).getNETWORK();
	}
	
	public void afficheListServer() {
		for(Server s : ServerList) {
			
			System.out.println("Les CPU_MIPS_SERVER:"+s.getCPU_MIPS()+"\t"+
					"La mémoire_SERVER:"+s.getMEMORY()+"\t"+
					"Le Network_SERVER:"+s.getNETWORK());
		}
	}
	
	
}
