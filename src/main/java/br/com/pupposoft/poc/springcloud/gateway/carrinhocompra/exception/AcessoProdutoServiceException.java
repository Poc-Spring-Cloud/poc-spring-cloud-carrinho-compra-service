package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.exception;

import lombok.Getter;

@Getter
public class AcessoProdutoServiceException extends SystemBaseException {
	private static final long serialVersionUID = 5897188869189066850L;
	
	private final String code = "carrinho-compra-service.erroAcessoProdutoService";//NOSONAR
	private final String message = "Erro ao acessar o serviço de produtos";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
