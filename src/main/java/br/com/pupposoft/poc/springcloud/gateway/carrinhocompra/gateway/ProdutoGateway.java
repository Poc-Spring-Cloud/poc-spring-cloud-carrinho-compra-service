package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway;

import java.util.List;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.Produto;

public interface ProdutoGateway {

	List<Produto> obterPorIds(List<Long> obterIdsProdutos);

}
