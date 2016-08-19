package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.HorarioDao;
import com.valmar.ecommerce.model.Horarios;
import com.valmar.ecommerce.services.HorarioService;

@Service("horarioService")
@Transactional
public class HorarioServiceImpl implements HorarioService{

	@Autowired
	HorarioDao dao;

	@Override
	public List<Horarios> obtenerHorariosPorTienda(int id) {
		return dao.obtenerHorariosPorTienda(id);
	}

	@Override
	public void agregar(Horarios horario) {
		dao.agregar(horario);		
	}
}
