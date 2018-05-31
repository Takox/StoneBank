/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stonebank.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import stonebank.ejb.TusuarioFacade;
import stonebank.entity.Tusuario;

/**
 *
 * @author Victor
 */
@Named(value = "busquedaBean")
@SessionScoped
public class BusquedaBean implements Serializable{

    @EJB
    private TusuarioFacade tusuarioFacade;
    private String busqueda;
    private List<Tusuario> listaResultado;
    
    @PostConstruct
    public void init(){
        busqueda = "";
        listaResultado = tusuarioFacade.findAll();
    }
    
    /**
     * Creates a new instance of BusquedaBean
     */
    public BusquedaBean() {
        
    }
    
    public String buscar(){
        setListaResultado(tusuarioFacade.buscarTUsuarioPorNombre(busqueda));
        return "indexEmpleadoBusqueda";
    }

    public TusuarioFacade getTusuarioFacade() {
        return tusuarioFacade;
    }

    public void setTusuarioFacade(TusuarioFacade tusuarioFacade) {
        this.tusuarioFacade = tusuarioFacade;
    }

    public List<Tusuario> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(List<Tusuario> listaResultado) {
        this.listaResultado = listaResultado;
    }

    public String getBusqueda() {
        return busqueda;
    }
    
    public void setBusqueda(String b){
        busqueda = b;
    }
}
