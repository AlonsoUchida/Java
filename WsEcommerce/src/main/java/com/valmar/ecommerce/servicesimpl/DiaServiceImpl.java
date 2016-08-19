package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.DiaDao;
import com.valmar.ecommerce.model.Dias;
import com.valmar.ecommerce.services.DiaService;

@Service("diaService")
@Transactional
public class DiaServiceImpl implements DiaService{

	@Autowired
	DiaDao dao;
	
	@Override
	public List<Dias> listar() {
		return dao.listar();
	}

}
