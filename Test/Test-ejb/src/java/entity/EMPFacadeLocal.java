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
public interface EMPFacadeLocal {

    void create(EMP eMP);

    void edit(EMP eMP);

    void remove(EMP eMP);

    EMP find(Object id);

    List<EMP> findAll();

    List<EMP> findRange(int[] range);

    int count();
    
}
