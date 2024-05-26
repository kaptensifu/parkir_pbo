/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdataparkir.dataparkirDAO;
import DAOImplement.dataparkirimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Acer
 */
public class dataparkircontroller {
    MainView frame;
    dataparkirimplement impldataparkir;
    List<dataparkir> dp;
    
    public dataparkircontroller(MainView frame){
        this.frame = frame;
        impldataparkir = new dataparkirDAO();
        dp = impldataparkir.getAll();
        
    }
    public void isitabel(){
        dp = impldataparkir.getAll();
        tabel_dataparkir mp = new tabel_dataparkir(dp);
        frame.getTabel().setModel(mp);
    }
    
    public void insert(){
        dataparkir dp = new dataparkir();
        dp.setJenis(frame.getJenis().getText());
        
        dp.setLama(Double.parseDouble(frame.getLama().getText()));
        dp.setPlat(frame.getPlat().getText());
        impldataparkir.insert(dp);
    }
    
    public void update(){
        dataparkir dp = new dataparkir();
        dp.setJenis(frame.getJenis().getText());
        
        dp.setLama(Double.parseDouble(frame.getLama().getText()));
        dp.setPlat(frame.getPlat().getText());
        dp.setId(Integer.parseInt(frame.getId().getText()));
        impldataparkir.update(dp);
        
    }
    
    public void delete(){
        dataparkir dp = new dataparkir();
        dp.setId(Integer.parseInt(frame.getId().getText()));
        impldataparkir.delete(dp);
    }
}
