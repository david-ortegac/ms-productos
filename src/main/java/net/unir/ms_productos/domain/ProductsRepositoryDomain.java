package net.unir.ms_productos.domain;

import net.unir.ms_productos.domain.entities.ProductsDomainDTO;

import java.util.List;

public interface ProductsRepositoryDomain {

    List<ProductsDomainDTO> getAll();
    List<ProductsDomainDTO> search(String name, String description, int amount, Double price);
    ProductsDomainDTO getById(Long id);
    ProductsDomainDTO save(ProductsDomainDTO domainDTO);
    ProductsDomainDTO delete(Long id);
}
