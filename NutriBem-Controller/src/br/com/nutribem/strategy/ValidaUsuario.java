package br.com.nutribem.strategy;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Usuario;

/**
 * Classe Strategy reponsavel pela Validacao de um Usuario
 * 
 * @author Paulinho
 *
 */
public class ValidaUsuario implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe
	 *            um objeto Usuario e faz a Validacao pelo Nome
	 * @return Retorna um objeto Usuario do BD valido ou Null se nao for encontrado
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
				retorno.append("A permissão deve ser preenchida");
				return retorno.toString();
			}
			
			if (usuario.getPermissao().getNivel().equals("")) {
				retorno.append("A permissão deve ser preenchida");
				return retorno.toString();
			}
			/**
			 * DEve ser Ativo ou N�o			 */
			if (usuario.getAtivo().equals("")) {
				retorno.append("Deve ser ativo ou não");
				return retorno.toString();
			}
			

		} else {
			return null;
		}

		return null;
	}
}
