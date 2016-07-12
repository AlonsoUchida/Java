package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.TipoDocumento;

public interface TipoDocumentoDao {
	TipoDocumento obtenerPorId(int id);
	List<TipoDocumento> listar();
}
