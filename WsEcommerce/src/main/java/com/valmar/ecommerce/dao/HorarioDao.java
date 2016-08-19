package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Horarios;

public interface HorarioDao {
	List<Horarios> obtenerHorariosPorTienda(int id);
	void agregar(Horarios horario);
}
