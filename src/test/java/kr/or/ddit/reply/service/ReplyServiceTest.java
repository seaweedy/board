package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyServiceTest {
	ReplyService replyService;

	@Before
	public void setup(){
		replyService = new ReplyService();
	}

	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setPost_seq(52);
		replyVo.setReply_content("댓글테스트2");
		replyVo.setUserid("brown");

		/***When***/
		int insertCnt = replyService.insertReply(replyVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void showReplyTest() {
		/***Given***/
		int post_seq = 52;
		
		/***When***/
		List<ReplyVo> replList = replyService.showReply(post_seq);
		
		/***Then***/
		assertEquals(2, replList.size());
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_seq = 8;
		
		/***When***/
		int deleteCnt = replyService.deleteReply(reply_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
