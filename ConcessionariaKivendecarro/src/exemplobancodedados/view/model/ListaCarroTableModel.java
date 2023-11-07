package exemplobancodedados.view.model;

import control.CarroController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaCarroTableModel extends AbstractTableModel{

    private List<String[]> dadosCarros;
    private String[] titulos;

    public ListaCarroTableModel(){
        titulos = new String[]{"Placa", "Modelo", "Ano", "Cor"};
        dadosCarros = new CarroController().listarCarros();
    }

    public ListaCarroTableModel(List<String[]> dadosCarros){
        titulos = new String[]{"Placa", "Modelo", "Ano", "Cor"};
        this.dadosCarros = dadosCarros;
    }
    
    @Override
    public int getRowCount() {
        return dadosCarros.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] dadosCarro = dadosCarros.get(rowIndex);        
        switch (columnIndex) {
            case 0: return dadosCarro[0];
            case 1: return dadosCarro[1];
            case 2: return dadosCarro[2];
            case 3: return dadosCarro[3];
            default:
                System.out.println("Erro ao apresentar os dados");
        }
        return "";
    }
        
}
