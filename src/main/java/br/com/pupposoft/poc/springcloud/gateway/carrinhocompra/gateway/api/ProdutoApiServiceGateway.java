package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.Produto;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.exception.AcessoProdutoServiceException;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.ProdutoGateway;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.feign.ProdutoFeignClient;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.json.ProdutoJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoApiServiceGateway implements ProdutoGateway {

	private final ProdutoFeignClient produtoFeignClient;

	@Override
	public List<Produto> obterPorIds(List<Long> idsProdutos) {

		try {

			return idsProdutos.stream()
					.map(produtoFeignClient::obterPorId)
					.map(this::mapJsonToDomain)
					.toList();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AcessoProdutoServiceException();
		}

	}

	private Produto mapJsonToDomain(ProdutoJson produtoJson) {
		return new Produto(produtoJson.getId(), BigDecimal.valueOf(produtoJson.getPreco()));
	}

}
