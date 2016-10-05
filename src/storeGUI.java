import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class storeGUI extends JFrame {
	private JPanel contentPane;
	private JTable stockTable, transTable;
	private JScrollPane stockScroll, transScroll;
	private JPanel stockPanel, transPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					storeGUI frame = new storeGUI();
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
	public storeGUI() {
		setTitle("Store Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel timeLabel = new JLabel("접속시간 : "+new Date().toString());
		timeLabel.setBounds(386, 10, 251, 15);
		contentPane.add(timeLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 10, 625, 359);
		contentPane.add(tabbedPane);
		
		//재고관리 탭 패널
		stockPanel = new JPanel();
		tabbedPane.addTab("재고관리", null, stockPanel, null);
		stockPanel.setLayout(null);
		String[] stockColumnNames = {"물품명", "재고량", "최대 수용가능수량", "최소 유지재고수량"};
		Object[][] stockData = {{"A", new Integer(50), new Integer(100), new Integer(20)}, {"B", new Integer(70), new Integer(150), new Integer(50)}};
		stockTable = new JTable(stockData, stockColumnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		stockTable.setFocusable(false);
		stockTable.setRowSelectionAllowed(true);
		stockScroll = new JScrollPane(stockTable);
		stockScroll.setBounds(0, 0, 620, 265);
		
		stockPanel.add(stockScroll);
		
		JButton btnModifyStock = new JButton("재고량 수정");
		btnModifyStock.setBounds(170, 275, 116, 23);
		stockPanel.add(btnModifyStock);
		
		JButton btnModifyMaxMin = new JButton("최대/최소 수량 편집");
		btnModifyMaxMin.setBounds(333, 275, 173, 23);
		stockPanel.add(btnModifyMaxMin);
		
		
		//주문관리 탭 패널
		transPanel = new JPanel();
		tabbedPane.addTab("주문관리", null, transPanel, null);
		transPanel.setLayout(null);
		
		String[] transColumnNames = {"창고명", "물품명", "운송량", "운송비", "발송여부"};
		Object[][] transData = {{"A창고", "A", new Integer(50), new Integer(30000), new Boolean(false)}};
		transTable = new JTable(transData, transColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		transScroll = new JScrollPane(transTable);
		transScroll.setBounds(12, 46, 596, 238);
		transPanel.add(transScroll);
		
		JButton btnReceived = new JButton("수령완료");
		btnReceived.setBounds(486, 294, 122, 23);
		transPanel.add(btnReceived);
		
		JButton btnNew = new JButton("새로 주문하기");
		btnNew.setBounds(12, 10, 140, 23);
		transPanel.add(btnNew);
		
		JButton btnCancle = new JButton("주문취소");
		btnCancle.setBounds(164, 10, 114, 23);
		transPanel.add(btnCancle);
	}
}
