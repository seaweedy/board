package kr.or.ddit.post.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.PostVo;

public class PostServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	PostService postService;
	
	@Before
	public void setup() {
		postService = new PostService();
	}

	@Test
	public void selectAllPostTest() {
		/***Given***/
		String boardname = "테스트";

		/***When***/
		List<PostVo> postList = postService.selectAllPost(boardname);

		/***Then***/
		assertEquals(3, postList.size());
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("테스트내용2");
		postVo.setPost_title("테스트제목2");
		postVo.setUserid("brown");
		
		/***When***/
		int insertCnt = postService.insertPost(postVo);
		
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
		int insertCnt = postService.insertPost(postVo);
		
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
		int deleteCnt = postService.deletePost(postVo);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void selectPostPageListTest() {
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(1);
		pageVo.setBoard_name("테스트");
		
		/***When***/
		Map<String, Object> postList = postService.selectPostPageList(pageVo);
		logger.debug("postlis : {}", postList);
		
		/***Then***/
		assertEquals(3, postList.size());
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		int post_seq = 50;
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("테스트내용2");
		postVo.setPost_title("테스트제목2");
		postVo.setPost_seq(post_seq);
		postVo.setUserid("brown");
		
		/***When***/
		int updateCnt = postService.updatePost(postVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void insertAnswerPostTest() {
		/***Given***/
		int post_parent = 50;
		PostVo postVo = new PostVo();
		postVo.setBoard_name("테스트");
		postVo.setPost_content("테스트내용2의 답글");
		postVo.setPost_title("테스트제목2의 답글내용");
		postVo.setPost_parent(post_parent);
		postVo.setUserid("brown");
		
		/***When***/
		int insertAnswerCnt = postService.insertAnswerPost(postVo);
		
		/***Then***/
		assertEquals(1, insertAnswerCnt);
	}

}
