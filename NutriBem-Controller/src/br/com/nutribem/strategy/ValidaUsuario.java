package br.com.nutribem.strategy;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Usuario;

/**
 * Classe Strategy repons�vel pela Valida��o de um Usuario
 * 
 * @author Paulinho
 *
 */
public class ValidaUsuario implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Usuario e faz a Valida��o pelo Nome
	 * @return Retorna um objeto Usuario do BD v�lido ou Null se n�o for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Usuario usuario = null;

		// Verifica se a classe passada no Parametro eh um objeto Usuario
		if (entDominio instanceof Usuario) {
			retorno = new StringBuffer();
			usuario = (Usuario) entDominio;

			if (usuario.getLogin().equals("")) {
				retorno.append("O login deve ser preenchido");
				return retorno.toString();
			}
			
			if (usuario.getSenha().equals("")) {
				retorno.append("A senha deve ser preenchida");
				return retorno.toString();
			}
			
			if (usuario.getPermissao()==null) {
				retorno.append("A permiss�o deve ser preenchida");
				return retorno.toString();
			}
			
			if (usuario.getPermissao().getNivel().equals("")) {
				retorno.append("A permiss�o deve ser preenchida");
				return retorno.toString();
			}

		} else {
			return null;
		}

		return null;
	}
}
