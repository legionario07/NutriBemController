package br.com.nutribem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.factory.HibernateUtil;

public class RepositoryDao implements IDAO {

	private Session session = null;

	@Override
	public Long save(EntidadeDominio entidade) {

		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			entidade.setId((Long) session.save(entidade));
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao Persistir objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return entidade.getId();
	}

	@Override
	public void update(EntidadeDominio entidade) {

		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(entidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao Atualizar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(EntidadeDominio entidade) {

		session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(entidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao Deletar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public EntidadeDominio find(EntidadeDominio entidade) {

		EntidadeDominio entidadeRetorno = null;

		session = HibernateUtil.getSession();
		try {
			entidadeRetorno = session.find(entidade.getClass(), entidade.getId());
		} catch (Exception e) {
			System.out.println("Erro ao Deletar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return entidadeRetorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadeDominio> findAll(EntidadeDominio entidade) {
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("from ");
		sql.append(entidade.getClass().getSimpleName());
		sql.append(" order by id asc");
		
		session = HibernateUtil.getSession();
		try {
			
			Query query = session.createQuery(sql.toString());
			lista = query.getResultList();
			
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar objetos no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return lista;
	}

}
