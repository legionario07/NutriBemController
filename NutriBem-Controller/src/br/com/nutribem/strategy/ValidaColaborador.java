package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validação de um Colaborador
 * 
 * @author Paulinho
 *
 */
public class ValidaColaborador implements IValidacaoStrategy {

	/**
	 * 
	 * @param recebe um objeto Colaborador e faz a validação pelo ID
	 * @return Retorna um objeto Colaborador do BD válido ou Null se não for encontrado
	 */
	public String validar(EntidadeDominio entDominio) {

		StringBuffer retorno = null;
		Colaborador colaborador = null;

		// Verifica se a classe passada no Parametro eh um objeto Colaborador
		if (entDominio instanceof Colaborador) {
			retorno = new StringBuffer();
			colaborador = (Colaborador) entDominio;
			
			/**
			 * O nome deve ser preenchido
			 */
			if (colaborador.getNome()=="") {
				retorno.append("O nome deve ser prenchido");
				return retorno.toString();
			}
			
			/**
			 * O sexo deve ser preenchido
			 */
			if (colaborador.getSexo().getDescricao()=="") {
				retorno.append("O sexo deve ser prenchido");
				return retorno.toString();
			}
			
			/**
			 * O login deve ser preenchido
			 */
			if (colaborador.getUsuario()==null){
				retorno.append("O login deve ser deve ser prenchido");
				return retorno.toString();
			}
			
			if (colaborador.getUsuario().getLogin()==null){
				retorno.append("O login deve ser deve ser prenchido");
				return retorno.toString();
			}
			
			if(colaborador.getUsuario().getLogin().equals("")) {
				retorno.append("O login deve ser deve ser prenchido");
				return retorno.toString();
			}
			
			

		} else {
			return null;
		}

		return null;

	}

}
