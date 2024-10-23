package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.api.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ProdutoJson {
	private Long id;
	private String nome;
	private Double preco;
}
