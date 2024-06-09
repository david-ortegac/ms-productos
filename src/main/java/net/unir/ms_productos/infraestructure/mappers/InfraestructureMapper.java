package net.unir.ms_productos.infraestructure.mappers;

import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import net.unir.ms_productos.infraestructure.entities.ProductsJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfraestructureMapper {

    ProductsDomainDTO toDomain(ProductsJPA item);

    List<ProductsDomainDTO> toDomainList(Iterable<ProductsJPA> items);

    ProductsJPA fromDomain(ProductsDomainDTO item);
}
