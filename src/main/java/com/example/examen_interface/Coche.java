package com.example.examen_interface;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Coche {


    private String matricula;
    private String modelo;
    private String cliente;
    private String tarifa;
    private LocalDate entrada;
    private LocalDate salida;
    private int coste;

    public Coche() {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.entrada = entrada;
        this.salida = salida;
        this.coste = coste;
    }



}

