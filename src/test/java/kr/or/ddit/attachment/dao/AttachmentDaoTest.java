package kr.or.ddit.attachment.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.AttachmentVo;

public class AttachmentDaoTest {
	AttachmentDao attachmentDao;
	private static final Logger logger = LoggerFactory.getLogger(AttachmentDaoTest.class);

	@Before
	public void setup() {
		attachmentDao = new AttachmentDao();
	}

	@Test
	public void insertAttachmentTest() {
		/***Given***/
		AttachmentVo attachmentVo = new AttachmentVo();
		attachmentVo.setAtc_fname("test.txt");
		attachmentVo.setAtc_rfname("D:\\atch\\test.txt");
		attachmentVo.setPost_seq(7);

		/***When***/
		int insertCnt = attachmentDao.insertAttachment(attachmentVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void selectAttachmentTest() {
		/***Given***/
		int atc_seq = 83;
		
		/***When***/
		AttachmentVo attachmentVo = attachmentDao.selectAttachment(atc_seq);
		
		/***Then***/
		assertEquals(83, attachmentVo.getPost_seq());
	}
	
	@Test
	public void selectAttachmentListTest() {
		/***Given***/
		int post_seq = 76;
		
		/***When***/
		List<AttachmentVo> attachmentList = attachmentDao.selectAttachmentList(post_seq);
		
		/***Then***/
		assertEquals(3, attachmentList.size());
	}
	
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int post_seq = 7;
		
		/***When***/
		int deleteCnt = attachmentDao.deleteAttachment(post_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void deleteOneAttachmentTest() {
		/***Given***/
		int atc_seq = 39;
		
		/***When***/
		int deleteCnt = attachmentDao.deleteOneAttachment(atc_seq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	

}
