package exemplobancodedados.view.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.CompradorController;

public class ListaCompradorTableModel extends AbstractTableModel{
	private List<String[]> dadosCompradores;
    private String[] titulos;

    public ListaCompradorTableModel(){
        titulos = new String[]{"Nome", "Cpf", "Placa do Carro"};
        dadosCompradores = new CompradorController().listarCompradores();
    }

    public ListaCompradorTableModel(List<String[]> dadosCompradores){
        titulos = new String[]{"Nome", "Cpf", "Placa_Carro"};
        this.dadosCompradores = dadosCompradores;
    }
    
    @Override
    public int getRowCount() {
        return dadosCompradores.size();
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
        String[] dadosComprador = dadosCompradores.get(rowIndex);        
        switch (columnIndex) {
            case 0: return dadosComprador[1];
            case 1: return dadosComprador[2];
            case 2: return dadosComprador[3];
            default:
                System.out.println("Erro ao apresentar os dados");
        }
        return "";
    }
}
