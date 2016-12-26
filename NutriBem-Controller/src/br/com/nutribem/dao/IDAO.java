package br.com.nutribem.dao;

import br.com.nutribem.dominio.EntidadeDominio;
import java.util.List;


public interface IDAO {

	/**
	 * 
	 * @param entidade Recebe uma entidade Dominio por parametro e cadastra no banco de Dados
	 * @return Um numero Long com o Id do Objeto Cadastrado no Banco de Dados
	 */
	public Long save(EntidadeDominio entidade);
	
	/**
	 * 
	 * @param entidade Recebe uma entidade Dominio por parametro e atualiza no banco de Dados
	 */
	public void update(EntidadeDominio entidade);
	
	/**
	 * 
	 * @param entidade Recebe uma entidade Dominio por parametro e remove do Banco de Dados
	 */
	public void delete(EntidadeDominio entidade);

	/**
	 * 
	 * @param entidade Recebe uma entidade Dominio por parametro e localiza de acordo com o Id informado na Entidade
	 * @return Uma Entidade Dominio se localizado ou null se nao encontrado
	 */
	public EntidadeDominio find(EntidadeDominio entidade);
	
	/**
	 * 
	 * @param entidade Recebe uma entidade Dominio por parametro e localiza todas as entidades dominios encontrados
	 * @return Uma Lista de EntidadeDominio.
	 */
	public List<EntidadeDominio> findAll(EntidadeDominio entidade);
}
