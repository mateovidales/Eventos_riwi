package com.riwi.SREapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.SREapi.entities.RegistroEvento;


@Repository
public interface RegistroRepository extends JpaRepository<RegistroEvento, String> {

}

