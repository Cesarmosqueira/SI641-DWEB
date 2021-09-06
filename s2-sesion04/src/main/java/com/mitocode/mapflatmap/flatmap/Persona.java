package com.mitocode.mapflatmap.flatmap;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {
	private String nombre;
	private List<Viaje> viajes = new ArrayList<>();

	public Persona(String nombre) {
		this.nombre = nombre;
	}
}
