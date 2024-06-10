package net.unir.ms_productos.adapter.restful.v1.rest;

import jakarta.validation.Valid;
import net.unir.ms_productos.adapter.restful.v1.mappers.AdapterProductsMapper;
import net.unir.ms_productos.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_productos.aplication.ApplicationServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class RestfulAdapterProviders {

    @Autowired
    private AdapterProductsMapper mapper;

    @Autowired
    private ApplicationServiceProduct serviceProviders;

    @GetMapping
    public ResponseEntity<List<ProductsAdapterDTO>> getAllProviders(@Valid ProductsAdapterDTO searchParams) {
        return new ResponseEntity<>(mapper.fromDomainToAdapterList(mapper.fromAdapterToDomainList(serviceProviders.getAll(
                searchParams.getName(), searchParams.getDescription(), searchParams.getAmount(), searchParams.getPrice()
        ))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsAdapterDTO> getProvidersById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.getProvidersById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductsAdapterDTO> save(@Valid @RequestBody ProductsAdapterDTO adapterDTO) throws Exception {
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.saveProvider(adapterDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    public ResponseEntity<ProductsAdapterDTO> save(@Valid @PathVariable Long id, @Valid @RequestBody ProductsAdapterDTO adapterDTO){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.updateProvider(id, adapterDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsAdapterDTO> delete(@Valid @PathVariable Long id){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.deleteProvider(id)), HttpStatus.OK);
    }
}
