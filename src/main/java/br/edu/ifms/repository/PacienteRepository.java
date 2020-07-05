package br.edu.ifms.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.entity.PacienteEntity;

import java.util.List;

import javax.persistence.EntityManager;

public class PacienteRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public PacienteRepository() {
		this.entityManagerFactory = Persistence.
				createEntityManagerFactory("persistence_unit_db_estudo");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(PacienteEntity pacienteEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(pacienteEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Alterar(PacienteEntity pacienteEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(pacienteEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<PacienteEntity> TodosPacientes(){
		
		return this.entityManager
				.createQuery("SELECT p FROM PacienteEntity p ORDER BY p.nome")
				.getResultList();
	}
	
	public PacienteEntity GetPaciente(String codigo){
		return this.entityManager.find(PacienteEntity.class,Integer.parseInt(codigo));
	}
	
	public void Excluir(String codigo) {
		PacienteEntity paciente = this.GetPaciente(codigo);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(paciente);
		this.entityManager.getTransaction().commit();
	}
	

}
