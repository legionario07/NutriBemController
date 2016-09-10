package br.com.nutribem.strategy;

import br.com.nutribem.dominio.UnidadeDeMedida;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsavel pela Validacao de uma UnidadeDeMedida
 * 
 * @author Paulinho
 *
 */
public class ValidaUnidadeDeMedida implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto UnidadeDeMedida e faz a Validacao pelo Nome
	 * @return Retorna um objeto UnidadeDeMedida do BD valido ou Null se nao for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		UnidadeDeMedida unidadeDeMedida = null;

		// Verifica se a classe passada no Parametro eh um objeto UnidadeDeMedida
		if (entDominio instanceof UnidadeDeMedida) {
			retorno = new StringBuffer();
			unidadeDeMedida = (UnidadeDeMedida) entDominio;
			
			if (unidadeDeMedida.getUnidadeDeMedida().equals("")) {
				retorno.append("A unidade De Medida deve ser preenchida");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}