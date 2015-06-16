package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Bottom;
import entity.Column;
import entity.Index;

public class BottomDAO extends BaseDAO{
	/**
	 * �����ݿ���ɾ����Ŀ��
	 * @param id Ҫɾ���������ݵ�id
	 * @return ����int,1 -- �ɹ�; 0 -- ʧ��
	 */
	public int deleteBottom(int id){
		String sql = "DELETE FROM `bottom` WHERE id = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			try {
				if( pstmt!=null) pstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���ҳ����еĽ�Ŀ����Ϣ
	 * @return ����һ��ArrayList_Column����
	 */
	public ArrayList<Bottom> findAllBottom(){

		String sql = "SELECT * FROM `bottom`";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Bottom> list = new ArrayList<Bottom>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Bottom b = new Bottom();
				b.setId( rs.getInt("id") );
				b.setAbout( rs.getString("about") );
				b.setPhonenumber( rs.getString("phonenumber"));
				b.setTwittwr(rs.getString("twittwr"));
				b.setYear(rs.getString("year"));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if( pstmt!=null) pstmt.close();
				if( conn != null ) conn.close();
				if( rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int update(int id,String phonenumber,String about,String year,String twittwr){
		String sql = "UPDATE `bottom` SET phonenumber=?,about=?,year=?,twittwr=? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phonenumber );
			pstmt.setString(2, about );
			pstmt.setString(3, year );
			pstmt.setString(4, twittwr );
			pstmt.setInt(5, id);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			try {
				if( pstmt!=null) pstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
