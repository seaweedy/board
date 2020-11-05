package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;

public interface BoardDaoI {
	List<BoardVo> selectAllBoardPageList(SqlSession sqlSession, PageVo pageVo);
	
	List<BoardVo> selectActiveBoard();
	
	int insertBoard(BoardVo boardVo);
	
	int updateBoard(BoardVo boardVo);
	
	int selectBoardTotalCnt(SqlSession sqlSession);
}
