/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Hora_;
import entities.LeccionarioHora;
import entities.LeccionarioHoraPK;
import entities.LeccionarioHoraPK_;
import entities.LeccionarioHora_;
import entities.Leccionario_;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.persistence.criteria.Join;


/**
 *
 * @author edito
 */
@Stateless
@Path("entities.leccionariohora")
public class LeccionarioHoraFacadeREST extends AbstractFacade<LeccionarioHora> {
    @PersistenceContext(unitName = "LeccionarioV3PU")
    private EntityManager em;

    private LeccionarioHoraPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idLeccionario=idLeccionarioValue;idHora=idHoraValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.LeccionarioHoraPK key = new entities.LeccionarioHoraPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idLeccionario = map.get("idLeccionario");
        if (idLeccionario != null && !idLeccionario.isEmpty()) {
            key.setIdLeccionario(new java.lang.Integer(idLeccionario.get(0)));
        }
        java.util.List<String> idHora = map.get("idHora");
        if (idHora != null && !idHora.isEmpty()) {
            key.setIdHora(new java.lang.Integer(idHora.get(0)));
        }
        return key;
    }

    public LeccionarioHoraFacadeREST() {
        super(LeccionarioHora.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(LeccionarioHora entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, LeccionarioHora entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.LeccionarioHoraPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LeccionarioHora find(@PathParam("id") PathSegment id) {
        entities.LeccionarioHoraPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LeccionarioHora> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LeccionarioHora> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    //me dice q no encuentra la direccion,no se porque ????
    @POST
    @Path("addHoraLeccionario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
      public String adicionarHoraLeccionario(JsonObject leccionarioHora) {
        JsonObject json = null;
        
        try {
            javax.persistence.criteria.CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<LeccionarioHora> query = cb.createQuery(LeccionarioHora.class);
            Root<LeccionarioHora> root = query.from(LeccionarioHora.class);
            query.select(root);
            root.join(LeccionarioHora_.hora, JoinType.LEFT).join(Hora_.idHora, JoinType.LEFT); 
             root.join(LeccionarioHora_.leccionario, JoinType.LEFT).join(Leccionario_.idLeccionario, JoinType.LEFT);  
            query.where(cb.and(cb.equal(root.get(LeccionarioHora_.hora),leccionarioHora.getString("hora"))),
                    cb.equal(root.get(LeccionarioHora_.leccionario), leccionarioHora.getString("idLeccionario")));
             
            TypedQuery<LeccionarioHora> queryFinal = em.createQuery(query);
            LeccionarioHora resultLeccionarioHora = queryFinal.getSingleResult();
            
            if(resultLeccionarioHora.getHora().getIdHora()!=null && resultLeccionarioHora.getLeccionario().getIdLeccionario()!=null )
            {
            json = Json.createObjectBuilder()
                        .add("success", true)
                        .add("idProfesor", resultLeccionarioHora.getIdProfesor().getIdProfesor())
                        .add("idInstructor",resultLeccionarioHora.getLeccionario().getIdInstructor().getIdInstructor())
                        .build();
            }
            else {
                json = Json.createObjectBuilder()
                        .add("success", false)
                        .add("error", false)
                        .build();
            }
            }
         catch (NoResultException e) {
            json = Json.createObjectBuilder()
                        .add("success", false)
                        .add("error", false)
                        .build();
        }
        catch (Exception e) {
            json = Json.createObjectBuilder()
                        .add("success", false)
                        .add("error", true)
                        .add("description", e.getMessage())
                        .build();
        }
        return json.toString();
      }
}