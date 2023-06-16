package com.semi.member.service;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;


import com.semi.member.dao.MemberDao;
import com.semi.member.model.vo.Member;



public class MemberService {
   private MemberDao dao = new MemberDao();
   
   public Member selectByUserIdAndPw(String userId, String password) {
      Connection conn=getConnection(); // jdbc 연결객체
      Member m=dao.selectByUserIdAndPw(conn,userId,password);
      close(conn);
      return m;
   }
   
   
   public int insertMember(Member m) {
      Connection conn = getConnection();
      int result = dao.insertMember(conn,m);
      if(result>0)commit(conn);
      else rollback(conn);
      close(conn);
      return result;
   }
   
}