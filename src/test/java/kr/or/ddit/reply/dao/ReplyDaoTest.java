package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDaoTest {
	RePlyDao replyDao;
	@Before
	public void setup() {
		replyDao = new RePlyDao();
	}

	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setPost_seq(52);
		replyVo.setReply_content("댓글테스트");
		replyVo.setUserid("brown");

		/***When***/
		int insertCnt = replyDao.insertReply(replyVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void showReplyTest() {
		/***Given***/
		int post_seq = 52;
		
		/***When***/
		List<ReplyVo> replList = replyDao.showReply(post_seq);
		
		/***Then***/
		assertEquals(1, replList.size());
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_seq = 7;
		
		/***When***/
		int deleteCnt = replyDao.deleteReply(reply_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
