package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.CarrinhoCompra;

public interface CarrinhoGateway {

	Long salvar(CarrinhoCompra carrinhoCompra);

}
