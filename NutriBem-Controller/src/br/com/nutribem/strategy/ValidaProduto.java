package br.com.nutribem.strategy;

import java.math.BigDecimal;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Produto;
import br.com.nutribem.utils.DataUtil;

/**
 * Classe Strategy repons�vel pela Valida��o de uma Produto
 * 
 * @author Paulinho
 *
 */
public class ValidaProduto implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Produto e faz a Valida��o pelo Nome
	 * @return Retorna um objeto Produto do BD v�lido ou Null se n�o for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Produto produto = null;

		// Verifica se a classe passada no Parametro eh um objeto Produto
		if (entDominio instanceof Produto) {
			retorno = new StringBuffer();
			produto = (Produto) entDominio;
			
			if (produto.getCategoria().equals("")) {
				retorno.append("A Categoria deve ser preenchida");
				return retorno.toString();
			}
			
			if (produto.getDescricao().equals("")) {
				retorno.append("A Descri��o deve ser preenchida");
				return retorno.toString();
			}
			
			if (produto.getQuantidadeMinima()<0) {
				retorno.append("A Quantidade Minima deve ser maior ou igual a 0");
				return retorno.toString();
			}
			
			if (produto.getQuantidadeEstoque()<0) {
				retorno.append("A Quantidade Em estoque n�o deve ser maior negativa");
				return retorno.toString();
			}
			
			if (produto.getPreco().compareTo(new BigDecimal(0))==-1) {
				retorno.append("O valor n�o pode ser negativo");
				return retorno.toString();
			}
			
			if (DataUtil.compararDatas(produto.getDataDeFabricacao(), DataUtil.pegarDataAtualDoSistema())==-1) {
				retorno.append("A data de Fabrica��o n�o pode ser maior que o dia de Hoje");
				return retorno.toString();
			}
			
			if (DataUtil.compararDatas(DataUtil.pegarDataAtualDoSistema(), produto.getDataDeValidade())==-1) {
				retorno.append("A data de Validade n�o pode ser menor que o dia de Hoje");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}