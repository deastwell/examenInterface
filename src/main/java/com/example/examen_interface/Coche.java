package com.example.examen_interface;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coche {


    private String matricula;
    private String modelo;
    private String cliente;
    private String tarifa;
    private LocalDate entrada;
    private LocalDate salida;


}
