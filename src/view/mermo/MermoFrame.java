package view.mermo;

import model.Mermo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MermoFrame extends JFrame {
    private List<Mermo> mermoList;
    private final JTextField textFieldMermo;
    private MermoTableModel tableModel;
    private final JTable table;
    private final JButton buttonSimpan;
    private final JButton buttonDelete;
    private ImageIcon carIcon;
    private JLabel myLabel;

    public MermoFrame() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tampilan Background >>>>
        carIcon = new ImageIcon(this.getClass().getResource("../bgmobil.png"));
        myLabel = new JLabel(carIcon);
        myLabel.setSize(1360, 800);
        // Tampilan Background <<<<

        // CSS Java untuk title apk dan icon
        this.setTitle("<< Aplikasi FRECS-Showroom Nota >>");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../mobil.png")));

        JLabel labelTitlee1 = new JLabel(" Halaman Inputan Merek Mobil ");
        labelTitlee1.setBounds(110, 15, 350, 10);
        labelTitlee1.setForeground(Color.white);

        JLabel labelInput = new JLabel("Merek Mobil :");
        labelInput.setForeground(Color.WHITE);
        labelInput.setBounds(15, 280, 350, 10);
        textFieldMermo = new JTextField();
        textFieldMermo.setBounds(15, 300, 350, 30);
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 340, 100, 40);
        buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(130, 340, 100, 40);
        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 40, 350, 200);

        this.add(buttonSimpan);
        this.add(buttonDelete);
        this.add(textFieldMermo);
        this.add(labelInput);
        this.add(scrollableTable);
        this.add(labelTitlee1);
        this.add(myLabel);

        this.setSize(400, 700);
        this.setLayout(null);
    }

    public String getJenis() {
        return textFieldMermo.getText();
    }

    public void addMerekmobil(Mermo merekmobil) {
        tableModel.add(merekmobil);
        textFieldMermo.setText("");
    }

    public String takeMermo() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }

        if (selection.length > 0) {
            String merekmobil = (String) tableModel.getValueAt(selection[0], 1);
            return merekmobil;
        } else {
            return "";
        }
    }

    public void deleteMermo() {
        int[] selection = table.getSelectedRows();
        for (int i = 0; i < selection.length; i++) {
            selection[i] = table.convertRowIndexToModel(selection[i]);
        }
        tableModel.remove(selection[0]);
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        buttonSimpan.addActionListener(actionListener);
    }

    public void addButtonDeleteActionListener(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }

    public void populateMermoTable(List<Mermo> mermoList) {
        this.mermoList = mermoList;
        tableModel = new MermoTableModel(mermoList);
        table.setModel(tableModel);
    }
}