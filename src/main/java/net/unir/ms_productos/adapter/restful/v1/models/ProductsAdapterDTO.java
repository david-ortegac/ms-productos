package net.unir.ms_productos.adapter.restful.v1.models;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ProductsAdapterDTO {

    private Long id;

    @Valid
    private String name;

    @Valid
    private String description;

    @Valid
    private Double price;

    @Valid
    private int amount;

}
