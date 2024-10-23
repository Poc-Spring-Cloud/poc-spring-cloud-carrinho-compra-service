package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.controller.json;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemCompraJson {
	private Long produtoId;
	private Integer quantidade;
}
