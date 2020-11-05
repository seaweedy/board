package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardServiceTest {
private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
BoardService boardService;

	@Before
	public void setup(){
		boardService = new BoardService();
	}

	@Test
	public void selectAllBoardListTest() {
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setBoard_name("테스트");
		pageVo.setPage(1);
		pageVo.setPageSize(1);

		/***When***/
		Map<String, Object> boardList = boardService.selectAllBoardPageList(pageVo);
		

		/***Then***/
		assertEquals(4, boardList.get("pages"));
	}
	
	@Test
	public void selectActiveBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardService.selectActiveBoard();
		
		
		/***Then***/
		assertEquals(2, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("테스트코드용");
		boardVo.setBoard_status(1);
		
		/***When***/
		int insertCnt = boardService.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("테스트코드용");
		boardVo.setBoard_status(2);
		
		/***When***/
		int updateCnt = boardService.updateBoard(boardVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
