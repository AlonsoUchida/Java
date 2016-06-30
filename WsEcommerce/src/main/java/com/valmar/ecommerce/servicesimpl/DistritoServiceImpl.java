package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.DistritoDao;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.services.DistritoService;

@Service("distritoService")
@Transactional
public class DistritoServiceImpl implements DistritoService{

	@Autowired
	DistritoDao distritoDao;
	
	@Override
	public List<Distrito> listarDistritos() {
		return distritoDao.listarDistritos();
	}

}
