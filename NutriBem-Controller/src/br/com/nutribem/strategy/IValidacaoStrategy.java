package br.com.nutribem.strategy;

import br.com.nutribem.dominio.EntidadeDominio;

/**
 * 
 * @author Paulinho
 *Interface responsável pela validacao de algumas classes de dominio
 */
public interface IValidacaoStrategy {
	
	/**
	 * 
	 * @param entDominio Uma EntidadeDominio para ser validada
	 * @return uma String se a validação ocorreu tudo ok
	 */
	String validar(EntidadeDominio entDominio);
	

}
