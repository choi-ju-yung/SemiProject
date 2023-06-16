package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.member.model.vo.Member;
import com.semi.mypage.dao.MypageMemberDao;
import com.semi.mypage.model.vo.MemberShopPage;

public class MypageMemberService {
	private MypageMemberDao dao = new MypageMemberDao();
	
//	전체 유저 조회 메소드
	public List<Member> selectMemberAll(){
		Connection conn = getConnection();
		List<Member> list = dao.selectMemberAll(conn);
		close(conn);
		return list;
	}
	
//	아이디, 비밀번호로 유저조회
//	public Member selectByUserIdAndPw(String userId,String password) {
//		Connection conn=getConnection();
//		Member m=memDao.selectByUserIdAndPw(conn,userId,password);
//		close(conn);
//		return m;
//	}
	
// 아이디로 유저조회
	public Member selectByUserId(String userId) {
		Connection conn = getConnection();
		Member m = dao.selectByUserId(conn, userId);
		close(conn);
		return m;
	}
	
//	유저 닉네임, 상점소개글 수정
//	public int updateMember(Member m) {
//		Connection conn=getConnection();
//		int result=dao.updateMember(conn,m);
//		if(result>0) commit(conn);
//		else rollback(conn);
//		close(conn);
//		return result;
//	}
	
//	유저 프로필 이미지 수정
	public int updateProfileImg(Member m) {
		Connection conn=getConnection();
		int result=dao.updateProfileImg(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
//	닉네임으로 유저조회
	public Member selectByNickname(String nickname) {
		Connection conn = getConnection();
		Member m = dao.selectByNickname(conn, nickname);
		close(conn);
		return m;
	}
	
//	회원정보수정 -> 닉네임, 상점소개글
	public int updateMember(MemberShopPage msp) {
		Connection conn = getConnection();
		int result = dao.updateMember(conn, msp);
		close(conn);
		return result;
	}
	
	
}
