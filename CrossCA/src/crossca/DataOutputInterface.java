/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

/**
 * @author Mirae Yu 
 * @author Tumurtulga Batjargal
 */
public interface DataOutputInterface {

    public boolean outputSetup() throws ClassNotFoundException, InstantiationException, IllegalAccessException;

    public boolean outputData(UserDB user) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

}
