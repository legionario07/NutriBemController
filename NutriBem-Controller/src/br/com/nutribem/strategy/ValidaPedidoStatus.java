package br.com.nutribem.strategy;

import br.com.nutribem.dominio.PedidoStatus;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validação de uma PedidoStatus
 * 
 * @author Paulinho
 *
 */
public class ValidaPedidoStatus implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto PedidoStatus e faz a Validação pelo Nome
	 * @return Retorna um objeto PedidoStatus do BD válido ou Null se não for
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