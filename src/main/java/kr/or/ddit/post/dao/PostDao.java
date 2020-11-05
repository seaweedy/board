package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoI{
	private static final Logger logger = LoggerFactory.getLogger(PostDao.class);

	@Override
	public List<PostVo> selectAllPost(String boardname) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("post.selectAllPost", boardname);
		sqlSession.close();
		return postList;
	}

	@Override
	public int insertPost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("post.insertPost", postVo);
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

	@Override
	public PostVo selectPost(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("post.selectPost", post_seq);
		sqlSession.close();
		return postVo;
	}

	@Override
	public int deletePost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
			deleteCnt = sqlSession.update("post.deletePost", postVo);
		if(deleteCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}
	
	public List<PostVo> selectPostPageList(SqlSession sqlSession, PageVo pageVo){
		return sqlSession.selectList("post.selectPostPageList",pageVo);
	}

	@Override
	public int selectPostTotalCnt(SqlSession sqlSession, String board_name) {
		return sqlSession.selectOne("post.selectPostTotalCnt",board_name);
	}

	@Override
	public int updatePost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updatePost = 0;
		try {
			updatePost = sqlSession.update("post.updatePost", postVo);
		} catch (Exception e) {
		}
		if(updatePost == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updatePost;
	}

	@Override
	public int insertAnswerPost(PostVo postVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("post.insertAnswerPost", postVo);
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
}
