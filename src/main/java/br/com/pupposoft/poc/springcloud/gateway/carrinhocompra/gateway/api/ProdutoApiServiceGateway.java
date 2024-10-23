package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.Produto;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.exception.AcessoProdutoServiceException;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.ProdutoGateway;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.json.ProdutoJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoApiServiceGateway implements ProdutoGateway {

	@Value("${poc.monitoramento.service.produto.base-url}")
	private String produtoBaseUrl;

	private final WebClient.Builder webClientBuilder;

	@Override
	public List<Produto> obterPorIds(List<Long> idsProdutos) {

		try {

			final String url = produtoBaseUrl + "/poc/monitoramento/produto/v1/produtos/";

			return idsProdutos.stream()
					.map(id -> url + id)
					.map(this::callService)
					.map(this::mapJsonToDomain)
					.toList();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AcessoProdutoServiceException();
		}

	}

	private ProdutoJson callService(String url) {
		WebClient webClient = webClientBuilder.baseUrl(url).build();
		return webClient
				.get()
				.retrieve()
				.bodyToMono(ProdutoJson.class)
				.block(); // 'block()' é utilizado para realizar a chamada de forma síncrona.

	}

	private Produto mapJsonToDomain(ProdutoJson produtoJson) {
		return new Produto(produtoJson.getId(), BigDecimal.valueOf(produtoJson.getPreco()));
	}

}
