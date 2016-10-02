package br.com.nutribem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Produto;
import br.com.nutribem.dominio.EntidadeDominio;

public class ProdutoTest implements ITest {

	public Produto produto = null;
	public RepositoryDao repositoryDao = new RepositoryDao();
	
	@Override
	@Ignore
	public void create() {
		
		//produto = new Produto("Teste");
		
		System.out.println(repositoryDao.save(produto));
	}

	@Override
	@Ignore
	public void delete() {

		produto = new Produto();
		produto.setId(1L);
		repositoryDao.delete(produto);
	}

	@Override
	@Ignore
	public void find() {
		produto = new Produto();
		produto.setId(5L);
		produto = (Produto) repositoryDao.find(produto);
		
		System.out.println(produto);
		
	}
	
	@Test
	public void findByCodigoDeBarras() {
		produto = new Produto();
		produto.setCodigoBarras("123413412145");
		produto = (Produto) repositoryDao.findProdutoByCodigoBarras(produto);
		
		System.out.println(produto);
		
	}


	@Override
	@Ignore
	public void update() {
		//produto = new Produto(1L, "Teste 5");
		repositoryDao.update(produto);
	}

	@Override
	@Ignore
	public void findAll() {

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		lista = repositoryDao.findAll(new Produto());
		
		for(EntidadeDominio e : lista){
			if(e instanceof Produto){
				System.out.println(e);
			}
		}
		
	}
	

}
