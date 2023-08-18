package com.springexample.ioc;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyTimeService implements TimeService {
	
	private String pattern;
	
	@Override
	public String getTimeString() {
		
		//날짜를 특정한 형식의 문자열로 변환하는 객체
		SimpleDateFormat formatter = 
				new SimpleDateFormat(pattern);
		String timeString = formatter.format(new Date());
		return timeString;
		
	}

}
