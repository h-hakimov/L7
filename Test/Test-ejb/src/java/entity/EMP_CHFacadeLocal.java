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
public interface EMP_CHFacadeLocal {

    void create(EMP_CH eMP_CH);

    void edit(EMP_CH eMP_CH);

    void remove(EMP_CH eMP_CH);

    EMP_CH find(Object id);

    List<EMP_CH> findAll();

    List<EMP_CH> findRange(int[] range);

    int count();
    
}
