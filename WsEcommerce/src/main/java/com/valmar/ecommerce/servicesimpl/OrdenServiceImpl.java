package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.OrdenDao;
import com.valmar.ecommerce.model.Orden;
import com.valmar.ecommerce.services.OrdenService;

@Service("ordenService")
@Transactional
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenDao ordenDao;
	
	@Override
	public List<Orden> listarOrdenes(int id) {
		return ordenDao.listarOrdenes(id);
	}

}
