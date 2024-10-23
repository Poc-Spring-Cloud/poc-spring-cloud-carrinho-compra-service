package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Item")
public class ItemEntity {

	@EmbeddedId
	private ItemId id;
	
	private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "idCarrinho", insertable = false, updatable = false)
	private CarrinhoCompraEntity carrinho;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduto", insertable = false, updatable = false)
    private ProdutoEntity produto;

}
