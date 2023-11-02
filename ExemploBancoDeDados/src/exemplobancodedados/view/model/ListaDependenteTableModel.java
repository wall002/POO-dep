package exemplobancodedados.view.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.DependenteController;

public class ListaDependenteTableModel extends AbstractTableModel{
	private List<String[]> dadosDependentes;
    private String[] titulos;

    public ListaDependenteTableModel(){
        titulos = new String[]{"CodigoDoFuncionario", "Nome", "Mesada"};
        dadosDependentes = new DependenteController().listarDependentes();
    }

    public ListaDependenteTableModel(List<String[]> dadosDependentes){
        titulos = new String[]{"CodigoDoFuncionario","Nome","Mesada"};
        this.dadosDependentes = dadosDependentes;
    }
    
    @Override
    public int getRowCount() {
        return dadosDependentes.size();
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
        String[] dadosDependente = dadosDependentes.get(rowIndex);        
        switch (columnIndex) {
            case 0: return dadosDependente[1];
            case 1: return dadosDependente[2];
            case 2: return dadosDependente[3];
            default:
                System.out.println("Erro ao apresentar os dados");
        }
        return "";
    }
}
