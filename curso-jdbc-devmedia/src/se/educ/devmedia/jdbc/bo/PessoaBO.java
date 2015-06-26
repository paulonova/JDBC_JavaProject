package se.educ.devmedia.jdbc.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import se.educ.devmedia.jdbc.dao.PessoaDAO;
import se.educ.devmedia.jdbc.dto.PessoaDTO;
import se.educ.devmedia.jdbc.exception.BusinessException;

public class PessoaBO {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	public void cadastrar(PessoaDTO pessoaDTO) throws BusinessException{
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.insert(pessoaDTO);
			
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	public String [] [] listing() throws BusinessException{
		
		int columnNumber = 6;
		String [] [] returnList = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			List<PessoaDTO> list = pessoaDAO.listarTodos();
			returnList = new String [list.size()] [columnNumber];
			
			for (int i = 0; i < list.size(); i++) {
				PessoaDTO pessoa = list.get(i);
				returnList[i][0] = pessoa.getIdPessoa().toString();
				returnList[i][1] = pessoa.getNome();
				returnList[i][2] = pessoa.getCpf().toString();
				returnList[i][3] = pessoa.getEndereco();
				returnList[i][4] = pessoa.getSexo() == 'M' ? "Man" : "Woman"; 
				returnList[i][5] = dateFormat.format(pessoa.getDtNasc());			
			}			
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} 
		
		return returnList;
	}	

}
 