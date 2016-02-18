/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author edito
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.CursoFacadeREST.class);
        resources.add(service.EstudianteFacadeREST.class);
        resources.add(service.HoraFacadeREST.class);
        resources.add(service.IncidenciaFacadeREST.class);
        resources.add(service.InstructorFacadeREST.class);
        resources.add(service.LHoraIncidenciaEstudianteFacadeREST.class);
        resources.add(service.LeccionarioFacadeREST.class);
        resources.add(service.LeccionarioHoraFacadeREST.class);
        resources.add(service.MateriaFacadeREST.class);
        resources.add(service.PersonaFacadeREST.class);
        resources.add(service.ProfesorFacadeREST.class);
        resources.add(service.TemaFacadeREST.class);
        resources.add(service.UsuarioFacadeREST.class);
    }
    
}
