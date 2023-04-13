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
	private String googleUrl = "www.google.com";
	private String amazonUrl = "www.amazon.com";
	private String facebookUrl = "www.facebook.com";
	
	public void Init(){
		try {
		// Fetch Ip address by getByName
		InetAddress ip = InetAddress.getByName(googleUrl);
		// add to host list
		dao.add(new Host(googleUrl,ip.getHostAddress()));
		// Fetch Ip address by getByName
		ip = InetAddress.getByName(amazonUrl);
		// add to host list
		dao.add(new Host(amazonUrl,ip.getHostAddress()));
		// Fetch Ip address by getByName
		ip = InetAddress.getByName(facebookUrl);
		// add to host list
		dao.add(new Host(facebookUrl,ip.getHostAddress()));
		}
		catch(UnknownHostException u) {
			
		}
	}
	// get list of Ip address by json type
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Host> list(){
		Init();
		return dao.listAll();
	}
	
}
