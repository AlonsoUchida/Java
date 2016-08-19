package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.HoraDao;
import com.valmar.ecommerce.model.Horas;
import com.valmar.ecommerce.services.HoraService;

@Service("horaService")
@Transactional
public class HoraServiceImpl implements HoraService{

	@Autowired
	HoraDao dao;
	
	@Override
	public List<Horas> listar() {
		return dao.listar();
	}

}
