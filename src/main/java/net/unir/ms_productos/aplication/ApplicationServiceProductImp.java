package net.unir.ms_productos.aplication;

import lombok.extern.slf4j.Slf4j;
import net.unir.ms_productos.adapter.restful.v1.mappers.AdapterProductsMapper;
import net.unir.ms_productos.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_productos.domain.ProductsRepositoryDomain;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
    public ProductsDomainDTO saveProvider(ProductsAdapterDTO adapterDTO) {
        return repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
    }

    @Override
    public ProductsDomainDTO updateProvider(Long id, ProductsAdapterDTO adapterDTO) {
        return repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
    }

    @Override
    public ProductsDomainDTO deleteProvider(Long id) {
        return repositoryDomain.delete(id);
    }
}
