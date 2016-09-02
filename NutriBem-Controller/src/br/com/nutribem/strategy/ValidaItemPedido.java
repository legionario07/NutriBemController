package br.com.nutribem.strategy;

import br.com.nutribem.dominio.ItemPedido;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validação de uma ItemPedido
 * 
 * @author Paulinho
 *
 */
public class ValidaItemPedido implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto ItemPedido e faz a Validação pelo Nome
	 * @return Retorna um objeto ItemPedido do BD válido ou Null se não for
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
				retorno.append("É necessário haver produtos.");
				return retorno.toString();
			}
			
			if (itemPedido.getProdutos().isEmpty()) {
				retorno.append("É necessário haver produtos.");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}