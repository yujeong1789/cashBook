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
import java.util.ArrayList;
import java.util.Vector;
import semi.db.DBUtil;
import java.sql.Timestamp;

/**
 *
 * @author PARK YUJEONG
 */
public class i_selectDAO {

    public ArrayList<i_selectDTO> incomeSelect(String i_regdate) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        ArrayList<i_selectDTO> list=new ArrayList<i_selectDTO>();
        
        try{
            con=DBUtil.getConnection();
            
            String sql="Select a.i_no no, B.I_Kind Kind, A.I_Money Money, A.I_REGDATE\n" +
                        "From Income A Join I_Kind B\n" +
                        "On A.Income_Kind=B.I_Kind_No\n" +
                        "Where trunc(i_Regdate)=to_date(?)\n" +
                        "Order By i_Regdate";
            ps=con.prepareStatement(sql);
            ps.setString(1, i_regdate);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int no=rs.getInt("no");
                String kind=rs.getString("kind");
                int money=rs.getInt("money");
                Timestamp regdate=rs.getTimestamp("i_regdate");
                
                i_selectDTO dto=new i_selectDTO(no, kind, money, regdate);
                list.add(dto);
            }
            System.out.println("list.size="+list.size()
                +", 매개변수 i_regdate");
            
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public Vector<String> select_i_kind() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Vector<String> list = new Vector<>();
        
        try{
            con=DBUtil.getConnection();
            
            String sql="select i_kind from i_kind";
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
    
    public i_selectDTO selectByNo_i(int i_no) throws SQLException{
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            i_selectDTO dto=new i_selectDTO();
            
            
        try {
            con=DBUtil.getConnection();
            
            String sql="Select a.i_no no, B.i_Kind Kind, A.i_Money Money, i.s_REGDATE\n" +
                        "From income A Join i_kind B\n" +
                        "On A.income_Kind=B.i_Kind_No\n" +
                        "Where i_no=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, i_no);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int no=rs.getInt("no");
                String kind=rs.getString("kind");
                int money=rs.getInt("money");
                Timestamp regdate=rs.getTimestamp("i_regdate");
                
                dto.setNo(no);
                dto.setKind(kind);
                dto.setMoney(money);
                dto.setRegdate(regdate);
            }
            System.out.println("조회 결과 dto="+dto+", 매개변수 i_no"+i_no);
            
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
     }
    
    
}
