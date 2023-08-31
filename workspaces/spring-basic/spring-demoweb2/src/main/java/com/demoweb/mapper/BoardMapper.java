package com.demoweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.demoweb.dto.BoardDto;

@Mapper // MapperScan을 통해 Mapper 구현체로 만들 인터페이스 설정
public interface BoardMapper {
	
	@Insert(  "insert into board (title, writer, content) "
			+ "values (#{ title }, #{ writer }, #{ content })" )
	@Options(useGeneratedKeys = true, keyProperty = "boardNo") // insert 후에 생성된 자동 증가 번호를 dto 저장하는 설정
	void insertBoard(BoardDto board);

}
