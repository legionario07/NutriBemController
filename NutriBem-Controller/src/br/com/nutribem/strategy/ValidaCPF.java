package br.com.nutribem.strategy;

import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe Strategy reponsável pela Validação de um CPf
 * 
 * @author Paulinho
 *
 */
public class ValidaCPF implements IValidacaoStrategy {

	@Override
	public String validar(EntidadeDominio entDominio) {
		
		StringBuffer retorno = null;

		// Verifica se a classe passada no Parametro eh um objeto Colaborador
		if (entDominio instanceof Colaborador) {
			retorno = new StringBuffer();
			Colaborador colaborador = (Colaborador) entDominio;
			String cpf = colaborador.getCpf();

			// retirando ponto e traço do cpf
			String novoCpf = cpf.replace(".", "");
			novoCpf = novoCpf.replace("-", "");
			int totalPosicoes = novoCpf.length();
			int aux = 10;
			int somaPrimeiroDigito = 0;
			int somaSegundoDigito = 0;

			// se n�o tiver 11 digito sai retorna FALSE
			if (totalPosicoes != 11) {
				retorno.append("CPF inv�lido");
				return retorno.toString();
			}

			if (novoCpf.equals("11111111111") || novoCpf.equals("22222222222") || novoCpf.equals("33333333333")
					|| novoCpf.equals("44444444444") || novoCpf.equals("55555555555") || novoCpf.equals("66666666666")
					|| novoCpf.equals("77777777777") || novoCpf.equals("88888888888") || novoCpf.equals("99999999999")
					|| novoCpf.equals("00000000000")) {
				retorno.append("CPF inv�lido");
				return retorno.toString();
			}

			// efetua o calculo do primeiro Digito
			for (int i = 0; i < 9; i++) {
				somaPrimeiroDigito += Integer.parseInt(String.valueOf(novoCpf.charAt(i))) * aux;
				aux = aux - 1;
			}

			int primeiroDigito = 11 - (somaPrimeiroDigito % 11);

			// verifica se o resultado deu 10 ou 11, se sim primeiro digito
			// recebe 0
			if (primeiroDigito == 11 || primeiroDigito == 10) {
				primeiroDigito = 0;
			}

			// valida o primerio digito
			if (Integer.parseInt(String.valueOf(novoCpf.charAt(9))) != primeiroDigito) {
				retorno.append("CPF inv�lido");
				return retorno.toString();
			}
			aux = 11; // aux recebe o valor 11 para calcular o segundo digito

			// efetua o calculo do segundo digito
			for (int i = 0; i < 10; i++) {
				somaSegundoDigito += Integer.parseInt(String.valueOf(novoCpf.charAt(i))) * aux;
				aux = aux - 1;
			}

			int segundoDigito = 11 - (somaSegundoDigito % 11);
			// verifica se o resultado deu 10 ou 11, se sim primeiro digito
			// recebe 0
			if (segundoDigito == 11 || segundoDigito == 10) {
				segundoDigito = 0;
			}

			// valida o segundo digito
			if (Integer.parseInt(String.valueOf(novoCpf.charAt(10))) != segundoDigito) {
				retorno.append("CPF inv�lido");
				return retorno.toString();
			}

			return null;

		}
		return null;
	}

}
