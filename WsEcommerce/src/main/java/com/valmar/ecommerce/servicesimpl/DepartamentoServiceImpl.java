package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.DepartamentoDao;
import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.services.DepartamentoService;

@Service("departamentoService")
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	DepartamentoDao departamentoDao;
	
	@Override
	public List<Departamento> listarDepartamentos() {
		return departamentoDao.listarDepartamentos();
	}

}
