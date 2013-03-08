package mx.gob.economia.inadem.business.catalogo;

import java.util.HashMap;

import mx.gob.economia.inadem.entity.beneficiario.PreguntaSeguridad;
import mx.gob.economia.inadem.entity.solicitud.CoberturaGeografica;
import mx.gob.economia.inadem.entity.ubicacion.Estado;
import mx.gob.economia.inadem.entity.ubicacion.Municipio;
import mx.gob.economia.inadem.entity.ubicacion.TipoAsentamiento;
import mx.gob.economia.inadem.entity.ubicacion.TipoVialidad;

public class CatalogoItemsMap extends HashMap<String, CatalogoItems<?>>{

	private static final long serialVersionUID = 1L;
    
	private static CatalogoItemsMap instance;
	
	private static final String preguntaSeguridadTypeKey = "preguntaSeguridadType";
	private static final String estadosTypeKey = "estadosType";
	private static final String municipiosTypeKey = "municipiosType";
	private static final String tiposAsentamientoTypeKey = "tiposAsentamientoType";
	private static final String tiposVialidadTypeKey = "tiposVialidadType";
	private static final String coberturaGeograficaTypeKey = "coberturaGeograficaType";
	
	private CatalogoItemsMap(){
		
		put(preguntaSeguridadTypeKey, new CatalogoItems<>(PreguntaSeguridad.class));
		put(estadosTypeKey, new CatalogoItems<>(Estado.class));
		put(municipiosTypeKey, new CatalogoItems<>(Municipio.class));
		put(tiposAsentamientoTypeKey, new CatalogoItems<>(TipoAsentamiento.class));
		put(tiposVialidadTypeKey, new CatalogoItems<>(TipoVialidad.class));
		put(coberturaGeograficaTypeKey, new CatalogoItems<>(CoberturaGeografica.class));
	}
	
	public static synchronized CatalogoItemsMap getInstance(){
		if(instance==null)
			instance =new CatalogoItemsMap();
		return instance;
	}
	
	

}
