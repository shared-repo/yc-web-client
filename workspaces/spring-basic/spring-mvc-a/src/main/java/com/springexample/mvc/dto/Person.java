package com.springexample.mvc.dto;

import lombok.Data;

@Data // @Getter + @Setter + @RequiredArgsConstructor + ....
public class Person {
	
	private String name;
	private String email;
	private String phone;
	private int age;

}
