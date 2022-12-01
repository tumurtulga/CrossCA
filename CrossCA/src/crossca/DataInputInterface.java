/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.List;

/**
 *
 * @author deece
 */
public interface DataInputInterface {
    
    public List<User> inputData() throws ClassNotFoundException, InstantiationException, IllegalAccessException;
    
}
