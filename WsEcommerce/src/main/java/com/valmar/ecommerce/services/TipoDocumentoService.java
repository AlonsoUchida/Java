package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.TipoDocumento;

public interface TipoDocumentoService {
	TipoDocumento obtenerPorId(int id);
	List<TipoDocumento> listar();
}
