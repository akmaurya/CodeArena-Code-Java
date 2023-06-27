package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;

import beans.address.PersonBean;

@Controller
public class PersonDAO {
	private static ArrayList<PersonBean> person;

	public PersonDAO() {
		person = new ArrayList<PersonBean>();
	}	
	public static ArrayList<PersonBean> getPerson() {
		return person;
	}

	public static void setPerson(PersonBean person) {
		PersonDAO.person.add(person);
	}

}
