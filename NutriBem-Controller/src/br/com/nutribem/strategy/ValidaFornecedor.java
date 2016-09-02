package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Fornecedor;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validação de um Fornecedor
 * 
 * @author Paulinho
 *
 */
public class ValidaFornecedor implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe um objeto Fornecedor e faz a validação pelo ID
	 * @return Retorna um objeto Fornecedor do BD válido ou Null se não for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Fornecedor fornecedor = null;

		// Verifica se a classe passada no Parametro eh um objeto Fornecedor
		if (entDominio instanceof Fornecedor) {
			retorno = new StringBuffer();
			fornecedor = (Fornecedor) entDominio;
			
			/**
			 * O nome deve ser preenchido
			 */
			if (fornecedor.getNome()=="") {
				retorno.append("O nome deve ser prenchido");
				return retorno.toString();
			}
			
			/**
			 * O cnpj deve ser preenchido
			 */
			if (fornecedor.getCnpj()=="") {
				retorno.append("O cnpj deve ser prenchido");
				return retorno.toString();
			}
			

		} else {
			return null;
		}

		return null;

	}

}
