package se.educ.devmedia.jdbc.bo;

import se.educ.devmedia.jdbc.dao.PessoaDAO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.exception.BusinessException;

public class PessoaBO {
	
	public void cadastrar(PessoaDTO pessoaDTO) throws BusinessException{
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.insert(pessoaDTO);
			
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}

}
 