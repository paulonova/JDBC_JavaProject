package se.educ.devmedia.jdbc.bo;

import se.educ.devmedia.jdbc.dao.LoginDAO;
import se.educ.devmedia.jdbc.dto.LoginDTO;
import se.educ.devmedia.jdbc.exception.BusinessException;

public class LoginBO {
	
	/** This class is responsible to handle all business object to organize better our code.. */
	
	public boolean Login(LoginDTO loginDTO) throws BusinessException{
		boolean result = false;
		
		try {
			if(loginDTO.getName() == null || "".equals(loginDTO.getName())){
				throw new BusinessException("Username is obligatory!");
			}else if(loginDTO.getPassword() == null || "".equals(loginDTO.getPassword())){
				throw new BusinessException("Password is obligatory!");
			}else{
				LoginDAO loginDAO = new LoginDAO();				
				result =  loginDAO.login(loginDTO);				
			}			
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return result; 
	}

}
