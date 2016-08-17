package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.ReporteDiario;

public interface ReporteDiarioDao {	
    void agregar(ReporteDiario reporte);    
    List<ReporteDiario> listar();

}
