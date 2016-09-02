package br.com.nutribem.fachada;

import java.util.ArrayList;
import java.util.List;

import br.com.nutribem.dominio.EntidadeDominio;

/**
 * Classe que retornar ao Realizar um Crud no Banco de Dados
 * @author PauLinHo
 *
 */
public class Resultado {

	private List<EntidadeDominio> entidades;
	private String msg;
	
	public Resultado(){
		entidades = new ArrayList<EntidadeDominio>();
	}

	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	
	
}
