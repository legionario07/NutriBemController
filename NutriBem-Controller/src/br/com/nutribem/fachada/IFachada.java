package br.com.nutribem.fachada;

import br.com.nutribem.dominio.EntidadeDominio;

public interface IFachada {
	
	Resultado save(EntidadeDominio entidade);
	Resultado update(EntidadeDominio entidade);
	Resultado delete(EntidadeDominio entidade);
	Resultado find(EntidadeDominio entidade);
	Resultado findAll(EntidadeDominio entidade);

}
