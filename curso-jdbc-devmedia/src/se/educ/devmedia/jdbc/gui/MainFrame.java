package se.educ.devmedia.jdbc.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import se.educ.devmedia.jdbc.bo.PessoaBO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.util.UsefulMessage;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MainFrame extends JFrame {

	
	private static final long serialVersionUID = 3202592430054659065L;
	private JPanel contentPane;
	private JPanel panelCadastro;
	private JPanel panelList;
	private JTextField txtName;
	private JTextField txtCpf;
	private JTextField txtAdress;
	private final ButtonGroup grpSexo = new ButtonGroup();
	private JTextField txtDtNascimento;
	
	// Data Formatter..
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		super("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(mainTabbedPane, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(mainTabbedPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		
		panelCadastro = new JPanel();
		panelCadastro.setForeground(Color.BLACK);
		panelCadastro.setToolTipText("");
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		mainTabbedPane.addTab("Register", null, panelCadastro, null);
		mainTabbedPane.setEnabledAt(0, true);
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name: ");
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblCpf = DefaultComponentFactory.getInstance().createLabel("Cpf: ");
		
		JLabel lblAdress = DefaultComponentFactory.getInstance().createLabel("Adress: ");
		
		JLabel dtNacimento = DefaultComponentFactory.getInstance().createLabel("Birth: ");
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		txtAdress = new JTextField();
		txtAdress.setColumns(10);
		
		JRadioButton rbtMasc = new JRadioButton("Man");
		rbtMasc.setSelected(true);
		grpSexo.add(rbtMasc);
		
		JRadioButton rbtFem = new JRadioButton("Women");
		grpSexo.add(rbtFem);
		
		JLabel lblGender = DefaultComponentFactory.getInstance().createLabel("Gender: ");
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setColumns(10);
		
		// Button Register
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				try {
					pessoaDTO.setNome(txtName.getText());
					pessoaDTO.setEndereco(txtAdress.getText());
					pessoaDTO.setCpf(Long.parseLong(txtCpf.getText()));

					String nasc = txtDtNascimento.getText();				
					pessoaDTO.setDtNasc(dateFormat.parse(nasc));				

					char sexo = rbtMasc.isSelected() ? 'M' : 'W';
					pessoaDTO.setSexo(sexo);

					PessoaBO pessoaBO = new PessoaBO();
					pessoaBO.cadastrar(pessoaDTO); 
					UsefulMessage.addMsg(MainFrame.this, "Register made successfully..");

				} catch (Exception e1) {
					e1.printStackTrace();
					UsefulMessage.addMsg(MainFrame.this, e1.getMessage());
				}

			}
		});
		
		//Button Clear
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText(""); 
				txtCpf.setText("");
				txtAdress.setText("");
				txtDtNascimento.setText("");
				rbtMasc.setSelected(true);
								
			}
		});
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panelCadastro.createSequentialGroup()
								.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
									.addComponent(lblName)
									.addComponent(lblCpf))
								.addGap(24)
								.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtName)
									.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
							.addGroup(gl_panelCadastro.createSequentialGroup()
								.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
									.addComponent(lblAdress)
									.addComponent(dtNacimento))
								.addGap(18)
								.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
									.addComponent(txtDtNascimento, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtAdress))))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblGender)
							.addGap(76)
							.addComponent(rbtMasc)
							.addGap(86)
							.addComponent(rbtFem)))
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addContainerGap(295, Short.MAX_VALUE)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegister)
					.addContainerGap())
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress)
						.addComponent(txtAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(rbtMasc)
						.addComponent(rbtFem))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDtNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtNacimento))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnClear))
					.addContainerGap())
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		
		
		
		
		panelList = new JPanel();
		mainTabbedPane.addTab("Listing", null, panelList, null);
		GroupLayout groupLayout_1 = new GroupLayout(panelList);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 571, Short.MAX_VALUE)
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 276, Short.MAX_VALUE)
		);
		panelList.setLayout(groupLayout_1);
		contentPane.setLayout(gl_contentPane);
	}
}
