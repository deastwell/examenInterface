package com.example.examen_interface;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Session {
    @Getter
    @Setter
    private static Coche entradaActual = null;

    @Getter
    @Setter
    private static ArrayList<Coche> entradas = new ArrayList<>(0);

}
