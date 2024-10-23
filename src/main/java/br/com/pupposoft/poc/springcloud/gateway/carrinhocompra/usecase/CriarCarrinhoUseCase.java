package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.CarrinhoCompra;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.Produto;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.CarrinhoGateway;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarCarrinhoUseCase {
	
	private ProdutoGateway produtoGateway;
	private CarrinhoGateway carrinhoGateway;

	public Long criar(CarrinhoCompra carrinhoCompra) {
		
		List<Produto> produtos = produtoGateway.obterPorIds(carrinhoCompra.obterIdsProdutos());
		carrinhoCompra.atualizarProdutos(produtos);
		
		return carrinhoGateway.salvar(carrinhoCompra);
	}

}
