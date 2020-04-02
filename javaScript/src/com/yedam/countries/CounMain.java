package com.yedam.countries;

import java.util.List;

public class CounMain {
	public static void main(String[] args) {
		CounDAO dao = new CounDAO();
		List<Countries> list = dao.getCountryList();
		
		for(Countries c : list) {
			System.out.println(c);
		}
	}

}
