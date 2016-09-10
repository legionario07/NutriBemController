package br.com.nutribem.strategy;

import br.com.nutribem.dominio.PedidoStatus;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsavel pela Validacao de uma PedidoStatus
 * 
 * @author Paulinho
 *
 */
public class ValidaPedidoStatus implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto PedidoStatus e faz a Validacao pelo Nome
	 * @return Retorna um objeto PedidoStatus do BD valido ou Null se nao for
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