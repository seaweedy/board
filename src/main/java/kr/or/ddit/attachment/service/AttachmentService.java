package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoI;
import kr.or.ddit.attachment.model.AttachmentVo;

public class AttachmentService implements AttachmentServiceI {
	private AttachmentDaoI attachmentDao;
	
	public AttachmentService(){
		attachmentDao = new AttachmentDao();
	}
	
	@Override
	public int insertAttachment(AttachmentVo attachmentVo) {
		return attachmentDao.insertAttachment(attachmentVo);
	}

	@Override
	public AttachmentVo selectAttachment(int atc_seq) {
		return attachmentDao.selectAttachment(atc_seq);
	}

	@Override
	public int deleteAttachment(int post_seq) {
		return attachmentDao.deleteAttachment(post_seq);
	}

	@Override
	public int deleteOneAttachment(int atc_seq) {
		return attachmentDao.deleteOneAttachment(atc_seq);
	}

	@Override
	public List<AttachmentVo> selectAttachmentList(int post_seq) {
		return attachmentDao.selectAttachmentList(post_seq);
	}

}
