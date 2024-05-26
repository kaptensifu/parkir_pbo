/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Acer
 */
public class tabel_dataparkir extends AbstractTableModel{

    List<dataparkir> dp;
    public tabel_dataparkir(List<dataparkir>dp){
        this. dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Jenis";
            case 2:
                return "Lama (jam)";
            case 3:
                return "Plat Nomor";
            default:
                return null;
            
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getJenis();
            case 2:
                return dp.get(row).getLama();
            case 3:
                return dp.get(row).getPlat();
            
            default:
                return null;
            
        }
    }
    
}
