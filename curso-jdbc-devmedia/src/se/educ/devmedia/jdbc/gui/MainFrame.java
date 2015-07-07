package se.educ.devmedia.jdbc.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.educ.devmedia.jdbc.bo.PessoaBO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.util.UsefulMessage;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;

public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 7973973234717597809L;
	private JTabbedPane mainTabbedPane;
	private JLabel lblSexo;
	private JRadioButton rbtFeminino;
	private JRadioButton rbtMasculino;
	private JLabel lblEndereco;
	private JTextField txtEndereco;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelListagem;
	private JPanel panelCadastro;
	private ButtonGroup grpSexo;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JPanel panelConsulta;
	private JTable tableListConsulta;
	private JPanel panelTabelaList;
	private JButton btnConsult;
	private ButtonGroup grpSexoConsulta;
	private JLabel lblSexoConsulta;
	private JRadioButton rbtMascConsulta;
	private JRadioButton rbtFemConsulta;
	private JLabel lblCpfConsulta;
	private JTextField txtCpfConsulta;
	private JLabel lblNomeConsulta;
	private JTextField txtNomeConsulta;
	private JScrollPane scrollListagem;
	private JTable tableListagem;
	private JLabel lblNasc;
	private JTextField txtNasc;
	
	// Formatter de datas
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Principal");
			{
				mainTabbedPane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTabbedPane.addTab("Cadastro", null, panelCadastro, null);
					panelCadastro.setPreferredSize(new java.awt.Dimension(444, 262));
					{
						lblNome = new JLabel();
						lblNome.setText("Nome:");
					}
					{
						txtNome = new JTextField();
					}
					{
						txtEndereco = new JTextField();
					}
					{
						lblEndereco = new JLabel();
						lblEndereco.setText("Endereço:");
					}
					{
						txtCpf = new JTextField();
					}
					{
						lblCpf = new JLabel();
						lblCpf.setText("CPF:");
					}
					panelCadastroLayout.setVerticalGroup(panelCadastroLayout.createSequentialGroup()
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 16)
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
						    .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getRbtMasculino(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getBtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(46, 46));
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
						        .addComponent(getRbtMasculino(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						        .addGroup(panelCadastroLayout.createParallelGroup()
						            .addGroup(panelCadastroLayout.createSequentialGroup()
						                .addComponent(getJRadioButton1(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						                .addGap(0, 0, Short.MAX_VALUE)
						                .addComponent(getBtnCadastrar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						                .addGap(9)))
						        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 93, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 93, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 93, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 93, Short.MAX_VALUE)))
						.addContainerGap());
					panelCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblCpf, lblNome, lblEndereco});
				}
				{
					panelListagem = new JPanel();
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagem.setLayout(panelListagemLayout);
					mainTabbedPane.addTab("Listagem", null, panelListagem, null);
					mainTabbedPane.addTab("Consulta", null, getPanelConsulta(), null);
					panelListagem.setPreferredSize(new java.awt.Dimension(223, 207));
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), 0, 234, Short.MAX_VALUE)
						.addContainerGap());
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 7, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 451, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(491, 383);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}



	
	private JRadioButton getRbtMasculino() {
		if(rbtMasculino == null) {
			rbtMasculino = new JRadioButton();
			rbtMasculino.setText("Masculino");
			rbtMasculino.setSelected(true);
			getGrpSexo().add(rbtMasculino);
		}
		return rbtMasculino;
	}
	
	private JRadioButton getJRadioButton1() {
		if(rbtFeminino == null) {
			rbtFeminino = new JRadioButton();
			rbtFeminino.setText("Feminino");
			getGrpSexo().add(rbtFeminino);
		}
		return rbtFeminino;
	}
	
	private JLabel getJLabel1() {
		if(lblSexo == null) {
			lblSexo = new JLabel();
			lblSexo.setText("Sexo:");
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
			lblNasc.setText("Dt. Nasc:");
		}
		return lblNasc;
	}
	
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setText("Limpar");
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
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					PessoaBO pessoaBO = new PessoaBO();
					try {
						String nome = txtNome.getText();
						String cpf = txtCpf.getText();
						String endereco = txtEndereco.getText();
						String nasc = txtNasc.getText();						
							
						pessoaBO.validName(nome);
						pessoaBO.validCPF(cpf);
						pessoaBO.validAdress(endereco);
						pessoaBO.validBirth(nasc);
						
						pessoaDTO.setNome(nome);
						pessoaDTO.setEndereco(endereco);						
						pessoaDTO.setCpf(Long.parseLong(cpf));
						
						pessoaDTO.setDtNasc(dateFormat.parse(nasc));
						char sexo = rbtMasculino.isSelected() ? 'M' : 'F';
						pessoaDTO.setSexo(sexo);
						
						pessoaBO.cadastrar(pessoaDTO);
						UsefulMessage.addMsg(MainFrame.this, "Record done successfully!");
						MainFrame.this.dispose();
						main(null);
					} catch (Exception e) {
						e.printStackTrace();
						UsefulMessage.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnCadastrar;
	}
	
	private JTable getTableListagem() {
		PessoaBO pessoaBO = new PessoaBO();		
		try {
			String [] [] lista = pessoaBO.listing();		
			if(tableListagem == null) {
				TableModel tableListagemModel = 
						new DefaultTableModel(
								//new String[][] { { "One", "Two" }, { "Three", "Four" } },
								lista,
								new String[] { "Id", "Name", "CPF", "Adress", "Gender", "Birth." });
				tableListagem = new JTable();
				tableListagem.setModel(tableListagemModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			UsefulMessage.addMsg(MainFrame.this, e.getMessage());
		}
		return tableListagem;
	}


	
	private JScrollPane getScrollListagem() {
		if(scrollListagem == null) {
			scrollListagem = new JScrollPane();
			scrollListagem.setViewportView(getTableListagem());
		}
		return scrollListagem;
	}

	
	private JPanel getPanelConsulta() {
		if(panelConsulta == null) {
			panelConsulta = new JPanel();
			GroupLayout panelConsultaLayout = new GroupLayout((JComponent)panelConsulta);
			panelConsulta.setLayout(panelConsultaLayout);
			panelConsulta.setPreferredSize(new java.awt.Dimension(446, 267));
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(panelConsultaLayout.createSequentialGroup()
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJLabel1xx(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(8)))
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJTextField1x(), GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
				                .addGap(24)
				                .addComponent(getJLabel1xxx(), GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				                .addGap(7))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addPreferredGap(getJTextField1x(), getJRadioButton2(), LayoutStyle.ComponentPlacement.INDENT)
				                .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                .addComponent(getJRadioButton1x(), GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJTextField1xx(), GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGap(27)
				                .addComponent(getBtnConsult(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 27, Short.MAX_VALUE)))
				        .addGap(41))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 434, Short.MAX_VALUE)));
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJLabel1xx(), getJLabel1xxx()});
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJTextField1x(), getJTextField1xx()});
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getBtnConsult(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getPanelTabelaList(), 0, 166, Short.MAX_VALUE)
				.addContainerGap());
			panelConsultaLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJLabel1xx(), getJLabel1xxx()});
			panelConsultaLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJTextField1x(), getJTextField1xx()});
		}
		return panelConsulta;
	}
	
	private JTextField getJTextField1x() {
		if(txtNomeConsulta == null) {
			txtNomeConsulta = new JTextField();
		}
		return txtNomeConsulta;
	}
	
	private JLabel getJLabel1xx() {
		if(lblNomeConsulta == null) {
			lblNomeConsulta = new JLabel();
			lblNomeConsulta.setText("Nome:");
		}
		return lblNomeConsulta;
	}
	
	private JTextField getJTextField1xx() {
		if(txtCpfConsulta == null) {
			txtCpfConsulta = new JTextField();
		}
		return txtCpfConsulta;
	}
	
	private JLabel getJLabel1xxx() {
		if(lblCpfConsulta == null) {
			lblCpfConsulta = new JLabel();
			lblCpfConsulta.setText("CPF:");
		}
		return lblCpfConsulta;
	}
	
	private JRadioButton getJRadioButton1x() {
		if(rbtFemConsulta == null) {
			rbtFemConsulta = new JRadioButton();
			rbtFemConsulta.setText("Feminino");
			getGrpSexoConsulta().add(rbtFemConsulta);
		}
		return rbtFemConsulta;
	}
	
	private JRadioButton getJRadioButton2() {
		if(rbtMascConsulta == null) {
			rbtMascConsulta = new JRadioButton();
			rbtMascConsulta.setText("Masculino");
			rbtMascConsulta.setSelected(true);
			getGrpSexoConsulta().add(rbtMascConsulta);
		}
		return rbtMascConsulta;
	}
	
	private JLabel getJLabel2() {
		if(lblSexoConsulta == null) {
			lblSexoConsulta = new JLabel();
			lblSexoConsulta.setText("Sexo:");
		}
		return lblSexoConsulta;
	}
	
	private ButtonGroup getGrpSexoConsulta() {
		if(grpSexoConsulta == null) {
			grpSexoConsulta = new ButtonGroup();
		}
		return grpSexoConsulta;
	}
	
	private JButton getBtnConsult() {
		if(btnConsult == null) {
			btnConsult = new JButton();
			btnConsult.setText("Consult");
		}
		return btnConsult;
	}
	
	private JPanel getPanelTabelaList() {
		if(panelTabelaList == null) {
			panelTabelaList = new JPanel();
			GroupLayout panelTabelaListLayout = new GroupLayout((JComponent)panelTabelaList);
			panelTabelaList.setLayout(panelTabelaListLayout);
			panelTabelaList.setBorder(BorderFactory.createTitledBorder(null, "Listagem", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			panelTabelaListLayout.setHorizontalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getTableListConsulta(), GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 6, Short.MAX_VALUE));
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getTableListConsulta(), 0, 119, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelTabelaList;
	}
	
	private JTable getTableListConsulta() {
		if(tableListConsulta == null) {
			TableModel tableListConsultaModel = 
					new DefaultTableModel(
							new String[][] { { "One", "Two" }, { "Three", "Four" } },
							new String[] { "Column 1", "Column 2" });
			tableListConsulta = new JTable();
			tableListConsulta.setModel(tableListConsultaModel);
		}
		return tableListConsulta;
	}

}
