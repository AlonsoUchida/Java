package com.valmar.ecommerce.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.EnvioDao;
import com.valmar.ecommerce.model.Envio;

@Repository("envioDao")
@EnableTransactionManagement
public class EnvioDaoImpl extends AbstractDao<Integer, Envio> implements EnvioDao{

	@Override
	public void agregar(Envio envio) {
		try{
			persist(envio);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
