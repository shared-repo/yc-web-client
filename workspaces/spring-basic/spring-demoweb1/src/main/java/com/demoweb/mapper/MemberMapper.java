package com.demoweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demoweb.dto.MemberDto;

// MapperFactoryBean이 구현 클래스를 만들때 사용하는 인터페이스
// 반드시 mapper.xml 파일과 패키지, 인터페이스 이름, 메서드 이름 등이 일치하도록 작성
@Mapper // <mybatis:scan 을 통해 Mapper 인터페이스로 사용되는 설정
public interface MemberMapper {
	
	void insertMember(MemberDto member);
	
	MemberDto selectMemberByIdAndPasswd(@Param("memberId") String memberId, // mapper.xml 파일의 #{ memberId }에 전달 
										@Param("passwd")String passwd); // mapper.xml 파일의 #{ passwd }에 전달

}
