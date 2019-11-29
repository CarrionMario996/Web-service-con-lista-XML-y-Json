package ws;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import dao.ViajeFacade;

import entity.Viaje;


@Path("/WSClienteLista")
public class WSList {
	private Viaje v;
	private ViajeFacade vf;

	public WSList() {
		v = new Viaje();
		vf = new ViajeFacade();
	}
	@GET
	@Path("/listaCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public String clientesAll(@QueryParam("telefono")String telefono) {
		List<?>lista= new ArrayList<Viaje>();
		lista=vf.findByTelefono(telefono);
		
		Gson gson = new Gson();
		String data= gson.toJson(lista);
		JsonArray jsonArray= new JsonParser().parse(data).getAsJsonArray();
		String resultado=gson.toJson(jsonArray);
		
		return resultado;
		
	}


	@GET
	@Path("/listar")
	@Produces("application/xml")
	public List<Viaje> getCliente() {
		List<Viaje> name = null;
		
		name = vf.mostrar();
		for(Viaje o:name) {
			
		}
		return name;
	}

}
