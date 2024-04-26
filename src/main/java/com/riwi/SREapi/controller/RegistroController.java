package com.riwi.SREapi.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.SREapi.entities.RegistroEvento;
import com.riwi.SREapi.services.abstract_service.IRegistroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/registro-evento")
@AllArgsConstructor
public class RegistroController {
    @Autowired
    private final IRegistroService objIRegistroService;

    @GetMapping
    public ResponseEntity<Page<RegistroEvento>> getAll(@RequestParam int page, int size) {
        return ResponseEntity.ok(this.objIRegistroService.findAllPaginate(1, 1));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RegistroEvento> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.objIRegistroService.getById(id));
    }

    @PostMapping
    public ResponseEntity<RegistroEvento> insert(@RequestBody RegistroEvento objRegistroEvento) {
        if (this.validationDate(objRegistroEvento) && objRegistroEvento.getCapacidad() > 0) {
            return ResponseEntity.ok(this.objIRegistroService.save(objRegistroEvento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.objIRegistroService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RegistroEvento> update(@RequestBody RegistroEvento objRegistroEvento,
            @PathVariable String id) {
        objRegistroEvento.setId(id);
        return ResponseEntity.ok(this.objIRegistroService.update(objRegistroEvento));
    }

    public boolean validationDate(RegistroEvento objRegistroEvento) {
        Date fecha = objRegistroEvento.getFecha();
        Date fechaActual = new Date();

        if (fecha.before(fechaActual))
            return false;
        return true;
    }
}
