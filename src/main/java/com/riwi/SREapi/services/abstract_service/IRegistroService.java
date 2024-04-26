package com.riwi.SREapi.services.abstract_service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.SREapi.entities.RegistroEvento;

public interface IRegistroService {
    public RegistroEvento save(RegistroEvento objRegistroEvento);

    public List<RegistroEvento> getAll();

    public Page<RegistroEvento> findAllPaginate(int page, int size);

    public RegistroEvento getById(String id);

    public void delete(String id);

    public RegistroEvento update(RegistroEvento objRegistroEvento);
}
