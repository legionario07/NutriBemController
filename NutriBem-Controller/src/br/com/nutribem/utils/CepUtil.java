package br.com.nutribem.utils;

import org.lavieri.modelutil.cep.WebServiceCep;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Cidade;
import br.com.nutribem.dominio.Endereco;
import br.com.nutribem.dominio.Estado;


/**
 * Pesquisa o CEP 
 * @author PauLinHo
 *
 */
public abstract class CepUtil {

	/**
	 * 
	 * @param cep Recebe um String com o CEP
	 * @return Um Endereco ou null se não encontrar
	 */
	public static Endereco buscarCep(String cep) {

		Endereco endereco = null;

		WebServiceCep webCep = WebServiceCep.searchCep(cep);

		if (webCep.isCepNotFound()) {
			return endereco;
		} else {
			endereco = new Endereco();
			endereco.setCep(cep);
			endereco.setLogradouro(webCep.getLogradouroFull().toUpperCase());
			endereco.setBairro(webCep.getBairro().toUpperCase());

			Estado estado = new Estado();
			estado.setUf(webCep.getUf().toUpperCase());

			estado = (Estado) new RepositoryDao().findEstadoByUf(estado);

			Cidade cidade = new Cidade();
			cidade.setEstado(estado);
			cidade.setNome(webCep.getCidade().toUpperCase());
			
			cidade = (Cidade) new RepositoryDao().findCidadeByNomeAndUf(cidade);

			endereco.setCidade(cidade);

		}

		return endereco;
	}
}
