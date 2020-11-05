package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardDaoTest {
	BoardDao boardDao;
	
	@Before
	public void setup(){
		boardDao = new BoardDao();
	}

	@Test
	public void selectAllBoardListTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PageVo pageVo = new PageVo();
		pageVo.setBoard_name("테스트");
		pageVo.setPage(1);
		pageVo.setPageSize(1);

		/***When***/
		List<BoardVo> boardList = boardDao.selectAllBoardPageList(sqlSession, pageVo);
		

		/***Then***/
		assertEquals(1, boardList.size());
	}
	
	@Test
	public void selectActiveBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVo> activeBoardList = boardDao.selectActiveBoard();
		
		
		/***Then***/
		assertEquals(2, activeBoardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("테스트용");
		boardVo.setBoard_status(1);
		
		/***When***/
		int insertCnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("테스트용");
		boardVo.setBoard_status(2);
		
		/***When***/
		int updateCnt = boardDao.updateBoard(boardVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void selectBoardTotalCntTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/***When***/
		int boardCnt = boardDao.selectBoardTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(4, boardCnt);
	}

}
