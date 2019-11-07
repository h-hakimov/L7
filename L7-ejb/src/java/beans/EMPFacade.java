/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
    
}
