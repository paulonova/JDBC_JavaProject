package se.educ.devmedia.jdbc.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.educ.devmedia.jdbc.bo.PessoaBO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.util.UsefulMessage;

import javax.swing.JTable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 7973973234717597809L;
	private JTabbedPane mainTabbedPane;
	private JLabel lblSexo;
	private JRadioButton rbtFeminino;
	private JRadioButton rbtMasculino;
	private JLabel lblEndereco;
	private JTextField txtEndereco;
	private JLabel lblCpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelListagem;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JTable tableListagem;
	private JLabel lblNasc;
	private JTextField txtNasc;
	private JScrollPane scrollList;

	
	private JPanel panelCadastro;
	private JTextField txtCpf;
	private ButtonGroup grpSexo = new ButtonGroup();
	// Data Formatter..
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				//inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super("Principal");
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Principal");
			{
				mainTabbedPane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTabbedPane.addTab("Register", null, panelCadastro, null);
					panelCadastro.setPreferredSize(new java.awt.Dimension(444, 262));
					{
						lblNome = new JLabel();
						lblNome.setText("Name:");
					}
					{
						txtNome = new JTextField();
					}
					{
						txtEndereco = new JTextField();
					}
					{
						lblEndereco = new JLabel();
						lblEndereco.setText("Adress:");
					}
					{
						txtCpf = new JTextField();
					}
					{
						lblCpf = new JLabel();
						lblCpf.setText("CPF:");
					}
					panelCadastroLayout.setHorizontalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addComponent(getJLabel1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblEndereco, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblCpf, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblNome, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 91, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 91, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 91, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 91, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getRbtMasculino(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						        .addGroup(panelCadastroLayout.createParallelGroup()
						            .addComponent(getJRadioButton1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						            .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						                .addGap(0, 0, Short.MAX_VALUE)
						                .addComponent(getBtnCadastrar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						                .addGap(11)))
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap());
					panelCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblCpf, lblNome, lblEndereco});
					panelCadastroLayout.setVerticalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(txtEndereco, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblEndereco, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getRbtMasculino(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, 16));
				}
				
				
				{
					panelListagem = new JPanel();
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagem.setLayout(panelListagemLayout);
					mainTabbedPane.addTab("Listing", null, panelListagem, null);
					panelListagem.setPreferredSize(new java.awt.Dimension(223, 207));
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollList(), 0, 422, Short.MAX_VALUE)
						.addContainerGap());
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollList(), GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE) 
						.addContainerGap(214, Short.MAX_VALUE));
				}
				
				
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(19, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 449, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(491, 364);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JRadioButton getRbtMasculino() {
		if(rbtMasculino == null) {
			rbtMasculino = new JRadioButton();
			rbtMasculino.setText("Man");
			rbtMasculino.setSelected(true);
			getGrpSexo().add(rbtMasculino);
		}
		return rbtMasculino;
	}
	
	private JRadioButton getJRadioButton1() {
		if(rbtFeminino == null) {
			rbtFeminino = new JRadioButton();
			rbtFeminino.setText("Women");
			getGrpSexo().add(rbtFeminino);
		}
		return rbtFeminino;
	}
	
	private JLabel getJLabel1() {
		if(lblSexo == null) {
			lblSexo = new JLabel();
			lblSexo.setText("Gender:");
		}
		return lblSexo;
	}
	
	private ButtonGroup getGrpSexo() {
		if(grpSexo == null) {
			grpSexo = new ButtonGroup();
		}
		return grpSexo;
	}
	
	private JTextField getJTextField1() {
		if(txtNasc == null) {
			txtNasc = new JTextField();
		}
		return txtNasc;
	}
	
	private JLabel getJLabel1x() {
		if(lblNasc == null) {
			lblNasc = new JLabel();
			lblNasc.setText("Birth:");
		}
		return lblNasc;
	}
	
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setText("Clear");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtNome.setText("");
					txtCpf.setText("");
					txtEndereco.setText("");
					txtNasc.setText("");
					rbtMasculino.setSelected(true);
				}
			});
		}
		return btnLimpar;
	}
	
	private JButton getBtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setText("Register");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					try {
						pessoaDTO.setNome(txtNome.getText());
						pessoaDTO.setEndereco(txtEndereco.getText());
						pessoaDTO.setCpf(Long.parseLong(txtCpf.getText()));

						String nasc = txtNasc.getText();
						pessoaDTO.setDtNasc(dateFormat.parse(nasc));
						char sexo = rbtMasculino.isSelected() ? 'M' : 'F';
						pessoaDTO.setSexo(sexo);

						PessoaBO pessoaBO = new PessoaBO();
						pessoaBO.cadastrar(pessoaDTO);
						UsefulMessage.addMsg(MainFrame.this, "Done successfully record!");
					} catch (Exception e) {
						e.printStackTrace();
						UsefulMessage.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnCadastrar;
	}


	// Table Listing..
	
	private JTable getTableListagem() {
		
		PessoaBO pessoaBO = new PessoaBO();
		
		try {
			String[][] list = pessoaBO.listing();
			if(tableListagem == null) {
				
				TableModel tableListagemModel = new DefaultTableModel(
								//new String[][] { { "One", "Two" }, { "Three", "Four" } },
								list,
								new String[] { "ID", "Name", "CPF", "Adress", "Gender", "Birth" });
				tableListagem = new JTable();
				tableListagem.setModel(tableListagemModel);
			}
			return tableListagem;
			
		} catch (Exception e) {
			e.printStackTrace();
			UsefulMessage.addMsg(MainFrame.this, e.getMessage());
		}
		
		return null;
	}
	
	private JScrollPane getScrollList(){
		if(scrollList == null){
			scrollList = new JScrollPane();
			scrollList.setViewportView(getTableListagem()); 
		}
		
		
		return scrollList;
		
	}

	
}

