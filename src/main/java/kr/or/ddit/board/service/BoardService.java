package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardService implements BoardServiceI{
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	private BoardDaoI boardDao;
	
	public BoardService(){
		boardDao=new BoardDao();
	}

	/**
	 * 
	* @author PC-08
	* 모든 board를 불러오는 메서드
	*
	 */
	@Override
	public Map<String, Object> selectAllBoardPageList(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardDao.selectAllBoardPageList(sqlSession, pageVo));
		
		int totalCnt = boardDao.selectBoardTotalCnt(sqlSession);
		int pages = (int)Math.ceil((double)totalCnt/pageVo.getPageSize());
		
		map.put("pages", pages);
		sqlSession.close();
		return map;
	}
	
	/**
	 * 
	* @author PC-08
	* 활성화 된 board를 불러오는 메서드
	*
	 */
	@Override
	public List<BoardVo> selectActiveBoard() {
		return boardDao.selectActiveBoard();
	}
	
	/**
	 * 
	* @author PC-08
	* 새로운 board를 생성하는 메서드
	* 
	 */
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	/**
	 * 
	* @author PC-08
	* 게시판의 활성화상태를 변경하는 메서드
	*
	 */
	@Override
	public int updateBoard(BoardVo boardVo) {
		logger.debug("서비스객체");
		return boardDao.updateBoard(boardVo);
	}
}
