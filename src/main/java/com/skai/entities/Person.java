package com.skai.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Builder;
import lombok.Data;



@Data
public class Person implements Comparable<Person>{
 	
	private int id;
	private String name;
	private String address;
	private Date dateOfBirth;
	private String role;
	private String hoby;
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
  
	
	@Override
	public int compareTo(Person person) {
		if(this.dateOfBirth.after(person.dateOfBirth)) {
			return 1;
		}
		else {
			if(this.dateOfBirth.before(person.dateOfBirth))
				return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("Person :id:%d,name:%s,address:%s,date of birth:%s,role:%s,hoby:%s",id,
				                   name,address,formatter.format(dateOfBirth),role,hoby);
		 
		 
	}
 	
}
