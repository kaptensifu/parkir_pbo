/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataparkir;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.dataparkirimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer
 */
public class dataparkirDAO implements dataparkirimplement{

    Connection connection;
    
    final String select = "SELECT * FROM parkir;";
    final String insert = "INSERT INTO parkir ( jenis, lama, plat) VALUES ( ?, ?, ?);";
    final String update = "UPDATE parkir set jenis=?, lama=?, plat=? WHERE id=?;";
    final String delete = "DELETE FROM `parkir` WHERE id=?";
    public dataparkirDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(dataparkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement .RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJenis());
            statement.setDouble(2, p.getLama());
            statement.setString(3, p.getPlat());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataparkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJenis());
            statement.setDouble(2, p.getLama());
            statement.setString(3, p.getPlat());
            
            statement.setInt(4, p.getId());
            statement.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(dataparkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public List<dataparkir> getAll() {
        List<dataparkir> dp = null;
        try{
            dp = new ArrayList<dataparkir>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataparkir parkir = new dataparkir();
                parkir.setId(rs.getInt("id"));
                parkir.setJenis(rs.getString("jenis"));
                parkir.setLama(rs.getDouble("lama"));
                parkir.setPlat(rs.getString("plat"));
                
                dp.add(parkir);
            }
        }catch(SQLException ex){
            Logger.getLogger(dataparkirDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return dp;
    }
    
}
