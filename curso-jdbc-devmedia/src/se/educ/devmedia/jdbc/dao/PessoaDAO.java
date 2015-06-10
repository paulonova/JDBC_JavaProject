package se.educ.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import se.educ.devmedia.jdbc.ConexaoUtil;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.exception.PersistenceExceptions;

public class PessoaDAO implements GenericoDAO<PessoaDTO> {
	
	

	@Override
	public void insert(PessoaDTO pessoaDTO) throws PersistenceExceptions {
			
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();			
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
			connection.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceExceptions(e.getMessage(), e);
		}
		
	}

	@Override
	public void update(PessoaDTO pessoaDTO) throws PersistenceExceptions {			
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
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
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer idPessoa) throws PersistenceExceptions {

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql="DELETE FROM tb_pessoa WHERE id_pessoa=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			statement.execute();
			connection.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceExceptions(e.getMessage(), e);
		}	
		
	}

	@Override
	public List<PessoaDTO> listarTodos() throws PersistenceExceptions {	
		
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();

		
		try {			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql ="SELECT * FROM tb_pessoa";
			//Prepare to get information in SQL db.
			PreparedStatement statement = connection.prepareStatement(sql);
			
			// Save the result of select..
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa")); 
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setDtNasc(resultSet.getDate("dt_nasc"));
				listaPessoas.add(pessoaDTO);				
				
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceExceptions(e.getMessage(), e);
			
		}	
		
		return listaPessoas;
	}

	@Override
	public PessoaDTO buscarPorId(Integer id) throws PersistenceExceptions {
		return null;
	}



}
