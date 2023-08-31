package com.demoweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.demoweb.dto.BoardDto;

@Mapper // MapperScan을 통해 Mapper 구현체로 만들 인터페이스 설정
public interface BoardMapper {
	
	@Insert(  "insert into board (title, writer, content) "
			+ "values (#{ title }, #{ writer }, #{ content })" )
	void insertBoard(BoardDto board);

}
