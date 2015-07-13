package se.educ.devmedia.jdbc.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.educ.devmedia.jdbc.bo.PessoaBO;
import se.educ.devmedia.jdbc.dao.PessoaDAO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.exception.BusinessException;
import se.educ.devmedia.jdbc.util.UsefulMessage;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private ButtonGroup buttonGroup1;
	private ButtonGroup bgrSexoUpdate;
	private JLabel lblIDValor;
	private JLabel lblIDUpdate;
	private JPanel panelInternalFrame;
	private JButton btnUpdate;
	private JLabel lblCPFUpdate;
	private JLabel lblEnderecoUpdate;
	private JLabel lblSexoUpdate;
	private JLabel lblDtNascUpdate;
	private JTextField txtCPFUpdate;
	private JTextField txtEnderecoUpdate;
	private JRadioButton rbtMascUpdate;
	private JRadioButton rbtFemUpdate;
	private JTextField txtDtNascUpdate;
	private JLabel lblNomeUpdate;
	private JTextField txtNomeUpdate;
	private JPanel panelUpdate;
	private JInternalFrame internalUpdate;
	private JButton btnDeleteAll;
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
	private List<Integer> idsPessoas = new ArrayList<Integer>();
	
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
			this.setPreferredSize(new java.awt.Dimension(1012, 498));
			{
				mainTabbedPane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTabbedPane.addTab("Register", null, panelCadastro, null);
					panelCadastro.setPreferredSize(new java.awt.Dimension(403, 255));
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
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getBtnCadastrar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 115, Short.MAX_VALUE))
						    .addGroup(panelCadastroLayout.createSequentialGroup()
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
						                .addComponent(getJRadioButton1(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 11, Short.MAX_VALUE))
						            .addGroup(panelCadastroLayout.createSequentialGroup()
						                .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addGroup(panelCadastroLayout.createSequentialGroup()
						                .addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addGroup(panelCadastroLayout.createSequentialGroup()
						                .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addGroup(panelCadastroLayout.createSequentialGroup()
						                .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE)))))
						.addContainerGap(365, 365));
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
						    .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getRbtMasculino(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getBtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(122, 122));
				}
				{
					panelListagem = new JPanel();
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagemLayout.setHorizontalGroup(
						panelListagemLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(panelListagemLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panelListagemLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGroup(panelListagemLayout.createSequentialGroup()
										.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(getPanelInternalFrame(), GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					panelListagemLayout.setVerticalGroup(
						panelListagemLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(panelListagemLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panelListagemLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(getPanelInternalFrame(), GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
									.addGroup(panelListagemLayout.createSequentialGroup()
										.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(19, Short.MAX_VALUE))
					);
					panelListagem.setLayout(panelListagemLayout);
					mainTabbedPane.addTab("Listing", null, panelListagem, null);
					mainTabbedPane.addTab("Consult", null, getPanelConsulta(), null);
					panelListagem.setPreferredSize(new java.awt.Dimension(965, 408));
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 427, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 970, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(1060, 498);
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
		final PessoaBO pessoaBO = new PessoaBO();
		try {
			String[][] lista = pessoaBO.listing(idsPessoas);
			if(tableListagem == null) {
				tableListagem = new JTable();
			}
				
				TableModel tableListagemModel = new DefaultTableModel(
								lista,
								new String[] { "Id", "Name", "CPF", "Adress", "Gender", "Birth", "", "" });
				
				tableListagem.setModel(tableListagemModel);
			
			
			Action actionDelecao = new AbstractAction() {
				private static final long serialVersionUID = -6939769650161954746L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to remove this person?");
					if (resp == 0) {
						JTable table = (JTable) actionEvent.getSource();
						
						int linha = Integer.parseInt(actionEvent.getActionCommand());
						((DefaultTableModel) table.getModel()).removeRow(linha);
						try {
							pessoaBO.removePerson(idsPessoas.get(linha));
							idsPessoas.remove(linha);
							UsefulMessage.addMsg(MainFrame.this, "Person removed successfully!");
						} catch (BusinessException e) {
							e.printStackTrace();
							UsefulMessage.addMsg(MainFrame.this, e.getMessage());
						}
					}
				}
			};

			Action actionEdicao = new AbstractAction() {
				private static final long serialVersionUID = -421951775656187572L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					int linha = Integer.parseInt(actionEvent.getActionCommand());
					try {
						PessoaDTO pessoaDTO = pessoaBO.buscaPorId(idsPessoas.get(linha));
						populaInternalUpdate(pessoaDTO);
					} catch (BusinessException e) {
						e.printStackTrace();
						UsefulMessage.addMsg(MainFrame.this, e.getMessage());
					}
				}
			};
			
			ButtonColumn buttonColumnEdicao = new ButtonColumn(tableListagem, actionEdicao, 7);
			ButtonColumn buttonColumnDelecao = new ButtonColumn(tableListagem, actionDelecao, 6);
			buttonColumnDelecao.setMnemonic(KeyEvent.VK_D);
			buttonColumnEdicao.setMnemonic(KeyEvent.VK_E);
		} catch (BusinessException e) {
			e.printStackTrace();
			UsefulMessage.addMsg(MainFrame.this, e.getMessage());
		}
		return tableListagem;
	}
	
	private void populaInternalUpdate(PessoaDTO pessoaDTO) {
		this.lblIDValor.setText(pessoaDTO.getIdPessoa().toString());
		this.txtNomeUpdate.setText(pessoaDTO.getNome());
		this.txtCPFUpdate.setText(pessoaDTO.getCpf().toString());
		this.txtEnderecoUpdate.setText(pessoaDTO.getEndereco());
		this.txtDtNascUpdate.setText(dateFormat.format(pessoaDTO.getDtNasc()));
		this.rbtMascUpdate.setSelected(pessoaDTO.getSexo() == 'M');
		this.rbtFemUpdate.setSelected(pessoaDTO.getSexo() == 'W');
		this.internalUpdate.setVisible(true);
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
			panelConsulta.setPreferredSize(new java.awt.Dimension(498, 353));
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(panelConsultaLayout.createSequentialGroup()
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGroup(panelConsultaLayout.createParallelGroup()
				                    .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(getJLabel1xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
				                .addGroup(panelConsultaLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                        .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                        .addGap(72))
				                    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                        .addPreferredGap(getJRadioButton2(), getJTextField1x(), LayoutStyle.ComponentPlacement.INDENT)
				                        .addComponent(getJTextField1x(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(getJLabel1xxx(), GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getJLabel1xxxx(), GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				                .addComponent(getJRadioButton2x(), GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				                .addGroup(panelConsultaLayout.createParallelGroup()
				                    .addComponent(getJRadioButton1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                        .addPreferredGap(getJRadioButton1x(), getJRadioButton1xx(), LayoutStyle.ComponentPlacement.INDENT)
				                        .addComponent(getJRadioButton1xx(), GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				                        .addGap(27)))
				                .addGap(17)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(panelConsultaLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(getJTextField1xx(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGap(0, 36, Short.MAX_VALUE)
				                .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
				        .addGap(32))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 486, Short.MAX_VALUE)));
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJTextField1xx(), getJTextField1x()});
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJLabel1xx(), getJLabel1xxx()});
			panelConsultaLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJRadioButton1xx(), getJRadioButton2x()});
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJRadioButton1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(getJRadioButton1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJLabel1xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJRadioButton2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				        .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getPanelTabelaList(), GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			panelConsultaLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJLabel1xxx(), getJLabel1xx()});
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
				.addContainerGap()
				.addComponent(getScrollListConsulta(), 0, 661, Short.MAX_VALUE)
				.addContainerGap());
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(getScrollListConsulta(), GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return panelTabelaList;
	}
	
	private JTable getTableListConsulta() {
		String nome = txtNomeConsulta.getText();
		Long cpf = txtCpfConsulta.getText().equals("") ? null : Long.parseLong(txtCpfConsulta.getText());
		char sexo = rbtMascConsulta.isSelected() ? 'M' : 'W';
		String orderBy = rbtNomeOrder.isSelected() ? "nome" : "cpf";
		
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
		}
		return rbtCpfOrder;
	}
	
	private JRadioButton getJRadioButton2x() {
		if(rbtNomeOrder == null) {
			rbtNomeOrder = new JRadioButton();
			rbtNomeOrder.setText("Name");
			rbtNomeOrder.setSelected(true);
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
	
	private JButton getBtnDeleteAll() {
		if(btnDeleteAll == null) {
			btnDeleteAll = new JButton();
			btnDeleteAll.setText("Delete All");
			btnDeleteAll.setMnemonic(java.awt.event.KeyEvent.VK_D);
			btnDeleteAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaBO pessoaBO = new PessoaBO();
					try {
						int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Really remove all?");
						if (resp == 0) {
							pessoaBO.removeAll();
							UsefulMessage.addMsg(MainFrame.this, "People successfully removed!");
							getTableListagem();
						}
					} catch (BusinessException e) {
						e.printStackTrace();
						UsefulMessage.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnDeleteAll;
	}
	
	private JInternalFrame getInternalUpdate() {
		if(internalUpdate == null) {
			internalUpdate = new JInternalFrame();
			GroupLayout internalUpdateLayout = new GroupLayout((JComponent)internalUpdate.getContentPane());
			internalUpdate.getContentPane().setLayout(internalUpdateLayout);
			internalUpdate.setVisible(true);
			internalUpdate.setPreferredSize(new java.awt.Dimension(424, 349));
			internalUpdate.setBounds(0, 2, 424, 349);
			internalUpdate.setName("");
			internalUpdate.setTitle("Edita Pessoa");
			internalUpdateLayout.setHorizontalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 398, Short.MAX_VALUE)
				.addContainerGap());
			internalUpdateLayout.setVerticalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 292, Short.MAX_VALUE)
				.addContainerGap());
		}
		return internalUpdate;
	}
	
	private JPanel getPanelUpdate() {
		if(panelUpdate == null) {
			panelUpdate = new JPanel();
			GroupLayout panelUpdateLayout = new GroupLayout((JComponent)panelUpdate);
			panelUpdate.setLayout(panelUpdateLayout);
			panelUpdate.setBorder(BorderFactory.createTitledBorder("People Editing"));
			panelUpdateLayout.setHorizontalGroup(panelUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(panelUpdateLayout.createSequentialGroup()
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addComponent(getJLabel1xxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel2x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getBtnUpdate(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addGroup(panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJTextField1xxx(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJTextField1xxxx(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJRadioButton2xx(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				                .addComponent(getJRadioButton1xxx(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 11, Short.MAX_VALUE))
				            .addGroup(panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJTextField2(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJTextField3(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))))
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				        .addComponent(getJLabel1xxxxxxx(), GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				        .addGap(18)
				        .addComponent(getJLabel1xxxxxxxx(), GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 200, Short.MAX_VALUE)))
				.addContainerGap(46, 46));
			panelUpdateLayout.setVerticalGroup(panelUpdateLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addComponent(getJLabel1xxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJRadioButton2xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getBtnUpdate(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return panelUpdate;
	}
	
	private JTextField getJTextField1xxx() {
		if(txtNomeUpdate == null) {
			txtNomeUpdate = new JTextField();
		}
		return txtNomeUpdate;
	}
	
	private JLabel getJLabel1xxxxx() {
		if(lblNomeUpdate == null) {
			lblNomeUpdate = new JLabel();
			lblNomeUpdate.setText("Name:");
		}
		return lblNomeUpdate;
	}
	
	private JTextField getJTextField1xxxx() {
		if(txtDtNascUpdate == null) {
			txtDtNascUpdate = new JTextField();
		}
		return txtDtNascUpdate;
	}
	
	private JRadioButton getJRadioButton1xxx() {
		if(rbtFemUpdate == null) {
			rbtFemUpdate = new JRadioButton();
			rbtFemUpdate.setText("Woman");
			getGrpSexoConsulta().add(rbtFemUpdate);
			getBgrSexoUpdate().add(rbtFemUpdate);
		}
		return rbtFemUpdate;
	}
	
	private JRadioButton getJRadioButton2xx() {
		if(rbtMascUpdate == null) {
			rbtMascUpdate = new JRadioButton();
			rbtMascUpdate.setText("Man");
			getBgrSexoUpdate().add(rbtMascUpdate);
			getBgrSexoUpdate().add(rbtMascUpdate);
			rbtMascUpdate.setSelected(true);
		}
		return rbtMascUpdate;
	}
	
	private JTextField getJTextField2() {
		if(txtEnderecoUpdate == null) {
			txtEnderecoUpdate = new JTextField();
		}
		return txtEnderecoUpdate;
	}
	
	private JTextField getJTextField3() {
		if(txtCPFUpdate == null) {
			txtCPFUpdate = new JTextField();
		}
		return txtCPFUpdate;
	}
	
	private JLabel getJLabel1xxxxxx() {
		if(lblDtNascUpdate == null) {
			lblDtNascUpdate = new JLabel();
			lblDtNascUpdate.setText("Birth:");
		}
		return lblDtNascUpdate;
	}
	
	private JLabel getJLabel2x() {
		if(lblSexoUpdate == null) {
			lblSexoUpdate = new JLabel();
			lblSexoUpdate.setText("Gender:");
		}
		return lblSexoUpdate;
	}
	
	private JLabel getJLabel3() {
		if(lblEnderecoUpdate == null) {
			lblEnderecoUpdate = new JLabel();
			lblEnderecoUpdate.setText("Adress:");
		}
		return lblEnderecoUpdate;
	}
	
	private JLabel getJLabel4() {
		if(lblCPFUpdate == null) {
			lblCPFUpdate = new JLabel();
			lblCPFUpdate.setText("CPF:");
		}
		return lblCPFUpdate;
	}
	
	private JButton getBtnUpdate() {
		if(btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setText("Edit");
			btnUpdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						PessoaBO pessoaBO = new PessoaBO();
						PessoaDTO pessoaDTO = new PessoaDTO();
						
						String nome = txtNomeUpdate.getText();
						String cpf = txtCPFUpdate.getText();
						String adress = txtEnderecoUpdate.getText();
						String nasc = txtDtNascUpdate.getText();
						char sexo = rbtMascUpdate.isSelected() ? 'M' : 'W';
						
						pessoaBO.validName(nome);
						pessoaBO.validCPF(cpf);
						pessoaBO.validAdress(adress);
						pessoaBO.validBirth(nasc);
						
						
						pessoaDTO.setIdPessoa(Integer.parseInt(lblIDValor.getText())); 
						pessoaDTO.setNome(nome);
						pessoaDTO.setCpf(Long.parseLong(cpf));
						pessoaDTO.setEndereco(adress);
						pessoaDTO.setDtNasc(dateFormat.parse(nasc));
						pessoaDTO.setSexo(sexo);
						
						PessoaDAO pessoaDAO = new PessoaDAO();
						pessoaDAO.update(pessoaDTO);
						UsefulMessage.addMsg(MainFrame.this, pessoaDTO.getNome() + " Was updated successfully!");
						getTableListagem();
						
					} catch (Exception e2) {
						e2.printStackTrace();
						UsefulMessage.addMsg(MainFrame.this, e2.getMessage());
					}
					
					
					
					
				}
			});
		}
		return btnUpdate;
	}
	
	private JPanel getPanelInternalFrame() {
		if(panelInternalFrame == null) {
			panelInternalFrame = new JPanel();
			panelInternalFrame.add(getInternalUpdate());
			internalUpdate.setVisible(false);
		}
		return panelInternalFrame;
	}
	
	private JLabel getJLabel1xxxxxxx() {
		if(lblIDUpdate == null) {
			lblIDUpdate = new JLabel();
			lblIDUpdate.setText("ID:");
		}
		return lblIDUpdate;
	}
	
	private JLabel getJLabel1xxxxxxxx() {
		if(lblIDValor == null) {
			lblIDValor = new JLabel();
		}
		return lblIDValor;
	}
	
	private ButtonGroup getBgrSexoUpdate() {
		if(bgrSexoUpdate == null) {
			bgrSexoUpdate = new ButtonGroup();
		}
		return bgrSexoUpdate;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

}
