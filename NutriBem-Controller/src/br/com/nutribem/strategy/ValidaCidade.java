package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Cidade;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy repons�vel pela Valida��o de um Cidade
 * 
 * @author Paulinho
 *
 */
public class ValidaCidade implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Cidade e faz a Valida��o pelo Nome
	 * @return Retorna um objeto Cidade do BD v�lido ou Null se n�o for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Cidade cidade = null;

		// Verifica se a classe passada no Parametro eh um objeto Cidade
		if (entDominio instanceof Cidade) {
			retorno = new StringBuffer();
			cidade = (Cidade) entDominio;

			if (cidade.getNome().equals("")) {
				retorno.append("O nome da Cidade deve ser preenchido");
				return retorno.toString();
			}
			if(cidade.getEstado()==null){
				retorno.append("O estado deve ser preenchido");
				return retorno.toString();
			}
			if (cidade.getEstado().getNome().equals("")) {
				retorno.append("O estado deve ser preenchido");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;
	}
}
