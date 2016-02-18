/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.LHoraIncidenciaEstudiante;
import entities.LHoraIncidenciaEstudiantePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author edito
 */
@Stateless
@Path("entities.lhoraincidenciaestudiante")
public class LHoraIncidenciaEstudianteFacadeREST extends AbstractFacade<LHoraIncidenciaEstudiante> {
    @PersistenceContext(unitName = "LeccionarioV3PU")
    private EntityManager em;

    private LHoraIncidenciaEstudiantePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idLeccionario=idLeccionarioValue;idHora=idHoraValue;idEstudiante=idEstudianteValue;idIncidencia=idIncidenciaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.LHoraIncidenciaEstudiantePK key = new entities.LHoraIncidenciaEstudiantePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idLeccionario = map.get("idLeccionario");
        if (idLeccionario != null && !idLeccionario.isEmpty()) {
            key.setIdLeccionario(new java.lang.Integer(idLeccionario.get(0)));
        }
        java.util.List<String> idHora = map.get("idHora");
        if (idHora != null && !idHora.isEmpty()) {
            key.setIdHora(new java.lang.Integer(idHora.get(0)));
        }
        java.util.List<String> idEstudiante = map.get("idEstudiante");
        if (idEstudiante != null && !idEstudiante.isEmpty()) {
            key.setIdEstudiante(new java.lang.Integer(idEstudiante.get(0)));
        }
        java.util.List<String> idIncidencia = map.get("idIncidencia");
        if (idIncidencia != null && !idIncidencia.isEmpty()) {
            key.setIdIncidencia(new java.lang.Integer(idIncidencia.get(0)));
        }
        return key;
    }

    public LHoraIncidenciaEstudianteFacadeREST() {
        super(LHoraIncidenciaEstudiante.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(LHoraIncidenciaEstudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, LHoraIncidenciaEstudiante entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.LHoraIncidenciaEstudiantePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LHoraIncidenciaEstudiante find(@PathParam("id") PathSegment id) {
        entities.LHoraIncidenciaEstudiantePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LHoraIncidenciaEstudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LHoraIncidenciaEstudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
