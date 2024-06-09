package net.unir.ms_productos.infraestructure.repositories;

import net.unir.ms_productos.aplication.utils.SearchCriteria;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import net.unir.ms_productos.infraestructure.entities.ProductsJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductsRepositoryJPA extends JpaRepository<ProductsJPA, Long>, JpaSpecificationExecutor<ProductsJPA> {
    List<ProductsJPA> findByNameContainingIgnoreCase(String nombre);
    List<ProductsJPA> findByDescriptionContainingIgnoreCase(String descripcion);
    List<ProductsJPA> findByPrice(double price);
    List<ProductsJPA> findByAmount(double amount);
}
