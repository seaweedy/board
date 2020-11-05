package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.PostVo;

public class PostDaoTest {
	PostDao postDao;
	
	@Before
	public void setup() {
		postDao = new PostDao();
	}

	@Test
	public void selectAllPostTest() {
		/***Given***/
		String boardname = "테스트";

		/***When***/
		List<PostVo> postList = postDao.selectAllPost(boardname);

		/***Then***/
		assertEquals(1, postList.size());
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("테스트내용");
		postVo.setPost_title("테스트제목");
		postVo.setUserid("brown");
		
		/***When***/
		int insertCnt = postDao.insertPost(postVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void selectPostTest() {
		/***Given***/
		int post_seq = 50;
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("테스트내용");
		postVo.setPost_title("테스트제목");
		postVo.setUserid("brown");
		
		/***When***/
		int insertCnt = postDao.insertPost(postVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int post_seq = 50;
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_seq(post_seq);
		
		/***When***/
		int deleteCnt = postDao.deletePost(postVo);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void selectPostPageListTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(1);
		pageVo.setBoard_name("테스트");
		
		/***When***/
		List<PostVo> postList = postDao.selectPostPageList(sqlSession, pageVo);
		
		/***Then***/
		assertEquals(1, postList.size());
	}
	
	@Test
	public void selectPostTotalCntTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String board_name = "테스트";
		
		/***When***/
		int postTotalCnt = postDao.selectPostTotalCnt(sqlSession, board_name);
		
		/***Then***/
		assertEquals(2, postTotalCnt);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("수정!!");
		postVo.setPost_title("수정!!!");
		postVo.setUserid("brown");
		postVo.setPost_seq(50);
		
		/***When***/
		int updateCnt = postDao.updatePost(postVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void insertAnswerPostTest() {
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("수정!!의 답글");
		postVo.setPost_title("수정!!!의 답글내용");
		postVo.setUserid("brown");
		postVo.setPost_parent(50);
		
		/***When***/
		int insertCnt = postDao.insertAnswerPost(postVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
	
	

}
