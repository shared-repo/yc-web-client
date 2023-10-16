package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demoweb.dto.BoardAttachDto;
import com.demoweb.dto.BoardDto;

@Mapper // MapperScan을 통해 Mapper 구현체로 만들 인터페이스 설정
public interface BoardMapper {
	
	@Insert(  "insert into board (title, writer, content) "
			+ "values (#{ title }, #{ writer }, #{ content })" )
	@Options(useGeneratedKeys = true, keyProperty = "boardNo") // insert 후에 생성된 자동 증가 번호를 dto 저장하는 설정
	void insertBoard(BoardDto board);
	
	@Insert(  "insert into boardattach (boardno, userfilename, savedfilename) "
			+ "values ( #{ boardNo }, #{ userFileName }, #{ savedFileName } )")
	void insertBoardAttach(BoardAttachDto attach);
	
	@Select(  "select boardNo, title, writer, readCount, regDate, deleted "
			+ "from board "
			+ "order by boardno desc")
	List<BoardDto> selectAllBoard();
	@Select(  "select boardNo, title, writer, readCount, regDate, deleted "
			+ "from board "
			+ "order by boardno desc "
			+ "limit #{ from }, #{ count }")
	List<BoardDto> selectBoardByPage(@Param("from")int from, @Param("count")int count);
	@Select(  "select count(*) from board ")
	int selectBoardCount();
	
	@Select(  "select boardNo, title, content, writer, readCount, regDate "
			+ "from board "
			+ "where boardno = #{ boardNo } and deleted = false")
	BoardDto selectBoardByBoardNo(@Param("boardNo") int boardNo);
	
	@Select(  "select attachNo, boardNo, userFileName, savedFileName, downloadCount "
			+ "from boardattach "
			+ "where boardno = #{ boardNo }")
	List<BoardAttachDto> selectBoardAttachByBoardNo(@Param("boardNo") int boardNo);
	
	@Select(  "select attachNo, boardNo, userFileName, savedFileName, downloadCount "
			+ "from boardattach "
			+ "where attachno = #{ attachNo }")
	BoardAttachDto selectBoardAttachByAttachNo(@Param("attachNo") int attachNo);
	
	@Update(  "update board "
			+ "set deleted = true "
			+ "where boardno = #{ boardNo }")
	void deleteBoard(@Param("boardNo") int boardNo);
	
	@Update(  "update board "
			+ "set title = #{ title }, content = #{ content } "
			+ "where boardno = #{ boardNo }")
	void updateBoard(BoardDto board);

	@Insert(  "insert into member_read_board ( memberId, boardNo ) "
			+ "values ( #{ memberId }, #{ boardNo } )")
	void insertMemberReadBoard(@Param("boardNo")int boardNo, @Param("memberId")String memberId);

	@Update(  "update board "
			+ "set readcount = readcount + 1 "
			+ "where boardNo = #{ boardNo } "
			+ "		 and not exists ( select * "
			+ "						  from member_read_board "
			+ "						  where boardno = #{ boardNo } "
			+ "							    and memberId = #{ memberId } )")
	void updateBoardReadCount(@Param("boardNo")int boardNo, @Param("memberId")String memberId);

	@Update(  "update board "
			+ "set readcount = readcount + 1 "
			+ "where boardNo = #{ boardNo } " )
	void updateBoardReadCount2(int boardNo);

	

}
