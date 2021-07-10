/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;
import semi.db.DBUtil;

/**
 *
 * @author PARK YUJEONG
 */
public class s_selectDAO {
    
    public ArrayList<s_selectDTO> spendSelect(String s_regdate) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        ArrayList<s_selectDTO> list=new ArrayList<s_selectDTO>();
        
        try {
            con=DBUtil.getConnection();
            
            String sql = "Select a.s_no no, B.s_Kind Kind, A.s_Money Money, A.s_REGDATE\n" +
                        "From spend A Join s_kind B\n" +
                        "On A.spend_Kind=B.s_Kind_No\n" +
                        "Where trunc(s_Regdate)=to_date(?)\n" +
                        "Order By s_Regdate";
            ps=con.prepareStatement(sql);
            ps.setString(1, s_regdate);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int no=rs.getInt("no");
                String kind=rs.getString("kind");
                int money=rs.getInt("money");
                Timestamp regdate=rs.getTimestamp("s_regdate");
                
                s_selectDTO dto=new s_selectDTO(no, kind, money, regdate);
                list.add(dto);
            }
            System.out.println("list.size="+list.size()
                    +", 매개변수 s_regdate");
            
            return list;
        } finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    
     public Vector<String> select_s_kind() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Vector<String> list = new Vector<>();
        
        try{
            con=DBUtil.getConnection();
            
            String sql="select s_kind from s_kind";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                String i_kind=rs.getString(1);
                list.add(i_kind);
            }
            System.out.println("항목 조회 결과 list.size"+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
     
     public s_selectDTO selectByNo_s(int s_no) throws SQLException{
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            s_selectDTO dto=new s_selectDTO();
            
        try {
            con=DBUtil.getConnection();
            
            String sql="Select a.s_no no, B.s_Kind Kind, A.s_Money Money, A.s_REGDATE\n" +
                        "From spend A Join s_kind B\n" +
                        "On A.spend_Kind=B.s_Kind_No\n" +
                        "Where s_no=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, s_no);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int no=rs.getInt("no");
                String kind=rs.getString("kind");
                int money=rs.getInt("money");
                Timestamp regdate=rs.getTimestamp("s_regdate");
                
                dto.setNo(no);
                dto.setKind(kind);
                dto.setMoney(money);
                dto.setRegdate(regdate);
            }
            System.out.println("조회 결과 dto="+dto+", 매개변수 s_no"+s_no);
            
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
     }
}
