package net.unir.ms_productos.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDomainDTO {
    public Long id;
    public String name;
    public String description;
    public Double price;
    public int amount;
}
