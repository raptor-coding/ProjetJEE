/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.gestionnaire;

import chambres.modeles.Chambre;
import clients.modeles.Client;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jux
 */
@Stateless
public class GestionnaireClients {
    
    @PersistenceContext  
    private EntityManager em;
    
    
    public Client creeClient(String nom, String prenom, String heureArrivee, LocalDate jourArrivee, String chambre, LocalDate jourDepart, boolean aPaye, boolean estArrive) {  
        Client c = new Client(nom, prenom, heureArrivee, jourArrivee, jourDepart, aPaye, estArrive); 
        Collection<Chambre> chambres;
        
        Query q = em.createQuery("SELECT u FROM CHAMBRE u WHERE u.chambre ='"+chambre+"'");  
        q.getResultList(); 
        
        //chambres.add((Chambre) );
        c.setChambres((List<Chambre>) q.getResultList().get(0));
        
        em.persist(c);
        return c;  
    }
    
    public Collection<Client> getClientsCurrentlyInHouse() {    
        Query q = em.createQuery("");  
        return q.getResultList();  
    }
}
