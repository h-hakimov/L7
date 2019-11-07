/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DON
 */
@Stateless
public class EMP_CHFacade extends AbstractFacade<EMP_CH> implements EMP_CHFacadeLocal {

    @PersistenceContext(unitName = "Test-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EMP_CHFacade() {
        super(EMP_CH.class);
    }
    
}
