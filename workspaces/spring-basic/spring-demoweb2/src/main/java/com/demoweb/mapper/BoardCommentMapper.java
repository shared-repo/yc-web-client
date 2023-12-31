package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
	
	@Select(  "select commentNo, boardNo, writer, content, regDate, deleted, groupNo, step, depth "
			+ "from boardcomment "
			+ "where boardno = #{ boardNo } "
			+ "order by groupno desc, step asc")
	List<BoardCommentDto> selectBoardCommentByBoardNo(@Param("boardNo") int boardNo);

	@Update(  "update boardcomment "
			+ "set deleted = true "
			+ "where commentno = #{ commentNo }")
	void deleteComment(@Param("commentNo") int commentNo);

	@Update(  "update boardcomment "
			+ "set content = #{ content } "
			+ "where commentno = #{ commentNo }")
	void updateComment(BoardCommentDto boardComment);

	@Select(  "select commentNo, boardNo, writer, content, regDate, deleted, groupNo, step, depth "
			+ "from boardcomment "
			+ "where commentno = #{ commentNo } and deleted = false")
	BoardCommentDto selectBoardCommentByCommentNo(@Param("commentNo") int commentNo);

	@Update(  "update boardcomment "
			+ "set step = step + 1 "
			+ "where groupno = #{ groupNo } and step >= #{ step }")
	void updateStep(BoardCommentDto boardComment);

	@Insert(  "insert into boardcomment (boardno, writer, content, groupno, step, depth) "
			+ "values (#{ boardNo }, #{ writer }, #{ content }, #{ groupNo }, #{ step }, #{ depth })")
	@Options(useGeneratedKeys = true, keyProperty = "commentNo", keyColumn = "commentNo")
	void insertRecomment(BoardCommentDto boardComment);
	
}









