package kr.or.ddit.attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.db.MybatisUtil;

public class AttachmentDao implements AttachmentDaoI{

	@Override
	public int insertAttachment(AttachmentVo attachmentVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("attachment.insertAttachment", attachmentVo);
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
	public AttachmentVo selectAttachment(int atc_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AttachmentVo attachmentVo = sqlSession.selectOne("attachment.selectAttachment", atc_seq);
		sqlSession.close();
		return attachmentVo;
	}
	
	@Override
	public List<AttachmentVo> selectAttachmentList(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<AttachmentVo> attachmentList = sqlSession.selectList("attachment.selectAttachmentList", post_seq);
		sqlSession.close();
		return attachmentList;
	}

	@Override
	public int deleteAttachment(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.delete("attachment.deleteAttachment",post_seq);
		} catch (Exception e) {
		}
		if(deleteCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int deleteOneAttachment(int atc_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.delete("attachment.deleteOneAttachment", atc_seq);
		} catch (Exception e) {
		}
		if(deleteCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

}
