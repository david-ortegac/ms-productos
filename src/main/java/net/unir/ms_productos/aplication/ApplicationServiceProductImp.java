package net.unir.ms_productos.aplication;

import lombok.extern.slf4j.Slf4j;
import net.unir.ms_productos.adapter.restful.v1.mappers.AdapterProductsMapper;
import net.unir.ms_productos.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_productos.domain.ProductsRepositoryDomain;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ApplicationServiceProductImp implements ApplicationServiceProduct {

    @Autowired
    private ProductsRepositoryDomain repositoryDomain;

    @Autowired
    private AdapterProductsMapper mapper;

    @Override
    public ProductsDomainDTO getProvidersById(Long id) {
        return repositoryDomain.getById(id);
    }

    @Override
    public List<ProductsAdapterDTO> getAll(String name, String description, int amount, Double price) {
        if (StringUtils.hasLength(name) || StringUtils.hasLength(description) || amount > 0 || price > 0) {
            return mapper.fromDomainToAdapterList(repositoryDomain.search(name, description, amount, price));
        }
        return mapper.fromDomainToAdapterList(repositoryDomain.getAll());
    }

    @Override
    public ProductsDomainDTO saveProvider(ProductsAdapterDTO adapterDTO) throws Exception {
        if (StringUtils.hasLength(adapterDTO.getName()) && StringUtils.hasLength(adapterDTO.getDescription()) && adapterDTO.getAmount() > 0 && adapterDTO.getPrice() > 0) {
            return repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
        } else {
            throw new Exception("Error al guardar el producto");
        }
    }

    @Override
    public ProductsDomainDTO updateProvider(Long id, ProductsAdapterDTO adapterDTO) {
        ProductsDomainDTO product = this.getProvidersById(id);
        adapterDTO.setId(id);
        if (adapterDTO.getName() != product.name) {
            adapterDTO.setName(product.getName());
        } else {
            adapterDTO.setName(adapterDTO.getName());
        }

        if (adapterDTO.getDescription() != product.description) {
            adapterDTO.setDescription(product.getDescription());
        } else {
            adapterDTO.setDescription(adapterDTO.getDescription());
        }

        if (adapterDTO.getPrice() != product.price) {
            adapterDTO.setAmount(product.getAmount());
        } else {
            adapterDTO.setAmount(adapterDTO.getAmount());
        }

        if (adapterDTO.getAmount() != product.amount) {
            adapterDTO.setPrice(product.getPrice());
        } else {
            adapterDTO.setPrice(adapterDTO.getPrice());
        }

        return repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
    }

    @Override
    public ProductsDomainDTO deleteProvider(Long id) {
        return repositoryDomain.delete(id);
    }
}
