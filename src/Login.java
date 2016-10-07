import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {
	private class Account { // 계정 클래스
		private String id;
		private String pw;

		public Account(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}

		public String getId() {
			return id;
		}

		public String getPw() {
			return pw;
		}
	}

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblUserAuthorisationRequired;
	private boolean isFileExist;
	private String inputId;
	private String inputPw;
	private String tmpId;
	private String tmpPw;
	private BufferedReader in;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setSize(294, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(32, 64, 20, 15);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 95, 69, 15);
		contentPane.add(lblPassword);

		idField = new JTextField();
		idField.setBounds(106, 61, 142, 21);
		contentPane.add(idField);
		idField.setColumns(10);

		btnNewButton = new JButton("Proceed");
		btnNewButton.setBounds(92, 123, 89, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		lblUserAuthorisationRequired = new JLabel("User authorisation required");
		lblUserAuthorisationRequired.setFont(new Font("굴림", Font.PLAIN, 16));
		lblUserAuthorisationRequired.setBounds(32, 10, 214, 28);
		contentPane.add(lblUserAuthorisationRequired);

		passwordField = new JPasswordField();
		passwordField.setBounds(106, 92, 142, 21);
		contentPane.add(passwordField);

		try {
			in = new BufferedReader(new FileReader("list.txt")); // 명단 리스트 파일
																	// 입력용 객체

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			JFrame ef = new JFrame("Error");
			ef.setVisible(true);
			ef.setSize(250, 100);
			ef.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
			ef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ef.getContentPane().setLayout(null);
			JLabel errorMessage = new JLabel("명단 파일을 찾을 수 없습니다");
			errorMessage.setBounds(30, 10, 200, 50);
			ef.getContentPane().add(errorMessage);
		}
		;

	}

	@SuppressWarnings("deprecation") // 보안 무시
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			inputId = idField.getText();
			inputPw = passwordField.getText();
			try {
				while (in.ready()) {
					tmpId = in.readLine();
					tmpPw = in.readLine();
					Account tmp = new Account(tmpId, tmpPw);
					if (inputId == tmpId && inputPw == tmpPw) {
						if (inputId == "admin") {
							// 헤드 GUI 생성 & 로그인 GUI 닫기
						} else if (inputId.charAt(0) == '1') {
							// 창고GUI 생성
						} else if (inputId.charAt(0) == '2') {
							// 가게GUI 생성
						}
					}
				}
				lblUserAuthorisationRequired.setText("Invalid ID");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
