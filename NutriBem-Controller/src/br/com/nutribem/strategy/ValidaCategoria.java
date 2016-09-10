package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Categoria;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validaçao de uma Categoria
 * 
 * @author Paulinho
 *
 */
public class ValidaCategoria implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Categoria e faz a Validação pelo Nome
	 * @return Retorna um objeto Categoria do BD válido ou Null se não for
	 *         encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Categoria categoria = null;

		// Verifica se a classe passada no Parametro eh um objeto Categoria
		if (entDominio instanceof Categoria) {
			retorno = new StringBuffer();
			categoria = (Categoria) entDominio;
			
			if (categoria.getCategoria().equals("")) {
				retorno.append("A categoria deve ser preenchida");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;

	}

}