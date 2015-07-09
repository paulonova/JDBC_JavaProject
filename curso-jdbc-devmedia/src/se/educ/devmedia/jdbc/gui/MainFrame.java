package se.educ.devmedia.jdbc.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.educ.devmedia.jdbc.bo.PessoaBO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.util.UsefulMessage;

import javax.swing.JTable;

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
	private ButtonGroup btgOrderBy;
	private JLabel lblOrderBy;
	private JRadioButton rbtNomeOrder;
	private JRadioButton rbtCpfOrder;
	private JScrollPane scrollListConsulta;
	private JTable tableListConsulta;
	private JPanel panelTabelaList;
	private JButton btnConsulta;
	private ButtonGroup grpSexoConsulta;
	private JLabel lblSexoConsulta;
	private JRadioButton rbtMascConsulta;
	private JRadioButton rbtFemConsulta;
	private JTextField txtCpfConsulta;
	private JLabel lblCpfConsulta;
	private JLabel lblNomeConsulta;
	private JTextField txtNomeConsulta;
	private JScrollPane scrollListagem;
	private JTable tableListagem;
	private JLabel lblNasc;
	private JTextField txtNasc;
	
	// Formatter de datas
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
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
			this.setTitle("JDBC Project");
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
					mainTabbedPane.addTab("Consult", null, getPanelConsulta(), null);
					panelListagem.setPreferredSize(new java.awt.Dimension(223, 207));
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), 0, 420, Short.MAX_VALUE)
						.addContainerGap());
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getScrollListagem(), 0, 229, Short.MAX_VALUE)
						.addContainerGap());
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 449, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 505, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(545, 511);
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
			rbtFeminino.setText("Woman");
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
						char sexo = rbtMasculino.isSelected() ? 'M' : 'W';
						pessoaDTO.setSexo(sexo);

						pessoaBO.cadastrar(pessoaDTO);
						UsefulMessage.addMsg(MainFrame.this, "Register done successfully!");
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
			String[][] lista = pessoaBO.listing();
			if(tableListagem == null) {
				TableModel tabelListagemModel = 
						new DefaultTableModel(
								lista,
								new String[] { "Id", "Name", "CPF", "Adress", "Gender", "Birth" });
				tableListagem = new JTable();
				tableListagem.setModel(tabelListagemModel);
				tableListagem.setPreferredSize(new java.awt.Dimension(417, 226));
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
			panelConsulta.setPreferredSize(new java.awt.Dimension(500, 346));
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addComponent(getJLabel1xxxx(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJTextField1x(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(getJLabel1xxx(), GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				                .addGap(36))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGap(21)
				                .addComponent(getJRadioButton2x(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                .addComponent(getJRadioButton1xx(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 33, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
				        .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(getJRadioButton1x(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJTextField1xx(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 49, Short.MAX_VALUE))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 476, Short.MAX_VALUE))
				.addContainerGap());
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJLabel1xx(), getJLabel1xxx()});
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJTextField1xx(), getJTextField1x()});
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJRadioButton2x(), getJRadioButton1xx()});
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getBtnConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(72)
				.addComponent(getPanelTabelaList(), 0, 188, Short.MAX_VALUE)
				.addContainerGap(40, 40));
			panelConsultaLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJLabel1xxx(), getJLabel1xx()});
			panelConsultaLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJRadioButton2x(), getJRadioButton1xx()});
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
			lblNomeConsulta.setText("Name:");
		}
		return lblNomeConsulta;
	}

	private JLabel getJLabel1xxx() {
		if(lblCpfConsulta == null) {
			lblCpfConsulta = new JLabel();
			lblCpfConsulta.setText("CPF:");
		}
		return lblCpfConsulta;
	}
	
	private JTextField getJTextField1xx() {
		if(txtCpfConsulta == null) {
			txtCpfConsulta = new JTextField();
		}
		return txtCpfConsulta;
	}
	
	private JRadioButton getJRadioButton1x() {
		if(rbtFemConsulta == null) {
			rbtFemConsulta = new JRadioButton();
			rbtFemConsulta.setText("Woman");
			getGrpSexoConsulta().add(rbtFemConsulta);
		}
		return rbtFemConsulta;
	}
	
	private JRadioButton getJRadioButton2() {
		if(rbtMascConsulta == null) {
			rbtMascConsulta = new JRadioButton();
			rbtMascConsulta.setText("Man");
			rbtMascConsulta.setSelected(true);
			getGrpSexoConsulta().add(rbtMascConsulta);
		}
		return rbtMascConsulta;
	}
	
	private JLabel getJLabel2() {
		if(lblSexoConsulta == null) {
			lblSexoConsulta = new JLabel();
			lblSexoConsulta.setText("Gender:");
		}
		return lblSexoConsulta;
	}
	
	private ButtonGroup getGrpSexoConsulta() {
		if(grpSexoConsulta == null) {
			grpSexoConsulta = new ButtonGroup();
		}
		return grpSexoConsulta;
	}
	
	private JButton getBtnConsulta() {
		if(btnConsulta == null) {
			btnConsulta = new JButton();
			btnConsulta.setText("Consult");
			btnConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					getTableListConsulta();
				}
			});
		}
		return btnConsulta;
	}
	
	private JPanel getPanelTabelaList() {
		if(panelTabelaList == null) {
			panelTabelaList = new JPanel();
			GroupLayout panelTabelaListLayout = new GroupLayout((JComponent)panelTabelaList);
			panelTabelaList.setLayout(panelTabelaListLayout);
			panelTabelaList.setBorder(BorderFactory.createTitledBorder("Listing"));
			panelTabelaListLayout.setHorizontalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(getScrollListConsulta(), GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap(122, Short.MAX_VALUE)
				.addComponent(getScrollListConsulta(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return panelTabelaList;
	}
	
	private JTable getTableListConsulta() {
		String nome = txtNomeConsulta.getText();
		Long cpf = txtCpfConsulta.getText().equals("") ? null : Long.parseLong(txtCpfConsulta.getText());
		char sexo = rbtMascConsulta.isSelected() ? 'M' : 'W';
		String orderBy = rbtCpfOrder.isSelected() ? "nome" : "cpf";
		
		if(tableListConsulta == null) {
			tableListConsulta = new JTable();
		} else {
			PessoaBO pessoaBO = new PessoaBO();
			try {
				String[][] lista = pessoaBO.listConsult(nome, cpf, sexo, orderBy); 
				TableModel tableListConsultaModel = 
						new DefaultTableModel(
								lista,
								new String[] { "Id", "Name", "CPF", "Adress", "Gender", "Birth" });
				tableListConsulta.setModel(tableListConsultaModel);
			} catch (Exception e) {
				e.printStackTrace();
				UsefulMessage.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return tableListConsulta;
	}
	
	private JScrollPane getScrollListConsulta() {
		if(scrollListConsulta == null) {
			scrollListConsulta = new JScrollPane();
			scrollListConsulta.setViewportView(getTableListConsulta());
		}
		return scrollListConsulta;
	}
	
	private JRadioButton getJRadioButton1xx() {
		if(rbtCpfOrder == null) {
			rbtCpfOrder = new JRadioButton();
			rbtCpfOrder.setText("CPF");
			getBtgOrderBy().add(rbtCpfOrder);
			getBtgOrderBy().add(rbtCpfOrder);
		}
		return rbtCpfOrder;
	}
	
	private JRadioButton getJRadioButton2x() {
		if(rbtNomeOrder == null) {
			rbtNomeOrder = new JRadioButton();
			rbtNomeOrder.setText("Name");
			rbtNomeOrder.setSelected(true);
			getBtgOrderBy().add(rbtNomeOrder);
			getBtgOrderBy().add(rbtNomeOrder);
		}
		return rbtNomeOrder;
	}
	
	private JLabel getJLabel1xxxx() {
		if(lblOrderBy == null) {
			lblOrderBy = new JLabel();
			lblOrderBy.setText("Order by:");
		}
		return lblOrderBy;
	}
	
	private ButtonGroup getBtgOrderBy() {
		if(btgOrderBy == null) {
			btgOrderBy = new ButtonGroup();
		}
		return btgOrderBy;
	}

}
