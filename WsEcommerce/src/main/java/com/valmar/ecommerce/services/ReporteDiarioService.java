package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.ReporteDiario;

public interface ReporteDiarioService {
	void agregar(ReporteDiario reporte);    
    List<ReporteDiario> listar();
}
