package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Horarios;

public interface HorarioService {
	List<Horarios> obtenerHorariosPorTienda(int id);
	void agregar(Horarios horario);
}
