/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stonebank.bean;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import stonebank.ejb.TusuarioFacade;
import stonebank.entity.Tusuario;

/**
 *
 * @author Victor
 */
@Named(value = "busquedaBean")
@Dependent
public class BusquedaBean {

    @EJB
    private TusuarioFacade tusuarioFacade;
    private String busqueda;
    public List<Tusuario> listaResultado;
    
    
    /**
     * Creates a new instance of BusquedaBean
     */
    public BusquedaBean() {
        busqueda = "";
        listaResultado = new LinkedList<>();
    }
    
    public void Buscar(){
        listaResultado = tusuarioFacade.buscarTUsuarioPorNombre(busqueda);
    }
}
