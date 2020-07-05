package br.edu.ifms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.ifms.entity.PacienteEntity;
import br.edu.ifms.http.Paciente;
import br.edu.ifms.repository.PacienteRepository;

@Path("/service")
public class ServiceController {
	
	private final PacienteRepository repository = new PacienteRepository();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Paciente paciente) {
		
		PacienteEntity entity = new PacienteEntity();
		
		try {
			entity.setNome(paciente.getNome());
			entity.setSexo(paciente.getSexo());
			
			repository.Salvar(entity);
			
			return "Registro cadastrado com sucesso ! ";
		} catch (Exception e) {
			return "Erro ao cadastrar registro: "+e.getMessage();
		}
	}
	
	
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterar")
	public String Alterar(Paciente paciente) {
		
			PacienteEntity entity = new PacienteEntity();
		
		try {
			entity.setCodigo(paciente.getCodigo());
			entity.setNome(paciente.getNome());
			entity.setSexo(paciente.getSexo());
			entity.setPatologias(paciente.getPatologias());
			
			repository.Alterar(entity);
			
			return "Registro alterado com sucesso ! ";
		} catch (Exception e) {
			return "Erro ao cadastrar registro: "+e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todosPacientes")
	public List<Paciente> TodosPacientes(){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		
		List<PacienteEntity> listaEntityPacientes = repository.TodosPacientes();
		
		for (PacienteEntity entity : listaEntityPacientes) {
			pacientes.add(new Paciente(entity.getCodigo(),entity.getNome(),entity.getSexo(),entity.getPatologias()));
		}
		
		return pacientes;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getPaciente/{codigo}")
	public Paciente GetPaciente(@PathParam("codigo") String codigo){
		PacienteEntity entity = repository.GetPaciente(codigo);
		
		if(entity != null) {
			return new Paciente(entity.getCodigo(),entity.getNome(),entity.getSexo(),entity.getPatologias());
		}
		
		return null;
	}
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String Excluir(@PathParam("codigo")String codigo) {
		try {
			repository.Excluir(codigo);
			return "Registro excluido com sucessoo!";
		}catch (Exception e) {
			return "Erro ao excluir registro!" + e.getMessage();
		}
	}
	
	
	
	
	
}
