/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Materia;
import entities.Materia_;
import entities.Tema;
import entities.Tema_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author edito
 */
@Stateless
@Path("entities.tema")
public class TemaFacadeREST extends AbstractFacade<Tema> {
    @PersistenceContext(unitName = "LeccionarioV3PU")
    private EntityManager em;

    public TemaFacadeREST() {
        super(Tema.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Tema entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Tema entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Tema find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Tema> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Tema> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    //tengo duda siempre me llega vacio y existe,ya no se q hacer
    @POST
    @Path("adicionarTema")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String adicionarTema(JsonObject tema) {
       
       
        JsonObject json = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tema> query = cb.createQuery(Tema.class);
            Root<Tema> root = query.from(Tema.class);
            query.select(root);
            root.join(Tema_.idMateria,JoinType.LEFT).join(Materia_.idMateria,JoinType.LEFT);
             
            query.where(cb.equal(root.get(Tema_.idMateria),tema.getString("idMateria")));
                    //cb.equal(root.get(Tema_.idTema), tema.getString("IdTema")));
          
            TypedQuery<Tema> queryFinal = em.createQuery(query);
            Tema resultTema = queryFinal.getSingleResult();
            
            if(resultTema.getIdTema()!=null)
            {
            json = Json.createObjectBuilder()
                        .add("success", true)
                        .add("nombreTema", resultTema.getNombreTema())
                        .add("idTema",resultTema.getNombreTema() )
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
