package net.unir.ms_productos.aplication;


import net.unir.ms_productos.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;

import java.util.List;

public interface ApplicationServiceProduct {
    ProductsDomainDTO getProvidersById(Long id);
    List<ProductsAdapterDTO> getAll(String name, String description, int amount, Double price);
    ProductsDomainDTO saveProvider(ProductsAdapterDTO adapterDTO);
    ProductsDomainDTO updateProvider(Long id, ProductsAdapterDTO adapterDTO);
    ProductsDomainDTO deleteProvider(Long id);
}
