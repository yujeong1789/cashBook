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
import java.util.logging.Level;
import java.util.logging.Logger;
import semi.db.DBUtil;

/**
 *
 * @author PARK YUJEONG
 */
public class incomeDAO {
    
    public int insertIncome(incomeDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            //1, 2
            con=DBUtil.getConnection();
            
            //3
            String sql="insert into income(i_no, income_kind, i_money)\n" +
                        "values(income_seq.nextval, ?, ?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, dto.getIncome_kind());
            ps.setInt(2, dto.getI_money());
            
            int cnt=ps.executeUpdate();
            System.out.println("수입등록 결과 cnt="+cnt+"매개변수 dto="+dto);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }//insertSpend
    
    
    public int deleteIncome(int no) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try {
            con=DBUtil.getConnection();
            
            String sql="delete from income where i_no=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, no);
            
            int cnt=ps.executeUpdate();
            System.out.println("수입 삭제 결과="+cnt+", 매개변수 no+"+no);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    
}
