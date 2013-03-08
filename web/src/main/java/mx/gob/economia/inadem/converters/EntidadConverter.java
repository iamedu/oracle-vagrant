package mx.gob.economia.inadem.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import mx.gob.economia.inadem.entity.Entidad;

public class EntidadConverter implements Converter
{
	  public Object getAsObject(FacesContext context, UIComponent component, String value)
	  {
	    try
	    {
	      String[] s = value.split("-pipe-");
	      return Entidad.findAny(Class.forName(s[0]), Long.valueOf(Long.parseLong(s[1])));
	    }
	    catch (Exception localException)
	    {
	    }

	    return null;
	  }

	  public String getAsString(FacesContext context, UIComponent component, Object value)
	  {
	    try
	    {
	      return value.getClass().getName() + "-pipe-" + ((Entidad)value).getId().toString(); } catch (Exception e) {
	    }
	    return "-1";
	  }

}
