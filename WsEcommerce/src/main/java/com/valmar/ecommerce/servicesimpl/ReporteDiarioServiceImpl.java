package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ReporteDiarioDao;
import com.valmar.ecommerce.model.ReporteDiario;
import com.valmar.ecommerce.services.ReporteDiarioService;

@Service("reporteDiarioService")
@Transactional
public class ReporteDiarioServiceImpl implements ReporteDiarioService{

	@Autowired
	ReporteDiarioDao dao;
	
	@Override
	public void agregar(ReporteDiario reporte) {
		dao.agregar(reporte);
	}

	@Override
	public List<ReporteDiario> listar() {
		return dao.listar();
	}

}
