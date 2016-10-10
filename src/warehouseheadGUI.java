import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.TextField;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import java.awt.Choice;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTree;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.TextArea;
import java.awt.List;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import javax.swing.JList;
import java.awt.Panel;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.*;

public class warehouseheadGUI extends JFrame {

   private JPanel contentPane;
   private JTable table;
   private JTable table_1;
   private JTable table_2;
   private JTable table_3;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               warehouseheadGUI frame = new warehouseheadGUI();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   
   
   
   public warehouseheadGUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(-8, -111, 822, 479);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Warehouse Head Management");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel.setBounds(12, 10, 256, 19);
      contentPane.add(lblNewLabel);
      
      JLabel timeLabel = new JLabel("접속시간 : " + new Date().toString());
      timeLabel.setBounds(386, 10, 251, 15);
      contentPane.add(timeLabel);
      
   
      
      

      //warehouse 부분 시작
      JLabel lblWarehouseInfo = new JLabel("Warehouse Info");
      lblWarehouseInfo.setFont(new Font("굴림", Font.PLAIN, 13));
      lblWarehouseInfo.setBounds(12, 36, 99, 16);
      contentPane.add(lblWarehouseInfo);
      
      JButton btnShowStorageList = new JButton("Show Detail");
      btnShowStorageList.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      btnShowStorageList.setBounds(215, 193, 120, 23);
      contentPane.add(btnShowStorageList);
      
      String[] columnNames_warehouse = {"Warehouse", "ID", "x", "y"};
      Object[][] data_warehouse = { { "A 창고", "1001", new Double(87.4), new Double(44.2) },
            { "B 창고", "1002", new Double(37.0), new Double(60.1)} };
      JTable warehouse_Table = new JTable(data_warehouse, columnNames_warehouse) {

         @Override

         public boolean isCellEditable(int row, int column) {

            return false;

         }

      };
      
      
      
      
      table_1 = new JTable(data_warehouse, columnNames_warehouse);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(12, 62, 323, 121);
      contentPane.add(scrollPane_1);
      scrollPane_1.setViewportView(table_1);
      //warehouse 부분 끝
      
      //store 부분 시작
      JLabel lblStoreInfo = new JLabel("Store Info");
      lblStoreInfo.setFont(new Font("굴림", Font.PLAIN, 13));
      lblStoreInfo.setBounds(425, 35, 59, 16);
      contentPane.add(lblStoreInfo);
      
      String[] columnNames_store = {"Store", "ID", "x", "y"};
      Object[][] data_store = { { "A 가게", "2001", new Double(92.5), new Double(45.0) },
            { "B 가게", "2002", new Double(28.1), new Double(11.8)} };
      table_2 = new JTable(data_store, columnNames_store);
         
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(425, 62, 343, 121);
      contentPane.add(scrollPane_2);
      scrollPane_2.setViewportView(table_2);
      
      JButton button = new JButton("Show Detail");
      button.setBounds(648, 193, 120, 23);
      contentPane.add(button);
      //store 부분 끝
      
      //Request 부분 시작
      JLabel lblRequest = new JLabel("Request");
      lblRequest.setFont(new Font("굴림", Font.PLAIN, 14));
      lblRequest.setBounds(12, 222, 54, 17);
      contentPane.add(lblRequest);
      
      String[] columnNames_request = {"가게", "물품", "수량","접수"};
      Object[][] data_request = { { "A", "A", new Integer(150), "Pending"},
            { "B", new Integer(70), new Integer(200), "Confirmed"} };
      table_3 = new JTable(data_request, columnNames_request);
      
      JScrollPane scrollPane_3 = new JScrollPane(table_3);
      scrollPane_3.setBounds(12, 249, 756, 155);
      contentPane.add(scrollPane_3);
      
      JButton btnNewButton = new JButton("\uAC1C\uBCC4\uC120\uD0DD");
      btnNewButton.setBounds(655, 407, 113, 23);
      contentPane.add(btnNewButton);
      
      JButton button_1 = new JButton("\uC77C\uAD04\uC120\uD0DD");
      button_1.setBounds(530, 407, 113, 23);
      contentPane.add(button_1);
      //Request 부분 끝   
   }
}