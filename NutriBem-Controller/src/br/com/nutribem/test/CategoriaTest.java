package br.com.nutribem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Categoria;
import br.com.nutribem.dominio.EntidadeDominio;

public class CategoriaTest implements ITest {

	public Categoria categoria = null;
	public RepositoryDao repositoryDao = new RepositoryDao();
	
	@Override
	@Ignore
	public void create() {
		
		categoria = new Categoria("Teste");
		
		System.out.println(repositoryDao.save(categoria));
	}

	@Override
	@Ignore
	public void delete() {

		categoria = new Categoria();
		categoria.setId(1L);
		repositoryDao.delete(categoria);
	}

	@Override
	@Ignore
	public void find() {
		categoria = new Categoria();
		categoria.setId(5L);
		categoria = (Categoria) repositoryDao.find(categoria);
		
		System.out.println(categoria);
		
	}

	@Override
	@Ignore
	public void update() {
		categoria = new Categoria(1L, "Teste 5");
		repositoryDao.update(categoria);
	}

	@Override
	@Test
	public void findAll() {

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		lista = repositoryDao.findAll(new Categoria());
		
		for(EntidadeDominio e : lista){
			if(e instanceof Categoria){
				System.out.println(e);
			}
		}
		
	}
	

}
