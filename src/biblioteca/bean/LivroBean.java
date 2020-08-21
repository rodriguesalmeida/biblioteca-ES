package biblioteca.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biblioteca.model.Livro;

@LocalBean
@Stateless
public class LivroBean {

	@PersistenceContext(unitName = "Biblioteca")
	private EntityManager entity;
	
	public Livro inserir(Livro livro)throws Exception {
		entity.persist(livro);
		entity.flush();
		return livro;
	}
	
	public Livro alterar(Livro livro)throws Exception {
		Livro velho = entity.find(Livro.class, livro.getId());
		livro = entity.merge(livro);
		entity.flush();
		return livro;
	}
	
	public void remover(Livro livro) throws Exception {
		Livro velho = entity.find(Livro.class, livro.getId());
		entity.remove(livro);
		entity.flush();
	}
	
	public Livro buscarPorId(Long id) throws Exception {
		Livro velho = entity.find(Livro.class, id);
		return velho;
	}
}
