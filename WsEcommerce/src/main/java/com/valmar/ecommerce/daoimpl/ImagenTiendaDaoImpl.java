package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ImagenTiendaDao;
import com.valmar.ecommerce.enums.TipoImagen;
import com.valmar.ecommerce.model.ImagenTienda;

@Repository("imagenTiendaDao")
@EnableTransactionManagement
public class ImagenTiendaDaoImpl extends AbstractDao<Integer, ImagenTienda> implements ImagenTiendaDao{

	@Override
	public List<ImagenTienda> listarImagenes() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<ImagenTienda> imagenes = (List<ImagenTienda>) criteria.list();
			return imagenes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ImagenTienda obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (ImagenTienda) criteria.uniqueResult();
	}
	
	@Override
	public void agregarImagen(ImagenTienda imagen) {
		try {
			persist(imagen);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarImagen(ImagenTienda imagen) {
		try {
			merge(imagen);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from imagen_tienda where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ImagenTienda obtenerImagenPorDefecto(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("tienda.id", id));
		criteria.add(Restrictions.eq("id", TipoImagen.DEFECTO.getValue()));
		return (ImagenTienda) criteria.uniqueResult();
	}

	@Override
	public List<ImagenTienda> listarImagenesPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tienda.id", id));
			List<ImagenTienda> imagenes = (List<ImagenTienda>) criteria.list();
			return imagenes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
