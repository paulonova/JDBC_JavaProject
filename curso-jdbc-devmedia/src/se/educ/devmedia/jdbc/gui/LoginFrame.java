package se.educ.devmedia.jdbc.gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import se.educ.devmedia.jdbc.bo.LoginBO;
import se.educ.devmedia.jdbc.dto.LoginDTO;
import se.educ.devmedia.jdbc.exception.BusinessException;
import se.educ.devmedia.jdbc.util.UsefulMessage;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private JPanel contentPane;
	private JButton btnExit;
	private JButton btnLogin;
	private JPasswordField passField;
	private JTextField textUsername;

	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Button Login:
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setName(textUsername.getText());
				loginDTO.setPassword(passField.getSelectedText()); 
				
				LoginBO loginBO = new LoginBO();
				boolean getBack = false;
				
				try {
					if (getBack = loginBO.Login(loginDTO)){
						UsefulMessage.addMsg(LoginFrame.this, "Login successfully!"); 
					}else {
						UsefulMessage.addMsg(LoginFrame.this, "Login failed!"); 
					}
					
				} catch (BusinessException e1) {
					e1.printStackTrace();
					UsefulMessage.addMsg(LoginFrame.this, e1.getMessage());
				}
				
				
			}
		});
		
		// Button Out
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnExit.addActionListener(new ActionListener() {					// Listener
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); 
			}
		});
		
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(266)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, Alignment.TRAILING)
						.addComponent(btnLogin, Alignment.TRAILING))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnLogin, btnExit});
		
		JLabel lblLogin = new JLabel("Username:");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		passField = new JPasswordField();
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblLogin))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textUsername)
						.addComponent(passField, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogin)
						.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addGap(1)
							.addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPassword))
					.addGap(40))
		);
		panelLogin.setLayout(gl_panelLogin);
		contentPane.setLayout(gl_contentPane);
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
