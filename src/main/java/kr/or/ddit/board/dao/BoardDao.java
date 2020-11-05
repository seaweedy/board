package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	/**
	 * 
	* @author PC-08
	* 모든 board를 불러오는 메서드
	*
	 */
	@Override
	public List<BoardVo> selectAllBoardPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("board.selectAllBoardPageList",pageVo);
	}
	
	/**
	 * 
	* @author PC-08
	* 활성화 된 board를 불러오는 메서드
	*
	 */
	@Override
	public List<BoardVo> selectActiveBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.selectActiveBoard");
		sqlSession.close();
		return boardList;
	}

	/**
	 * 
	* @author PC-08
	* 새로운 board를 생성하는 메서드
	* 
	 */
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("board.insertBoard",boardVo);
		} catch (Exception e) {
		}
		if(insertCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertCnt;
	}

	/**
	 * 
	* @author PC-08
	* 게시판의 활성화상태를 변경하는 메서드
	* 
	 */
	public int updateBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		try {
			updateCnt = sqlSession.update("board.updateBoard", boardVo);
		} catch (Exception e) {
			
		}
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int selectBoardTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("board.selectBoardTotalCnt");
	}

}

