package br.com.nutribem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.nutribem.dominio.Cidade;
import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Estado;
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
			entidade.setId(0l);
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
			System.out.println("Erro ao Persistir objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(EntidadeDominio entidade) {

		session = HibernateUtil.getSession();
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from ");
		sql.append(entidade.getClass().getSimpleName());
		sql.append(" where id = ?");
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(sql.toString());
			query.setParameter(0, entidade.getId());
			
			query.executeUpdate();
			
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
			System.out.println("Erro ao Pesquisar objeto no Banco de Dados - \n" + e.getMessage());
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

	/**
	 * 
	 * @param estado
	 *            Recebe um entidade Estado e localiza pelo seu UF
	 * @return retorna null se nao encontrar ou um entidade Estado preenchida
	 */
	public Estado findEstadoByUf(Estado estado) {

		Estado estadoRetorno = null;

		session = HibernateUtil.getSession();
		try {

			Query query = session.createQuery("from Estado where uf = ?");
			query.setParameter(0, estado.getUf());

			estadoRetorno = new Estado();
			estadoRetorno = (Estado) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			System.out.println("Erro ao Pesquisar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return estadoRetorno;
	}

	/**
	 * 
	 * @param Cidade
	 *            Recebe uma cidade como parametro e localiza pelo seu nome e Uf
	 * @return Retorna null se nao encontrar ou uma cidade preenchida
	 */
	public Cidade findCidadeByNomeAndUf(Cidade cidade) {

		Cidade cidadeRetorno = null;

		session = HibernateUtil.getSession();
		try {

			Query query = session.createQuery("from Cidade where nome = ? and estado_id = ?");
			query.setParameter(0, cidade.getNome());
			query.setParameter(1, cidade.getEstado().getId());

			cidadeRetorno = new Cidade();
			cidadeRetorno = (Cidade) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			System.out.println("Erro ao Pesquisar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return cidadeRetorno;
	}

	/**
	 * 
	 * @param entidade
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Long findLastId(EntidadeDominio entidade) {

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();

		StringBuilder sql = new StringBuilder();
		sql.append("from ");
		sql.append(entidade.getClass().getSimpleName());
		sql.append(" order by id desc");

		session = HibernateUtil.getSession();
		try {

			Query query = session.createQuery(sql.toString());

			lista = query.getResultList();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			System.out.println("Erro ao Pesquisar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return lista.get(0).getId();
	}

	/**
	 * 
	 * @param entidade
	 *            Uma entidade dominio
	 * @return return null se nao encontrar ou um colaborador se a busca
	 *         resultar
	 */
	public EntidadeDominio login(EntidadeDominio entidade) {

		Colaborador colaboradorRetorno = null;

		if (!(entidade instanceof Colaborador))
			return null;

		colaboradorRetorno = new Colaborador();
		colaboradorRetorno = (Colaborador) entidade;

		StringBuilder sql = new StringBuilder();
		sql.append("from Colaborador c ");
		sql.append("where c.usuario.login = ? and ");
		sql.append("c.usuario.senha = md5(?)");


		session = HibernateUtil.getSession();
		try {

			Query query = session.createQuery(sql.toString());
			query.setParameter(0, colaboradorRetorno.getUsuario().getLogin());
			query.setParameter(1, colaboradorRetorno.getUsuario().getSenha());

			colaboradorRetorno = new Colaborador();
			//colaboradorRetorno = (Colaborador) query.getResultList().get(0);
			colaboradorRetorno = (Colaborador) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			System.out.println("Erro ao Deletar objeto no Banco de Dados - \n" + e.getMessage());
		} finally {
			session.close();
		}

		return colaboradorRetorno;
	}

}
