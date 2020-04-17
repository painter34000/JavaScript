package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HealthModel {

	String name; // 회원정보, 핸드폰, 성별,
	String phoneNum; // 핸드폰
	String gender; // 성별
	String division; // 구분
	String birth; // 생일

	String grade;// 회원등급
	String date;// 기간

	int membership;// 회원권
	int box;// 사물함
	int cloth;// 운동복
	int sum;// 합계
	int mMoney;// 미수금

	// 조회기능
	Connection conn = null;

	public HealthModel() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<HealthModel> getHealthModel() {
		String sql = "select * from healthemp order by name desc;";
		List<HealthModel> list = getHealthModel();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, HealthModel);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				brd.setMembership(rs.getInt(membership));
				brd.setSum(rs.getInt(sum));
				brd.setCloth(rs.getInt(cloth));
				brd.setMMoney(rs.getInt(mMoney));
				brd.setBox(rs.getInt(box));
				
				brd.setName(rs.getString(name));
				brd.setPhoneNum(rs.getString(phoneNum));
				brd.setgender(rs.getString(gender));
				brd.setdivision(rs.getString(division));
				brd.setbirth(rs.getString(birth));
				brd.setgrade(rs.getString(grade));
				brd.setdate(rs.getString(date));
			
			}
			catch (SQLException e) {
				
			}
			
//			String name; // 회원정보, 핸드폰, 성별,
//			String phoneNum; // 핸드폰
//			String gender; // 성별
//			String division; // 구분
//			String birth; // 생일
//
//			String grade;// 회원등급
//			String date;// 기간
//
//			int membership;// 회원권
//			int box;// 사물함
//			int cloth;// 운동복
//			int sum;// 합계
//			int mMoney;// 미수금
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 오라클 땡겨오기 대기중

	}

	// 등록

	// 계산기능

	// 삭제

}
