package br.com.nutribem.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.nutribem.dao.RepositoryDao;
import br.com.nutribem.dominio.Categoria;
import br.com.nutribem.dominio.Cidade;
import br.com.nutribem.dominio.Colaborador;
import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.dominio.Estado;
import br.com.nutribem.dominio.FormaDePagamento;
import br.com.nutribem.dominio.Fornecedor;
import br.com.nutribem.dominio.ItemPedido;
import br.com.nutribem.dominio.Loja;
import br.com.nutribem.dominio.Pagamento;
import br.com.nutribem.dominio.PedidoStatus;
import br.com.nutribem.dominio.Permissao;
import br.com.nutribem.dominio.Produto;
import br.com.nutribem.dominio.Retirada;
import br.com.nutribem.dominio.UnidadeDeMedida;
import br.com.nutribem.dominio.Usuario;
import br.com.nutribem.strategy.IValidacaoStrategy;
import br.com.nutribem.strategy.ValidaCPF;
import br.com.nutribem.strategy.ValidaCategoria;
import br.com.nutribem.strategy.ValidaCidade;
import br.com.nutribem.strategy.ValidaColaborador;
import br.com.nutribem.strategy.ValidaEmail;
import br.com.nutribem.strategy.ValidaEstado;
import br.com.nutribem.strategy.ValidaFormaDePagamento;
import br.com.nutribem.strategy.ValidaFornecedor;
import br.com.nutribem.strategy.ValidaItemPedido;
import br.com.nutribem.strategy.ValidaLoja;
import br.com.nutribem.strategy.ValidaPagamento;
import br.com.nutribem.strategy.ValidaPedidoStatus;
import br.com.nutribem.strategy.ValidaPermissao;
import br.com.nutribem.strategy.ValidaProduto;
import br.com.nutribem.strategy.ValidaRetirada;
import br.com.nutribem.strategy.ValidaUnidadeDeMedida;
import br.com.nutribem.strategy.ValidaUsuario;

public class Fachada implements IFachada {

	private RepositoryDao repositoryDao;

	private Map<String, Map<String, List<IValidacaoStrategy>>> mapRegrasDeNegocios;

	private Resultado resultado;

	public Fachada() {

		repositoryDao = new RepositoryDao();

		mapRegrasDeNegocios = new HashMap<String, Map<String, List<IValidacaoStrategy>>>();

		/* Criando instancias de regras de negocio a serem utilizados */
		ValidaCategoria validaCategoria = new ValidaCategoria();
		ValidaCidade validaCidade = new ValidaCidade();
		ValidaColaborador validaColaborador = new ValidaColaborador();
		ValidaCPF validaCPF = new ValidaCPF();
		ValidaEmail validaEmail = new ValidaEmail();
		ValidaEstado validaEstado = new ValidaEstado();
		ValidaFormaDePagamento validaFormaDePagamento = new ValidaFormaDePagamento();
		ValidaFornecedor validaFornecedor = new ValidaFornecedor();
		ValidaItemPedido validaItemPedido = new ValidaItemPedido();
		ValidaLoja validaLoja = new ValidaLoja();
		ValidaPagamento validaPagamento = new ValidaPagamento();
		ValidaPedidoStatus validaPedidoStatus = new ValidaPedidoStatus();
		ValidaPermissao validaPermissao = new ValidaPermissao();
		ValidaProduto validaProduto = new ValidaProduto();
		ValidaRetirada validaRetirada = new ValidaRetirada();
		ValidaUnidadeDeMedida validaUnidadeDeMedida = new ValidaUnidadeDeMedida();
		ValidaUsuario validaUsuario = new ValidaUsuario();

		// Map regras de negocios cadastrar
		// Categoria
		List<IValidacaoStrategy> regrasDeNegocioCadastrarCategoria = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarCategoria.add(validaCategoria);
		// Cidade
		List<IValidacaoStrategy> regrasDeNegocioCadastrarCidade = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarCidade.add(validaCidade);
		// Colaborador
		List<IValidacaoStrategy> regrasDeNegocioCadastrarColaborador = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarColaborador.add(validaColaborador);
		regrasDeNegocioCadastrarColaborador.add(validaEmail);
		regrasDeNegocioCadastrarColaborador.add(validaCPF);
		// Estado
		List<IValidacaoStrategy> regrasDeNegocioCadastrarEstado = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarEstado.add(validaEstado);
		// FormaDePagamento
		List<IValidacaoStrategy> regrasDeNegocioCadastrarFormaDePagamento = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarFormaDePagamento.add(validaFormaDePagamento);
		// Fornecedor
		List<IValidacaoStrategy> regrasDeNegocioCadastrarFornecedor = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarFornecedor.add(validaFornecedor);
		regrasDeNegocioCadastrarFornecedor.add(validaEmail);
		// ItemPedido
		List<IValidacaoStrategy> regrasDeNegocioCadastrarItemPedido = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarItemPedido.add(validaItemPedido);
		// Loja
		List<IValidacaoStrategy> regrasDeNegocioCadastrarLoja = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarLoja.add(validaLoja);
		regrasDeNegocioCadastrarLoja.add(validaEmail);
		// Pagamento
		List<IValidacaoStrategy> regrasDeNegocioCadastrarPagamento = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarPagamento.add(validaPagamento);
		// PedidoStatus
		List<IValidacaoStrategy> regrasDeNegocioCadastrarPedidoStatus = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarPedidoStatus.add(validaPedidoStatus);
		// Permissao
		List<IValidacaoStrategy> regrasDeNegocioCadastrarPermissao = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarPermissao.add(validaPermissao);
		// Produto
		List<IValidacaoStrategy> regrasDeNegocioCadastrarProduto = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarProduto.add(validaProduto);
		// Retirada
		List<IValidacaoStrategy> regrasDeNegocioCadastrarRetirada = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarRetirada.add(validaRetirada);
		// UnidadeDeMedida
		List<IValidacaoStrategy> regrasDeNegocioCadastrarUnidadeDeMedida = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarUnidadeDeMedida.add(validaUnidadeDeMedida);
		// Usuario
		List<IValidacaoStrategy> regrasDeNegocioCadastrarUsuario = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioCadastrarUsuario.add(validaUsuario);

		// Map regras de negocios cadastrar
		// Categoria
		List<IValidacaoStrategy> regrasDeNegocioEditarCategoria = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarCategoria.add(validaCategoria);
		// Cidade
		List<IValidacaoStrategy> regrasDeNegocioEditarCidade = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarCidade.add(validaCidade);
		// Colaborador
		List<IValidacaoStrategy> regrasDeNegocioEditarColaborador = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarColaborador.add(validaColaborador);
		regrasDeNegocioEditarColaborador.add(validaEmail);
		regrasDeNegocioEditarColaborador.add(validaCPF);
		// Estado
		List<IValidacaoStrategy> regrasDeNegocioEditarEstado = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarEstado.add(validaEstado);
		// FormaDePagamento
		List<IValidacaoStrategy> regrasDeNegocioEditarFormaDePagamento = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarFormaDePagamento.add(validaFormaDePagamento);
		// Fornecedor
		List<IValidacaoStrategy> regrasDeNegocioEditarFornecedor = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarFornecedor.add(validaFornecedor);
		regrasDeNegocioEditarFornecedor.add(validaEmail);

		// ItemPedido
		List<IValidacaoStrategy> regrasDeNegocioEditarItemPedido = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarItemPedido.add(validaItemPedido);
		// Loja
		List<IValidacaoStrategy> regrasDeNegocioEditarLoja = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarLoja.add(validaLoja);
		regrasDeNegocioEditarLoja.add(validaEmail);
		// Pagamento
		List<IValidacaoStrategy> regrasDeNegocioEditarPagamento = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarPagamento.add(validaPagamento);
		// PedidoStatus
		List<IValidacaoStrategy> regrasDeNegocioEditarPedidoStatus = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarPedidoStatus.add(validaPedidoStatus);
		// Permissao
		List<IValidacaoStrategy> regrasDeNegocioEditarPermissao = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarPermissao.add(validaPermissao);
		// Produto
		List<IValidacaoStrategy> regrasDeNegocioEditarProduto = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarProduto.add(validaProduto);
		// Retirada
		List<IValidacaoStrategy> regrasDeNegocioEditarRetirada = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarRetirada.add(validaRetirada);
		// UnidadeDeMedida
		List<IValidacaoStrategy> regrasDeNegocioEditarUnidadeDeMedida = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarUnidadeDeMedida.add(validaUnidadeDeMedida);
		// Usuario
		List<IValidacaoStrategy> regrasDeNegocioEditarUsuario = new ArrayList<IValidacaoStrategy>();
		regrasDeNegocioEditarUsuario.add(validaUsuario);

		// Todas regras de Negocio
		// Categoria
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioCategoria = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioCategoria.put("EDITAR", regrasDeNegocioEditarCategoria);
		regrasDeNegocioCategoria.put("CADASTRAR", regrasDeNegocioCadastrarCategoria);
		// Cidade
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioCidade = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioCidade.put("EDITAR", regrasDeNegocioEditarCidade);
		regrasDeNegocioCidade.put("CADASTRAR", regrasDeNegocioCadastrarCidade);
		// Colaborador
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioColaborador = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioColaborador.put("EDITAR", regrasDeNegocioEditarColaborador);
		regrasDeNegocioColaborador.put("CADASTRAR", regrasDeNegocioCadastrarColaborador);
		// Estado
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioEstado = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioEstado.put("EDITAR", regrasDeNegocioEditarEstado);
		regrasDeNegocioEstado.put("CADASTRAR", regrasDeNegocioCadastrarEstado);
		// FormaDePagamento
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioFormaDePagamento = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioFormaDePagamento.put("EDITAR", regrasDeNegocioEditarFormaDePagamento);
		regrasDeNegocioFormaDePagamento.put("CADASTRAR", regrasDeNegocioCadastrarFormaDePagamento);
		// Fornecedor
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioFornecedor = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioFornecedor.put("EDITAR", regrasDeNegocioEditarFornecedor);
		regrasDeNegocioFornecedor.put("CADASTRAR", regrasDeNegocioCadastrarFornecedor);
		// ItemPedido
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioItemPedido = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioItemPedido.put("EDITAR", regrasDeNegocioEditarItemPedido);
		regrasDeNegocioItemPedido.put("CADASTRAR", regrasDeNegocioCadastrarItemPedido);
		// Loja
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioLoja = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioLoja.put("EDITAR", regrasDeNegocioEditarLoja);
		regrasDeNegocioLoja.put("CADASTRAR", regrasDeNegocioCadastrarLoja);
		// Pagamento
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioPagamento = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioPagamento.put("EDITAR", regrasDeNegocioEditarPagamento);
		regrasDeNegocioPagamento.put("CADASTRAR", regrasDeNegocioCadastrarPagamento);
		// PedidoStatus
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioPedidoStatus = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioPedidoStatus.put("EDITAR", regrasDeNegocioEditarPedidoStatus);
		regrasDeNegocioPedidoStatus.put("CADASTRAR", regrasDeNegocioCadastrarPedidoStatus);
		// Permissao
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioPermissao = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioPermissao.put("EDITAR", regrasDeNegocioEditarPermissao);
		regrasDeNegocioPermissao.put("CADASTRAR", regrasDeNegocioCadastrarPermissao);
		// Produto
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioProduto = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioProduto.put("EDITAR", regrasDeNegocioEditarProduto);
		regrasDeNegocioProduto.put("CADASTRAR", regrasDeNegocioCadastrarProduto);
		// Retirada
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioRetirada = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioRetirada.put("EDITAR", regrasDeNegocioEditarRetirada);
		regrasDeNegocioRetirada.put("CADASTRAR", regrasDeNegocioCadastrarRetirada);
		// UnidadeDeMedida
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioUnidadeDeMedida = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioUnidadeDeMedida.put("EDITAR", regrasDeNegocioEditarUnidadeDeMedida);
		regrasDeNegocioUnidadeDeMedida.put("CADASTRAR", regrasDeNegocioCadastrarUnidadeDeMedida);
		// Usuario
		Map<String, List<IValidacaoStrategy>> regrasDeNegocioUsuario = new HashMap<String, List<IValidacaoStrategy>>();
		regrasDeNegocioUsuario.put("EDITAR", regrasDeNegocioEditarUsuario);
		regrasDeNegocioUsuario.put("CADASTRAR", regrasDeNegocioCadastrarUsuario);

		mapRegrasDeNegocios.put(Categoria.class.getName(), regrasDeNegocioCategoria);
		mapRegrasDeNegocios.put(Cidade.class.getName(), regrasDeNegocioCidade);
		mapRegrasDeNegocios.put(Colaborador.class.getName(), regrasDeNegocioColaborador);
		mapRegrasDeNegocios.put(Estado.class.getName(), regrasDeNegocioEstado);
		mapRegrasDeNegocios.put(FormaDePagamento.class.getName(), regrasDeNegocioFormaDePagamento);
		mapRegrasDeNegocios.put(Fornecedor.class.getName(), regrasDeNegocioFornecedor);
		mapRegrasDeNegocios.put(ItemPedido.class.getName(), regrasDeNegocioItemPedido);
		mapRegrasDeNegocios.put(Loja.class.getName(), regrasDeNegocioLoja);
		mapRegrasDeNegocios.put(Pagamento.class.getName(), regrasDeNegocioPagamento);
		mapRegrasDeNegocios.put(PedidoStatus.class.getName(), regrasDeNegocioPedidoStatus);
		mapRegrasDeNegocios.put(Permissao.class.getName(), regrasDeNegocioPermissao);
		mapRegrasDeNegocios.put(Produto.class.getName(), regrasDeNegocioProduto);
		mapRegrasDeNegocios.put(Retirada.class.getName(), regrasDeNegocioRetirada);
		mapRegrasDeNegocios.put(UnidadeDeMedida.class.getName(), regrasDeNegocioUnidadeDeMedida);
		mapRegrasDeNegocios.put(Usuario.class.getName(), regrasDeNegocioUsuario);

	}

	@Override
	public Resultado save(EntidadeDominio entidade) {

		resultado = null;

		String msg = executarRegras(entidade, "CADASTRAR");

		if (msg == null || msg.length() < 1) {
			resultado = new Resultado();

			entidade.setId(repositoryDao.save(entidade));
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
			resultado.setMsg("Operação efetuada com sucesso!");
			if (entidade.getId() == 0) {
				resultado = new Resultado();
				resultado.setMsg("Erro ao Cadastrar.\n");
				return resultado;
			}

		} else {
			resultado = new Resultado();
			resultado.setMsg("Não foi possivel realizar a Operação.\n");
			resultado.setMsg(msg);
		}

		return resultado;

	}

	@Override
	public Resultado delete(EntidadeDominio entidade) {

		resultado = null;

		String msg = executarRegras(entidade, "EXCLUIR");

		if (msg == null || msg.length() < 1) {

			resultado = new Resultado();

			repositoryDao.delete(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
			resultado.setMsg("Operação efetuada com sucesso!");

		} else {
			resultado = new Resultado();
			resultado.setMsg("Não foi possivel realizar a Operação.\n");
			resultado.setMsg(msg);
		}

		return resultado;

	}

	@Override
	public Resultado update(EntidadeDominio entidade) {

		resultado = null;

		String msg = executarRegras(entidade, "EDITAR");

		if (msg == null || msg.length() < 1) {
			resultado = new Resultado();

			repositoryDao.update(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
			resultado.setMsg("Operação efetuada com sucesso!");
		} else {
			resultado = new Resultado();
			resultado.setMsg("Não foi possivel realizar a Operação.\n");
			resultado.setMsg(msg);

		}

		return resultado;

	}

	@Override
	public Resultado find(EntidadeDominio entidade) {

		resultado = null;

		String msg = executarRegras(entidade, "CONSULTAR");

		if (msg == null || msg.length() < 1) {
			resultado = new Resultado();

			entidade = repositoryDao.find(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);

		} else {
			resultado = new Resultado();
			resultado.setMsg("Não foi possivel localizar no banco de dados.\n");
			resultado.setMsg(msg);
			;
		}

		return resultado;
	}

	@Override
	public Resultado findAll(EntidadeDominio entidade) {

		resultado = null;

		String msg = executarRegras(entidade, "LISTAR");

		if (msg == null || msg.length() < 1) {
			resultado = new Resultado();

			resultado.setEntidades(repositoryDao.findAll(entidade));

		} else {
			resultado = new Resultado();
			resultado.setMsg("Não foi possivel localiza no banco de dados.\n");
			resultado.setMsg(msg);
		}

		return resultado;

	}

	private String executarRegras(EntidadeDominio entidade, String operacao) {

		String nomeClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();

		Map<String, List<IValidacaoStrategy>> regrasOperacao = mapRegrasDeNegocios.get(nomeClasse);

		if (regrasOperacao != null) {
			List<IValidacaoStrategy> regras = regrasOperacao.get(operacao);

			if (regras != null) {
				for (IValidacaoStrategy s : regras) {
					String retorno = s.validar(entidade);

					if (retorno != null) {
						msg.append(retorno);
						msg.append("\n");
					}
				}
			}

		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
	}

}
