package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.json.ProdutoJson;

@FeignClient(value = "POC-SPRING-CLOUD-PRODUTO-SERVICE", path = "produto")
public interface ProdutoFeignClient {

	@GetMapping("/poc/spring-cloud/v1/produtos/{id}")
	ProdutoJson obterPorId(@PathVariable(value = "id") Long id);
	
}
