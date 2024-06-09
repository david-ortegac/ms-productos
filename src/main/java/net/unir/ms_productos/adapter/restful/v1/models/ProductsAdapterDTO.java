package net.unir.ms_productos.adapter.restful.v1.models;

import lombok.Data;

@Data
public class ProductsAdapterDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private int amount;

}
