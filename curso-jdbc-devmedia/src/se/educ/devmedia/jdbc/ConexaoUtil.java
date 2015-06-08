package se.educ.devmedia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import se.educ.devmedia.jdbc.dto.PessoaDTO;

public class ConexaoUtil {
	
	private static ConexaoUtil conexaoUtil;
	
	// Constants to connection.
	private static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/teste_devmedia";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "David144";
	
	public ConexaoUtil getMinhaMae() {
		return null; 
		
	}
	
	
	//Connection Singleton..
	public static ConexaoUtil getInstance(){
		
		if(conexaoUtil==null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
		
	}
	
	// Connection with SQL using: java.sql.Connection!
	public Connection getConnection() throws ClassNotFoundException, SQLException{ 
		
		Class.forName(SQL_DRIVER);		
		return DriverManager.getConnection(URL_CONNECTION, USERNAME, PASSWORD);
		
		
	}
	
	/*   CRUD - CREATE, READ, UPDATE and DELETE*/
	
	
	// Read or Select
	public void select() throws SQLException{ 
		Connection connection = null;
		
		try {			
			connection = getConnection();
			
			String sql ="SELECT * FROM tb_pessoa";
			//Prepare to get information in SQL db.
			PreparedStatement statement = connection.prepareStatement(sql);
			
			// Save the result of select..
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				System.out.println("Id: " + resultSet.getInt("id_pessoa"));
				System.out.println("Nome: " + resultSet.getString("nome"));
				System.out.println("CPF: " + resultSet.getLong("cpf"));
				System.out.println("Endereco: " + resultSet.getString("endereco"));
				System.out.println("Sexo: " + resultSet.getString("sexo"));
				System.out.println("Data Nasc: " + resultSet.getString("dt_nasc"));
				System.out.println("**********************************************");
				System.out.println(" ");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			//Close the connection..
			connection.close();
		}		
		
	}
	
	// Insert
	public void insert(PessoaDTO pessoaDTO) throws SQLException{
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			String sql = "INSERT INTO tb_pessoa (nome, cpf, endereco, sexo, dt_nasc) "
					+ "VALUES (?, ?, ?, ?, ?)"; // Avoid Injection
			
			PreparedStatement statement = connection.prepareStatement(sql); // Ctr + 1 (atalho)
			statement.setString(1,	pessoaDTO.getNome());
			statement.setLong(2, 	pessoaDTO.getCpf());
			statement.setString(3, 	pessoaDTO.getEndereco());
			statement.setString(4, 	String.valueOf(pessoaDTO.getSexo())); 
			statement.setDate(5, 	new Date(pessoaDTO.getDtNasc().getTime()));
			
			boolean result = statement.execute();
			if(result){
				System.out.println("Data was insert successfully!!!");
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			connection.close(); 
		}
	}
	
	// Update
	public void update(PessoaDTO pessoaDTO){
		Connection connection = null;
		
		try {
			connection = getConnection();
			String sql ="UPDATE tb_pessoa SET"
					+ " nome = ?, "
					+ " cpf = ?,"
					+ " endereco = ?,"
					+ " sexo = ?,"
					+ " dt_nasc = ? WHERE id_pessoa = ?";
			
			/*No PreparedStatement não se usa ; nofonal de cada query, porque dá erro...*/
			
			PreparedStatement statement = connection.prepareStatement(sql); // Ctr + 1 (atalho)
			statement.setString(1,	pessoaDTO.getNome());
			statement.setLong(2, 	pessoaDTO.getCpf());
			statement.setString(3, 	pessoaDTO.getEndereco());
			statement.setString(4, 	String.valueOf(pessoaDTO.getSexo())); 
			statement.setDate(5, 	new Date(pessoaDTO.getDtNasc().getTime()));
			statement.setInt(6, 	pessoaDTO.getIdPessoa());
			
			statement.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Delete
	public void delete(Integer idPessoa) throws SQLException{
		Connection connection=null;
		
		try {
			connection=getConnection();
			String sql="DELETE FROM tb_pessoa WHERE id_pessoa=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			connection.close(); 
		}
		
	}
	
		
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException { 
		
		Calendar cal = Calendar.getInstance();
		

		try {
			
			PessoaDTO dto = new PessoaDTO();
			dto.setIdPessoa(12); 
			dto.setNome("João Henrique 333");
			dto.setCpf(10235555833l);
			dto.setEndereco("Rua das Margaridas Brancas");
			dto.setSexo('M');
			dto.setDtNasc(new Date((2015-1900),05,06)); 
			
			getInstance().delete(dto.getIdPessoa());  // update is not working...
			getInstance().select();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
