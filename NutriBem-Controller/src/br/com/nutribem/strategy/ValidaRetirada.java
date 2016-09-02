package br.com.nutribem.strategy;

import java.math.BigDecimal;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Retirada;

/**
 * Classe Strategy reponsável pela Validação de um Retirada
 * 
 * @author Paulinho
 *
 */
public class ValidaRetirada implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Retirada 
	 * @return Retorna uma String se com a mensagem do erro
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Retirada retirada = null;

		// Verifica se a classe passada no Parametro eh um objeto Retirada
		if (entDominio instanceof Retirada) {
			retorno = new StringBuffer();
			retirada = (Retirada) entDominio;

			if (retirada.getColaborador()==null) {
				retorno.append("A retirada deve ter um Colaborador");
				return retorno.toString();
			}
			if (retirada.getDataRetirada()==null) {
				retorno.append("A Data deve ser Preenchida");
				return retorno.toString();
			}
			if (retirada.getDataRetirada().equals("")) {
				retorno.append("A Data deve ser Preenchida");
				return retorno.toString();
			}
			if (retirada.getDescricao().equals("")) {
				retorno.append("É Necessário preencher a descrição da Retirada");
				return retorno.toString();
			}
			if ((retirada.getValor().compareTo(new BigDecimal(0)))!=1) {
				retorno.append("O valor deve ser maior que 0");
				return retorno.toString();
			}
			if ((retirada.getValor().compareTo(new BigDecimal(0)))!=1) {
				retorno.append("O valor deve ser maior que 0");
				return retorno.toString();
			}
			

		} else {
			return null;
		}
		
		return null;

	}
}
