package se.educ.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import se.educ.devmedia.jdbc.ConexaoUtil;
import se.educ.devmedia.jdbc.dto.LoginDTO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.exception.PersistenceExceptions;

public class LoginDAO implements GenericoDAO<LoginDTO>{
	
	
	public boolean login(LoginDTO loginDTO) throws PersistenceExceptions{ 
		
		boolean result = false;
				
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql="SELECT * FROM tb_login WHERE name=? AND password=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginDTO.getName());
			statement.setString(2, loginDTO.getPassword());
			ResultSet resultSet = statement.executeQuery();
			
			result = resultSet.next(); // If there is something in DB, the value is "true", else the value is false...
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceExceptions(e.getMessage(), e);
		}
		
		return result;
	}
		
	
	

	@Override
	public void insert(LoginDTO object) throws PersistenceExceptions {
		
	}

	@Override
	public void update(LoginDTO object) throws PersistenceExceptions {
		
	}

	@Override
	public void delete(Integer id) throws PersistenceExceptions {
		
	}

	@Override
	public List<LoginDTO> listarTodos() throws PersistenceExceptions {
		return null;
	}

	@Override
	public LoginDTO buscarPorId(Integer id) throws PersistenceExceptions {
		return null;
	}
	
	

}
