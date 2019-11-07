/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DON
 */
@Local
public interface DEPTFacadeLocal {

    void create(DEPT dEPT);

    void edit(DEPT dEPT);

    void remove(DEPT dEPT);

    DEPT find(Object id);

    List<DEPT> findAll();

    List<DEPT> findRange(int[] range);

    int count();
    
}
