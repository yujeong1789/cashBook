/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import semi.db.DBUtil;

/**
 *
 * @author PARK YUJEONG
 */
public class spendDAO {
    public int insertSpend(spendDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            //1, 2
            con=DBUtil.getConnection();
            
            //3
            String sql="insert into spend(s_no, spend_kind, s_money)\n" +
                            "values(spend_seq.nextval, ?, ?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, dto.getSpend_kind());
            ps.setInt(2, dto.getS_money());
            
            int cnt=ps.executeUpdate();
            System.out.println("지출등록 결과 cnt1="+cnt+"매개변수 dto="+dto);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }//insertSpend
    
    
    public int deleteSpend(int no) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try {
            con=DBUtil.getConnection();
            
            String sql="delete from spend where s_no=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, no);
            
            int cnt=ps.executeUpdate();
            System.out.println("수입 삭제 결과="+cnt+", 매개변수 _no+"+no);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }//deleteIncome

}
