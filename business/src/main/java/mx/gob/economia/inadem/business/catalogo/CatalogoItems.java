package mx.gob.economia.inadem.business.catalogo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import mx.gob.economia.inadem.entity.Entidad;
import mx.gob.economia.inadem.entity.catalogo.Catalogo;

public class CatalogoItems<T extends Catalogo> {
	private final Class<T> type;

	private List<T> list;
	
	public CatalogoItems(Class<T> cls) {
		this.type = cls;
	}

	public List<T> getAllItems() {
	    if(this.list == null)
	    	this.list = Entidad.list(this.type);
		return list;
	}

	public List<T> getActiveItems() {
		List<T> list = new ArrayList<>();
		for (T t : getAllItems())
			if (t.isActivo())
				list.add((T) t);
		return list;
	}

	public List<T> getInactiveItems() {
		List<T> list = new ArrayList<>();
		for (T t : getAllItems())
			if (!t.isActivo())
				list.add((T) t);
		return list;
	}

	public List<SelectItem> getSelectItems() {
		List<SelectItem> list = new ArrayList<>();
		for (T t : getActiveItems())
			list.add(new SelectItem(t, t.getNombre(), t.getDescripcion()));
		return list;
	}

}