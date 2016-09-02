package br.com.nutribem.strategy;

import br.com.nutribem.dominio.FormaDePagamento;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy repons�vel pela Valida��o de uma FormaDePagamento
 * 
 * @author Paulinho
 *
 */
public class ValidaFormaDePagamento implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto FormaDePagamento e faz a Valida��o pelo Nome
	 * @return Retorna um objeto FormaDePagamento do BD v�lido ou Null se n�o for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		FormaDePagamento formaDePagamento = null;

		// Verifica se a classe passada no Parametro eh um objeto FormaDePagamento
		if (entDominio instanceof FormaDePagamento) {
			retorno = new StringBuffer();
			formaDePagamento = (FormaDePagamento) entDominio;
			
			if (formaDePagamento.getForma().equals("")) {
				retorno.append("A forma De Pagamento deve ser prenchida");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}