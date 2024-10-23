package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.controller.json;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarrinhoCompraJson {
	private Long usuarioId;
	private List<ItemCompraJson> itens;
}
