/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Instructor;
import entities.Persona;
import entities.Persona_;
import entities.Profesor;
import entities.Usuario;
import entities.Usuario_;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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

/**
 *
 * @author edito
 */
@Stateless
@Path("entities.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "LeccionarioV3PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String loginREST(JsonObject user) {
        JsonObject json = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);
            query.select(root);
            Join<Persona, Instructor> instructor = root.join(Usuario_.persona, JoinType.LEFT).join(Persona_.instructor, JoinType.LEFT);
            Join<Persona, Profesor> profesor = root.join(Usuario_.persona, JoinType.LEFT).join(Persona_.profesor, JoinType.LEFT);

            query.where(cb.and(cb.equal(root.get(Usuario_.nombreUsuario), user.getString("username"))),
                    cb.equal(root.get(Usuario_.claveUsuario), user.getString("password")));
            
            //query.
            TypedQuery<Usuario> queryFinal = em.createQuery(query);
            Usuario resultUsuario = queryFinal.getSingleResult();

            if (resultUsuario.getPersona().getInstructor() != null) {
                json = Json.createObjectBuilder()
                        .add("success", true)
                        .add("idUsuario", resultUsuario.getIdUsuario())
                        .add("rol", 1)
                        .build();
            } else if (resultUsuario.getPersona().getProfesor() != null) {
                json = Json.createObjectBuilder()
                        .add("success", true)
                        .add("idUsuario", resultUsuario.getIdUsuario())
                        .add("rol", 2)
                        .build();
            } else {
                json = Json.createObjectBuilder()
                        .add("success", false)
                        .add("description", "No se encontraron coincidencias")
                        .build();
            }

        } 
        catch (NoResultException e) {
            json = Json.createObjectBuilder()
                        .add("success", false)
                        .add("description", "No se encontraron coincidencias")
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
