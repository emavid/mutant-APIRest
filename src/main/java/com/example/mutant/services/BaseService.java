package com.example.mutant.services;

import java.io.Serializable;

public interface BaseService<E, ID extends Serializable> {
    public E detectarMutante(E entity) throws Exception;
    public boolean delete(ID id) throws Exception;
}
