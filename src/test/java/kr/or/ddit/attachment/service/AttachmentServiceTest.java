package kr.or.ddit.attachment.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.AttachmentVo;

public class AttachmentServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceTest.class);
	AttachmentService attachmentService;
	
	@Before
	public void setup() {
		attachmentService = new AttachmentService();
	}

	@Test
	public void insertAttachmentTest() {
		/***Given***/
		AttachmentVo attachmentVo = new AttachmentVo();
		attachmentVo.setAtc_fname("test.txt");
		attachmentVo.setAtc_rfname("D:\\atch\\test.txt");
		attachmentVo.setPost_seq(7);

		/***When***/
		int insertCnt = attachmentService.insertAttachment(attachmentVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void selectAttachmentTest() {
		/***Given***/
		int atc_seq = 83;
		
		/***When***/
		AttachmentVo attachmentVo = attachmentService.selectAttachment(atc_seq);
		
		/***Then***/
		assertEquals(atc_seq, attachmentVo.getAtc_seq());
	}
	
	@Test
	public void selectAttachmentListTest() {
		/***Given***/
		int post_seq = 77;
		
		/***When***/
		List<AttachmentVo> attachmentList = attachmentService.selectAttachmentList(post_seq);
		
		/***Then***/
		assertEquals(2, attachmentList.size());
	}
	
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int post_seq = 7;
		
		/***When***/
		int deleteCnt = attachmentService.deleteAttachment(post_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void deleteOneAttachmentTest() {
		/***Given***/
		int atc_seq = 41;
		
		/***When***/
		int deleteCnt = attachmentService.deleteOneAttachment(atc_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
