package br.com.nutribem.strategy;

import br.com.nutribem.dominio.PedidoStatus;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy repons�vel pela Valida��o de uma PedidoStatus
 * 
 * @author Paulinho
 *
 */
public class ValidaPedidoStatus implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto PedidoStatus e faz a Valida��o pelo Nome
	 * @return Retorna um objeto PedidoStatus do BD v�lido ou Null se n�o for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		PedidoStatus pedidoStatus = null;

		// Verifica se a classe passada no Parametro eh um objeto PedidoStatus
		if (entDominio instanceof PedidoStatus) {
			retorno = new StringBuffer();
			pedidoStatus = (PedidoStatus) entDominio;
			
			if (pedidoStatus.getPedidoStatus().equals("")) {
				retorno.append("O pedido Status deve ser prenchido");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}