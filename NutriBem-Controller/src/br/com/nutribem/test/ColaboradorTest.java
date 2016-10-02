package br.com.nutribem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.Contato;
import br.com.nutribem.dominio.Endereco;
import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Permissao;
import br.com.nutribem.dominio.Usuario;
import br.com.nutribem.dominio.enums.SexoType;
import br.com.nutribem.utils.CepUtil;
import br.com.nutribem.utils.DataUtil;
import br.com.nutribem.utils.EncryptMD5Util;

public class ColaboradorTest implements ITest {

	public Colaborador colaborador = null;
	public RepositoryDao repositoryDao = new RepositoryDao();
	
	@Override
	@Ignore
	public void create() {
		
		String cep = "08773-130";
		
		Endereco endereco = new Endereco();
		endereco = CepUtil.buscarCep(cep);
		endereco.setNumero("30");
		
		Contato contato = new Contato("(11)4798-6737", "(11)4798-6739", "", "teste@teste.com");
		
		Permissao permissao = new Permissao();
		permissao.setId(1l);
		permissao = (Permissao) repositoryDao.find(permissao);
		
		Usuario usuario = new Usuario(permissao);
		usuario.setLogin("teste");
		usuario.setSenha(EncryptMD5Util.getEncryptMD5("senha"));
		usuario.setAtivo(true);
		
		repositoryDao.save(usuario);
		
		colaborador = new Colaborador(SexoType.MASCULINO, endereco, contato,usuario);
		colaborador.setNome("Paulo Sergio");
		colaborador.setDataDeNascimento(DataUtil.getDataFormatada("31/07/1988"));
		colaborador.setCpf("12414212341");
		
		repositoryDao.save(colaborador);
	}

	@Override
	@Ignore
	public void delete() {

		colaborador = new Colaborador();
		colaborador.setId(1L);
		repositoryDao.delete(colaborador);
	}

	@Override
	@Ignore
	public void find() {
		colaborador = new Colaborador();
		colaborador.setId(5L);
		colaborador = (Colaborador) repositoryDao.find(colaborador);
		
		System.out.println(colaborador);
		
	}

	@Override
	@Ignore
	public void update() {
		colaborador = new Colaborador();
		colaborador.setId(12L);
		colaborador = (Colaborador) repositoryDao.find(colaborador);
		repositoryDao.update(colaborador);
	}

	@Override
	@Ignore
	public void findAll() {

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		lista = repositoryDao.findAll(new Colaborador());
		
		
		for(EntidadeDominio e : lista){
			if(e instanceof Colaborador){
				System.out.println(e);
			}
		}
		
	}
	
	@Test
	public void login() {
		colaborador = new Colaborador();
		//colaborador.setId(15L);
		//colaborador = (Colaborador) repositoryDao.find(colaborador);
		colaborador.getUsuario().setLogin("teste");
		colaborador.getUsuario().setAtivo(true);
		colaborador.getUsuario().setSenha("senhaw");
		colaborador = (Colaborador) repositoryDao.login(colaborador);
		
		System.out.println(colaborador);
		
	}
	
	public static void main(String[] args) {
		ColaboradorTest c = new ColaboradorTest();
		c.login();
	}

}
