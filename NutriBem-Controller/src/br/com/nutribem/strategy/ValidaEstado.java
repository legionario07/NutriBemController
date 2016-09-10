package br.com.nutribem.strategy;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Estado;

/**
 * Classe Strategy reponsável pela Validação de um Estado
 * 
 * @author Paulinho
 *
 */
public class ValidaEstado implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Estado e faz a Validacaoo pelo Nome
	 * @return Retorna um objeto Estado do BD valido ou Null se nao for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Estado estado = null;

		// Verifica se a classe passada no Parametro eh um objeto Estado
		if (entDominio instanceof Estado) {
			retorno = new StringBuffer();
			estado = (Estado) entDominio;

			if (estado.getNome().equals("")) {
				retorno.append("O nome da Estado deve ser preenchido");
				return retorno.toString();
			}
			
			if (estado.getUf().equals("")) {
				retorno.append("O estado deve ter uma UF");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;
	}
}
