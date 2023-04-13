package net.java.ws;

public class Host {
	String Name;
	String IpAddress;
	
	public Host() {
		super();
	}

	public Host(String name, String ipAddress) {
		super();
		this.Name = name;
		this.IpAddress = ipAddress;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIpAddress() {
		return IpAddress;
	}

	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	
}
