package se.educ.devmedia.jdbc.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.bind.ValidationException;

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
	
	public String [] [] listing(List<Integer> idPerson) throws BusinessException{
		
		int columnNumber = 8;
		String [] [] returnList = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			List<PessoaDTO> list = pessoaDAO.listarTodos();
			returnList = new String [list.size()] [columnNumber];
			
			for (int i = 0; i < list.size(); i++) {
				PessoaDTO pessoa = list.get(i);
				returnList[i][0] = pessoa.getIdPessoa().toString();
				idPerson.add(pessoa.getIdPessoa());
				returnList[i][1] = pessoa.getNome();
				returnList[i][2] = pessoa.getCpf().toString();
				returnList[i][3] = pessoa.getEndereco();
				returnList[i][4] = pessoa.getSexo() == 'M' ? "Man" : "Woman"; 
				returnList[i][5] = dateFormat.format(pessoa.getDtNasc());
				returnList[i][6] = "Delete";	
				returnList[i][7] = "Edit";	
			}			
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} 
		
		return returnList;
	}
	
	
	// Method to remove by ID..
	public void removePerson(Integer idPerson) throws BusinessException{ 
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.delete(idPerson); 
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	
	// Methods to validate fields..
	
	public boolean validName(String name) throws ValidationException{
		boolean isValid = true;
		
		if(name == null || name.equals("")){
			isValid = false;
			throw new ValidationException("Field name is required!");
		}else if(name.length() > 45){
			isValid = false;
			throw new ValidationException("Field name suport just 30 characters");
		}
		return isValid;
	}
	
	public boolean validCPF(String cpf) throws ValidationException{
		boolean isValid = true;
		
		if(cpf == null || cpf.equals("")){
			isValid = false;
			throw new ValidationException("Field CPF is required!");
		}else if(cpf.length() != 11){
			isValid = false;
			throw new ValidationException("Field CPF must be 11 digits");
		}else {
			char[] digits = cpf.toCharArray();
			for(char digit : digits){
				if (!Character.isDigit(digit)){
					isValid = false;
					throw new ValidationException("Field CPF is not a number!");
				}
			}
			
		}
		
		return isValid;
	}
	
	public boolean validAdress(String adress) throws ValidationException{
		boolean isValid = true;
		
		if(adress == null || adress.equals("")){
			isValid = false;
			throw new ValidationException("Field Adress is required!");
		}else if(adress.length() > 45){
			isValid = false;
			throw new ValidationException("Field Adress suport just 45 characters");
		}
		
		return isValid;
	}
	
	public boolean validBirth(String birth) throws ValidationException{
		boolean isValid = true;
		
		if(birth == null || birth.equals("")){
			isValid = false;
			throw new ValidationException("Field Birth is required!");
			
		}else {
			try {
				dateFormat.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
				isValid = false;
				throw new ValidationException("Birth format is not correct!");
			}
		}
		
		return isValid;
	}
	
	
public String [] [] listConsult(String name, Long cpf, char gender, String orderBy ) throws BusinessException{ 
		
		int columnNumber = 6;
		String [] [] returnList = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			List<PessoaDTO> list = pessoaDAO.consultList(name, cpf, String.valueOf(gender), orderBy); 
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
 