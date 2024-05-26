/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Acer
 */
public interface dataparkirimplement {
    public void insert(dataparkir p);
    public void update(dataparkir p);
    public void delete(dataparkir p);
    public List<dataparkir>getAll();
}
