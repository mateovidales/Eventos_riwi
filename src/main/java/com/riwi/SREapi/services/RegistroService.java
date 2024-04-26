package com.riwi.SREapi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.SREapi.entities.RegistroEvento;
import com.riwi.SREapi.repositories.RegistroRepository;
import com.riwi.SREapi.services.abstract_service.IRegistroService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistroService implements IRegistroService{
    
    @Autowired
    private final RegistroRepository objRegistroRepository;
    
    @Override
    public RegistroEvento save(RegistroEvento objRegistroEvento) {
        return this.objRegistroRepository.save(objRegistroEvento);
    }

    public List<RegistroEvento> getAll() {
        return this.objRegistroRepository.findAll();
    }

    public Page<RegistroEvento> findAllPaginate(int page, int size){
        if(page<0){
            page = 0;
        }
        Pageable objpage = PageRequest.of(page, size);
        return this.objRegistroRepository.findAll(objpage);
    }

    @Override
    public RegistroEvento getById(String id) {
        return this.objRegistroRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        RegistroEvento registro = this.objRegistroRepository.findById(id).orElseThrow();
        this.objRegistroRepository.delete(registro);
    }

    @Override
    public RegistroEvento update(RegistroEvento objRegistroEvento) {
        return this.objRegistroRepository.save(objRegistroEvento);
    }

}
