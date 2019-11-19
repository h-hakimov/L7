/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DON
 */
@Stateless
public class EMPFacade extends AbstractFacade<EMP> implements EMPFacadeLocal {

    @PersistenceContext(unitName = "L7-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EMPFacade() {
        super(EMP.class);
    }
    
    @Override
    public List<EMP> findByName(String name){
        name = name + "%";
        String query = "SELECT c FROM EMP c WHERE c.name LIKE :custName";
        return getEntityManager().createQuery(query).setParameter("custName", name).getResultList();
    }
}
