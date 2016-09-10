package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.Contato;
import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Fornecedor;
import br.com.nutribem.dominio.Loja;

public class ValidaEmail implements IValidacaoStrategy {

	@Override
	public String validar(EntidadeDominio entDominio) {

		Contato contato = new Contato();
		StringBuffer retorno = null;
		if(entDominio instanceof Fornecedor)
			contato = ((Fornecedor) entDominio).getContato();
		else if(entDominio instanceof Colaborador)
			contato = ((Colaborador) entDominio).getContato();
		else if(entDominio instanceof Loja)
			contato = ((Loja) entDominio).getContato();
		else
			contato = null;
			

		if (!(contato == null)) {
			retorno = new StringBuffer();
			String email = contato.getEmail();

			if (email == null || email.equals("")) {
				return null;
			} else if (email.indexOf('@') == -1 || email.contains(" ") || email.length() < 3 || email.endsWith("@")
					|| email.startsWith("@")) {
				retorno.append("Email inválido");
				return retorno.toString();
			}
			
			return null;
		}

		return null;

	}

}
