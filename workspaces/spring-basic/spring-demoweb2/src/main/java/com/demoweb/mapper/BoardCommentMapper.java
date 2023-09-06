package com.demoweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.demoweb.dto.BoardCommentDto;

@Mapper
public interface BoardCommentMapper {

	@Insert(  "insert into boardcomment (boardno, writer, content, groupno, step, depth) "
			+ "values (#{ boardNo }, #{ writer }, #{ content }, 0, 1, 0)")
	@Options(useGeneratedKeys = true, keyProperty = "commentNo", keyColumn = "commentNo")
	void insertComment(BoardCommentDto boardComment);
	
	@Update(  "update boardcomment "
			+ "set groupno = #{ groupNo } "
			+ "where commentno = #{ commentNo }")
	void updateGroupNo(@Param("groupNo") int groupNo, @Param("commentNo") int commentNo);
	
}
