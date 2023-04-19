package net.java.ws;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.net.*;
import java.util.List;

@Path("/hosts")
public class HostResources {
	
	private HostDAO dao = HostDAO.getInstance();
	private String Url ;
	private InetAddress ip;
	
	public void Init() {
		try {
		Url = "www.google.com";
		// Fetch Ip address by getByName
		ip = InetAddress.getByName(Url);
		// add to host list
		dao.add(new Host(Url,ip.getHostAddress()));
		
		Url = "www.amazon.com";
		// Fetch Ip address by getByName
		ip = InetAddress.getByName(Url);
		// add to host list
		dao.add(new Host(Url,ip.getHostAddress()));
		
		Url = "www.facebook.com";
		// Fetch Ip address by getByName
		ip = InetAddress.getByName(Url);
		// add to host list
		dao.add(new Host(Url,ip.getHostAddress()));
		}
		catch(UnknownHostException u) {
			
		}
	}
	// get list of Ip address by json type
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Host> list(){
		if (dao.checkDataIsEmpty() == false) {
			return dao.listAll();
		}else {
			Init();
			return dao.listAll();
		}
	}
	
}
