/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

import java.util.ArrayList;

/**
 * @author Mirae Yu 
 * @author Tumurtulga Batjargal
 */
public interface DataInputInterface {
    
    public ArrayList<String> inputData() throws ClassNotFoundException, InstantiationException, IllegalAccessException;
    
}
