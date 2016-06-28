package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ImagenProductoDao;
import com.valmar.ecommerce.enums.TipoImagen;
import com.valmar.ecommerce.model.ImagenProducto;

@Repository("imagenProductoDao")
@EnableTransactionManagement
public class ImagenProductoDaoImpl extends AbstractDao<Integer, ImagenProducto> implements ImagenProductoDao{

	@Override
	public List<ImagenProducto> listarImagenes() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<ImagenProducto> imagenes = (List<ImagenProducto>) criteria.list();
			return imagenes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ImagenProducto obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (ImagenProducto) criteria.uniqueResult();
	}
	
	@Override
	public void agregarImagen(ImagenProducto imagen) {
		try {
			persist(imagen);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarImagen(ImagenProducto imagen) {
		try {
			merge(imagen);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from imagen_producto where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ImagenProducto obtenerImagenPorDefecto(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("producto.id", id));
		criteria.add(Restrictions.eq("id", TipoImagen.DEFECTO.getValue()));
		return (ImagenProducto) criteria.uniqueResult();
	}

}
