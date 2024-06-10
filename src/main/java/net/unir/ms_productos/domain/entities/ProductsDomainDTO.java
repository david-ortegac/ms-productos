package net.unir.ms_productos.domain.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDomainDTO {
    public Long id;

    @Valid
    @NotNull
    public String name;

    @Valid
    @NotNull
    public String description;

    @Valid
    @NotNull
    public Double price;

    @Valid
    @NotNull
    public int amount;
}
