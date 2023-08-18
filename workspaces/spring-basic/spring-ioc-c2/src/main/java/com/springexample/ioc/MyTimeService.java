package com.springexample.ioc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("timeService")
public class MyTimeService implements TimeService {
	
	private String pattern = "yyyy-MM-dd a hh:mm:ss";
	
	@Override
	public String getTimeString() {
		
		//날짜를 특정한 형식의 문자열로 변환하는 객체
		SimpleDateFormat formatter = 
				new SimpleDateFormat(pattern);
		String timeString = formatter.format(new Date());
		return timeString;
		
	}

}
