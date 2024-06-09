package net.unir.ms_productos.adapter.restful.v1.mappers;

import net.unir.ms_productos.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdapterProductsMapper {
    ProductsAdapterDTO fromDomainToAdapter(ProductsDomainDTO domainDTO);
    ProductsDomainDTO fromAdapterToDomain(ProductsAdapterDTO adapterDTO);

    List<ProductsAdapterDTO> fromDomainToAdapterList(List<ProductsDomainDTO> providerDomainDTOList);

    List<ProductsDomainDTO> fromAdapterToDomainList(List<ProductsAdapterDTO> adapterDTOList);
}
