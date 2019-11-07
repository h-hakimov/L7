/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DON
 */
@Local
public interface SALGRADEFacadeLocal {

    void create(SALGRADE sALGRADE);

    void edit(SALGRADE sALGRADE);

    void remove(SALGRADE sALGRADE);

    SALGRADE find(Object id);

    List<SALGRADE> findAll();

    List<SALGRADE> findRange(int[] range);

    int count();
    
}
