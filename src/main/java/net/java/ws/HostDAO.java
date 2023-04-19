package net.java.ws;

import java.util.*;

public class HostDAO {
	private static HostDAO instance;
	private List<Host> data = new ArrayList<>();
	
	public HostDAO() {
	}
	
	public static HostDAO getInstance() {
		if(instance == null)
			instance = new HostDAO();
		return instance;
	}
	
	public List<Host> listAll(){
		return new ArrayList<Host>(data);
	}
	
	public void add(Host host) {
		data.add(host);
	}
	
	public boolean checkDataIsEmpty() {
		if (data.isEmpty() == true) {
			return true;
		}else {
			return false;
		}	
	}
}
