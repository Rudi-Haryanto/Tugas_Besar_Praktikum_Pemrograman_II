package view.sorum;

import javax.swing.table.*;
import java.util.List;
import model.Sorum;

public class SorumTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nama Pembeli", "Alamat", "Jenis Mobil", "Merek Mobil", "Nama mobil" };
    private List<Sorum> data;

    public SorumTableModel(List<Sorum> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Sorum rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNamapem();
                break;
            case 1:
                value = rowItem.getAlamat();
                break;
            case 2:
                value = rowItem.getJenismot();
                break;
            case 3:
                value = rowItem.getMermo().getMerekmobil();
                break;
            case 4:
                value = rowItem.getNamot().getNamamobil();
                break;
            case 5:
                value = rowItem.getId();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Sorum value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void remove(int value) {
        data.remove(value);
        fireTableRowsDeleted(data.size() - 1, data.size() - 1);
    }
}
