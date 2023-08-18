package com.springexample.ioc;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // 모든 필드를 전달인자로 사용하는 생성자 메서드 자동으로 구현
public class MyTimeService implements TimeService {
	
	private String pattern;
	
	@Override
	public String getTimeString() {
		
		//날짜를 특정한 형식의 문자열로 변환하는 객체
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String timeString = formatter.format(new Date());
		return timeString;
		
	}

}
