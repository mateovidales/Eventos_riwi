package com.riwi.SREapi.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private int capacidad;
}
