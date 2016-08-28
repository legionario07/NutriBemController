package br.com.nutribem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Permissao;
import br.com.nutribem.dominio.EntidadeDominio;

public class PermissaoTest implements ITest {

	public Permissao permissao = null;
	public RepositoryDao repositoryDao = new RepositoryDao();
	
	@Override
	@Test
	public void create() {
		
		permissao = new Permissao("Usuario");
		
		System.out.println(repositoryDao.save(permissao));
	}

	@Override
	@Ignore
	public void delete() {

		permissao = new Permissao();
		permissao.setId(1L);
		repositoryDao.delete(permissao);
	}

	@Override
	@Ignore
	public void find() {
		permissao = new Permissao();
		permissao.setId(1L);
		permissao = (Permissao) repositoryDao.find(permissao);
		
		System.out.println(permissao);
		
	}

	@Override
	@Ignore
	public void update() {
		permissao = new Permissao(1L, "Teste 5");
		repositoryDao.update(permissao);
	}

	@Override
	@Test
	public void findAll() {

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		lista = repositoryDao.findAll(new Permissao());
		
		for(EntidadeDominio e : lista){
			if(e instanceof Permissao){
				System.out.println(e);
			}
		}
		
		
		
	}
	

}
