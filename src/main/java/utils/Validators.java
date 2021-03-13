package utils;

import java.util.Iterator;
import java.util.List;

public class Validators {

	public static boolean isExceedMaxLength(String texto, Integer maxLength) {
		
		if(texto.length() <= maxLength) return false;
		
		return true;
		
	}
	
	public static boolean hasMinLenght(String texto, Integer minLength) {
		
		if(texto.length() >= minLength) return true;
		
		return false;
		
	}
	
	public static boolean cpfIsValid(String cpf) {
		
		if(!cpf.matches("\\d{11}")) return false;
				
		String[] numCpf = cpf.split("");
		
		Integer total = 0;
		
		for(String num: numCpf) {
			total += Integer.parseInt(num);
		}
		
		if(total % 11 == 0) {
			return true;
		}
		
		return false;
		
	}
	
}
