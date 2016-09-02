package br.com.nutribem.strategy;

import br.com.nutribem.dominio.ItemPedido;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy repons�vel pela Valida��o de uma ItemPedido
 * 
 * @author Paulinho
 *
 */
public class ValidaItemPedido implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto ItemPedido e faz a Valida��o pelo Nome
	 * @return Retorna um objeto ItemPedido do BD v�lido ou Null se n�o for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		ItemPedido itemPedido = null;

		// Verifica se a classe passada no Parametro eh um objeto ItemPedido
		if (entDominio instanceof ItemPedido) {
			retorno = new StringBuffer();
			itemPedido = (ItemPedido) entDominio;
			
			if (itemPedido.getQuantidade()<=0) {
				retorno.append("A quantidade deve ser maior que 0");
				return retorno.toString();
			}
			
			if (itemPedido.getProdutos()==null) {
				retorno.append("� necess�rio haver produtos.");
				return retorno.toString();
			}
			
			if (itemPedido.getProdutos().isEmpty()) {
				retorno.append("� necess�rio haver produtos.");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}