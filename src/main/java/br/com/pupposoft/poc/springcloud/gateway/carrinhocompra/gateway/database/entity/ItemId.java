package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ItemId implements Serializable {
	private static final long serialVersionUID = 647078052136410494L;
	private Long idCarrinho;
	private Long idProduto;
}
