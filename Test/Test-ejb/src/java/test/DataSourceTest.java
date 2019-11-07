/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DON
 */
@Stateless
public class DataSourceTest implements DataSourceTestLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static DataSource getDataSource(){
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/oracle");
            return ds;
        } catch (NamingException ex) {
            Logger.getLogger(DataSourceTest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
