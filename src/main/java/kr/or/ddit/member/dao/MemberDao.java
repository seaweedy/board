package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI {
	@Override
	public MemberVo getMember(String userid) {
		// DB에서 데이터를 조회하는 로직이 있어야하나
		// Controller기능에 집중 -> 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		// Mock (가짜)

		/*
		 * MemberVo memberVo = new MemberVo(); memberVo.setUserId("brown"); // 하드코딩
		 * memberVo.setPassword("passBrown");
		 */

		SqlSession sqlSession = MybatisUtil.getSqlSession();

		// select
		// 한 건 : selectOne
		// 여러 건 : selectList

		MemberVo memberVo = sqlSession.selectOne("member.getMember", userid);

		sqlSession.close();

		return memberVo;

	}

	@Override
	public List<MemberVo> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVo> memberList = sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		
		return memberList;
	}
	
	public List<MemberVo> selectMemberPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("member.insertMember",memberVo);
		} catch (Exception e) {
			
		}
		if(insertCnt == 1) { // 정상적으로 데이터 입력이 된 상황
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("member.deleteMember",userid);
		
		if(deleteCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("member.updateMember", memberVo);
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

}
