package ar.com.lemondata.ejercicio.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

/**
 * @author Fernando
 *
 */
public abstract class GenericBean {

	public void volver() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("/home.xhtml");
	}

	public void mostrarPopUp(String id) {
		PrimeFaces.current().executeScript("PF('" + id + "').show();");
	}

	public void mostrarMensaje(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
}
