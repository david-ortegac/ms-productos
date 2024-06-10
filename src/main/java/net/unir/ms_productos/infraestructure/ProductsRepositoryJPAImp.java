package net.unir.ms_productos.infraestructure;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import net.unir.ms_productos.aplication.utils.SearchCriteria;
import net.unir.ms_productos.aplication.utils.SearchOperation;
import net.unir.ms_productos.aplication.utils.SearchStatement;
import net.unir.ms_productos.domain.ProductsRepositoryDomain;
import net.unir.ms_productos.domain.entities.ProductsDomainDTO;
import net.unir.ms_productos.infraestructure.entities.ProductsJPA;
import net.unir.ms_productos.infraestructure.mappers.InfraestructureMapper;
import net.unir.ms_productos.infraestructure.repositories.ProductsRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductsRepositoryJPAImp implements ProductsRepositoryDomain {

    private static final Pageable pageable = PageRequest.of(0, 10);

    @Autowired
    private ProductsRepositoryJPA repositoryJPA;

    @Autowired
    private InfraestructureMapper mapper;

    @Override
    public List<ProductsDomainDTO> getAll() {
        List<ProductsJPA> providersJPA = repositoryJPA.findAll();
        return mapper.toDomainList(providersJPA);
    }

    @Override
    public List<ProductsDomainDTO> search(String name, String description, int amount, Double price) {
        SearchCriteria<ProductsJPA> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(name)) {
            spec.add(new SearchStatement("name", name, SearchOperation.MATCH));
        }
        if (StringUtils.isNotBlank(description)) {
            spec.add(new SearchStatement("description", description, SearchOperation.MATCH));
        }
        if (price!=null && price > 0) {
            spec.add(new SearchStatement("price", price, SearchOperation.EQUAL));
        }
        if (amount > 0) {
            spec.add(new SearchStatement("amount", amount, SearchOperation.EQUAL));
        }

        return mapper.toDomainList(repositoryJPA.findAll(spec));
    }

    @Override
    public ProductsDomainDTO getById(Long id) {
        Optional<ProductsJPA> getById = repositoryJPA.findById(id);
        return mapper.toDomain(getById.orElse(null));
    }

    @Override
    public ProductsDomainDTO save(ProductsDomainDTO domainDTO) {
        return mapper.toDomain(repositoryJPA.save(mapper.fromDomain(domainDTO)));
    }

    @Override
    public ProductsDomainDTO delete(Long id) {
        Optional<ProductsJPA> deleted = repositoryJPA.findById(id);
        repositoryJPA.deleteById(id);
        return mapper.toDomain(deleted.orElseThrow());
    }
}
