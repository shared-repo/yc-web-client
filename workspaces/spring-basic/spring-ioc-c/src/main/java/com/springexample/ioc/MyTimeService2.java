package com.springexample.ioc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("timeService2")
@NoArgsConstructor // 전달인자 없는 생성자 메서드 자동으로 구현
@AllArgsConstructor // 모든 필드를 전달인자로 사용하는 생성자 메서드 자동으로 구현 (전달인자 없는 생성자 메서드는 만들지 않습니다)
public class MyTimeService2 implements TimeService {
	
	private String pattern = "yyyy-MM-dd a hh:mm:ss";
	@Override
	public String getTimeString() {
		
		//날짜를 특정한 형식의 문자열로 변환하는 객체
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String timeString = formatter.format(new Date());
		return timeString;
		
	}

}
