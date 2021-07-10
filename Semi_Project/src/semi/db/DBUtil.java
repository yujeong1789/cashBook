package semi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	//static 초기화 블럭
	static {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}		
	}
	
        public static Connection getConnection() throws SQLException {
            //2. 데이터베이스 서버와 연결하기 위한 Connection객체 생성
            String url="jdbc:oracle:thin:@DESKTOP-25TP0SS:1521:xe";
            String user="javauser", pwd="javauser123";
            Connection con=DriverManager.getConnection(url, user, pwd);
            System.out.println("db연결 여부 con="+con);
            
            return con;
        }
	
	public static void dbClose(ResultSet rs, PreparedStatement ps,
			Connection con) throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
	}
	
	public static void dbClose(PreparedStatement ps,
			Connection con) throws SQLException {
		if(ps!=null) ps.close();
		if(con!=null) con.close();
	}
	
	
}
