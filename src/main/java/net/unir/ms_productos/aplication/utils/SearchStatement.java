package net.unir.ms_productos.aplication.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchStatement {
    private String key;
    private Object value;
    private SearchOperation operation;
}
