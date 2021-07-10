/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import semi.db.DBUtil;

/**
 *
 * @author STU
 */
public class memberDAO {
    
    public int loginCheck(String m_id, String m_pwd) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        int result=0;
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select m_pwd from accmember where m_id=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, m_id);
            
            //4
            rs=ps.executeQuery();
            if(rs.next()){
                String dbPwd=rs.getString(1);
                if(dbPwd.equals(m_pwd)){
                    result=memberService.LOGIN_OK;
                }else{
                    result=memberService.PWD_DISAGREE;                    
                }
            }else{
                result=memberService.USERID_NONE;                                    
            }
            System.out.println("로그인 처리 결과, result="+result+", 매개변수 m_id="+m_id+", m_pwd="+m_pwd);
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }//
    
    public int insertMember(memberDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            con=DBUtil.getConnection();
            
            //3 ps
            String sql="insert into accmember(m_no, m_name, m_id, m_pwd)" +
                " values(accmember_seq.nextval, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getM_name());
            ps.setString(2, dto.getM_id());
            ps.setString(3, dto.getM_pwd());
            
            int cnt=ps.executeUpdate();
            System.out.println("회원가입결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
        
    }//
    
    
    public int checkm_id(String m_id) throws SQLException{
        //아이디 중복확인
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select count(*) from accmember where m_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, m_id);
            
            //4
            rs=ps.executeQuery();
            if(rs.next()){
                int count=rs.getInt(1);
                if(count>0){  //이미 존재=>사용불가
                    result=memberService.NONE_USABLE_ID;
                }else{ //사용 가능
                    result=memberService.USABLE_ID;                    
                }
            }
            System.out.println("아이디중복확인 결과 result="+result+", 매개변수 m_id="+m_id);
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
