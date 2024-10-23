package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
	private Long id;
	private BigDecimal preco;
}
