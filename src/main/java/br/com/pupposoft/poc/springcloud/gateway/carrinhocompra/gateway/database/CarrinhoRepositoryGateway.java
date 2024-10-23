package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database;

import org.springframework.stereotype.Component;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.CarrinhoCompra;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.domain.Item;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.exception.AcessoRepositorioDadosException;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.CarrinhoGateway;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.CarrinhoCompraEntity;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.ItemEntity;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.ItemId;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.ProdutoEntity;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.repository.CarrinhoCompraRepository;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.repository.ItemRepository;
import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class CarrinhoRepositoryGateway implements CarrinhoGateway {

	private final CarrinhoCompraRepository carrinhoCompraRepository;
	private final ItemRepository itemRepository;
	private final ProdutoRepository produtoRepository;
	
	@Override
	@Transactional
	public Long salvar(CarrinhoCompra carrinhoCompra) {
		try {
			
			CarrinhoCompraEntity carrinhoEntity = 
					CarrinhoCompraEntity.builder().idUsuario(carrinhoCompra.getUsuarioId()).build();
			carrinhoCompraRepository.save(carrinhoEntity);
			
			final Long carrinhoId = carrinhoEntity.getId();

			carrinhoCompra.getItens().forEach(i -> {
				Long produtoId = createProduto(i);
				ItemId itemId = new ItemId(carrinhoId, produtoId);
				ItemEntity itemEntity = ItemEntity.builder()
						.id(itemId)
						.quantidade(i.getQuantidade())
						.build();
				
				itemRepository.save(itemEntity);
				
			});
			
			return carrinhoId;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AcessoRepositorioDadosException();
		}
	}

	private Long createProduto(Item i) {
		ProdutoEntity produtoEntity = ProdutoEntity.builder()
				.idProdutoService(i.getProdutoId())
				.valor(i.getProduto().getPreco())
				.build();
		
		return produtoRepository.save(produtoEntity).getId();
	}
}
