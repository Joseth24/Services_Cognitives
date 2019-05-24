package Controller;

import Dao.consultarD;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.consultarM;

@Data
@Named(value = "consultarC")
@SessionScoped
public class consultarC implements Serializable {

    private String urlImage;
    private String resultado;
    private consultarD dao = new consultarD();
    consultarM modelo = new consultarM();

    public void consultar() throws Exception {
        try {
            modelo = dao.consultar(urlImage);
            modelo.setLINK(urlImage);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CONSULTA", "EXITOSA"));
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "URL", "INCORRECTA"));
            throw ex;
        }
    }

    public void clear() throws Exception {
        try {
            modelo = new consultarM();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "LIMPIADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", null));
            throw e;
        }
    }

}
