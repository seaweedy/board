package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public interface PostDaoI {
	List<PostVo> selectAllPost(String boardname);
	
	int insertPost(PostVo postVo);
	
	int insertAnswerPost(PostVo postVo);
	
	PostVo selectPost(int post_seq);
	
	int deletePost(PostVo postVo);
	
	List<PostVo> selectPostPageList(SqlSession sqlSession, PageVo pageVo);
	
	int selectPostTotalCnt(SqlSession sqlSession, String board_name);
	
	int updatePost(PostVo postVo);
}
