package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Loja;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy repons�vel pela Valida��o de uma Loja
 * 
 * @author Paulinho
 *
 */
public class ValidaLoja implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Loja e faz a Valida��o pelo Nome
	 * @return Retorna um objeto Loja do BD v�lido ou Null se n�o for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Loja loja = null;

		// Verifica se a classe passada no Parametro eh um objeto Loja
		if (entDominio instanceof Loja) {
			retorno = new StringBuffer();
			loja = (Loja) entDominio;
			
			if (loja.getCnpj().equals("")) {
				retorno.append("A loja deve ter um cnpj preenchido");
				return retorno.toString();
			}
			
			if (loja.getNome().equals("")) {
				retorno.append("A loja deve ter um nome preenchido");
				return retorno.toString();
			}
			
			if (loja.getNomeFantasia().equals("")) {
				retorno.append("A loja deve ter um nome Fantasia preenchido");
				return retorno.toString();
			}
			
			if (loja.getEndereco()==null) {
				retorno.append("A loja deve ter um endere�o preenchido");
				return retorno.toString();
			}
			
			if (loja.getEndereco().getLogradouro().equals("")) {
				retorno.append("A loja deve ter um endere�o preenchido");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}