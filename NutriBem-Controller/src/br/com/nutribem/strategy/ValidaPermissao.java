package br.com.nutribem.strategy;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Permissao;

/**
 * Classe Strategy repons�vel pela Valida��o de um Permissao
 * 
 * @author Paulinho
 *
 */
public class ValidaPermissao implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Permissao e faz a Valida��o pelo Nome
	 * @return Retorna um objeto Permissao do BD v�lido ou Null se n�o for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Permissao permissao = null;

		// Verifica se a classe passada no Parametro eh um objeto Permissao
		if (entDominio instanceof Permissao) {
			retorno = new StringBuffer();
			permissao = (Permissao) entDominio;

			if (permissao.getNivel().equals("")) {
				retorno.append("O Nivel da Permissao deve ser preenchido");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;
	}
}
