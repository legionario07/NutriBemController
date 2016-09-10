package br.com.nutribem.strategy;

import java.math.BigDecimal;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Pagamento;
import br.com.nutribem.dominio.Pedido;
import br.com.nutribem.utils.DataUtil;

/**
 * Classe Strategy reponsavel pela Validacao de uma Pagamento
 * 
 * @author Paulinho
 *
 */
public class ValidaPagamento implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Pagamento e faz a Validacao pelo Nome
	 * @return Retorna um objeto Pagamento do BD valido ou Null se nao for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Pagamento pagamento = null;

		// Verifica se a classe passada no Parametro eh um objeto Pagamento
		if (entDominio instanceof Pagamento) {
			retorno = new StringBuffer();
			pagamento = (Pagamento) entDominio;
			
			if (pagamento.getFormaDePagamento()==null) {
				retorno.append("A forma de pagamento deve ser preenchida");
				return retorno.toString();
			}
			
			if (pagamento.getFormaDePagamento().getForma().equals("")) {
				retorno.append("A forma de pagamento deve ser preenchida");
				return retorno.toString();
			}
			
			if (DataUtil.compararDatas(pagamento.getDataPagamento(), DataUtil.pegarDataAtualDoSistema())==-1) {
				retorno.append("A data de pagamento não pode ser maior que o dia de hoje");
				return retorno.toString();
			}
			
			BigDecimal valorPedidos = new BigDecimal(0);
			for(Pedido pedido : pagamento.getPedidos()){
				valorPedidos.add(pedido.getValor());
			}
			
			if (pagamento.getValorPago().compareTo(valorPedidos)<-1) {
				retorno.append("O valor pago n�o pode ser menor que o total a ser pago");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}