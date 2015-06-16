package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.News;
import entity.Tyfc;

public class TyfcDAO extends BaseDAO{


	/**
	 * �����ݿ���ɾ����Ŀ��
	 * @param id Ҫɾ���������ݵ�id
	 * @return ����int,1 -- �ɹ�; 0 -- ʧ��
	 */
	public int deleteTyfc(int id){
		String sql = "DELETE FROM `member` WHERE id = ?";
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
	 * ����ҳ�������в�ѯ��Ŀ��Ϣ
	 * @param pages ���ݹ�����ҳ��
	 * @return
	 */
	public ArrayList<Tyfc> findAllTyfc(int pages){
		String sql = "SELECT * FROM `member` WHERE `type` = 1 LIMIT ?,3";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Tyfc> list = new ArrayList<Tyfc>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*3 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Tyfc t = new Tyfc();
				t.setId( rs.getInt("id") );
				t.setType( rs.getInt("type") );
				t.setTitle( rs.getString("title") );
				t.setContent( rs.getString("content") );
				t.setPicture( rs.getString("picture") );
				t.setInserttime( rs.getString("inserttime") );
				list.add(t);
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
	
	public ArrayList<Tyfc> findAllTyfc(){
		String sql = "SELECT * FROM `member` WHERE `type` = 0";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Tyfc> list = new ArrayList<Tyfc>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Tyfc t = new Tyfc();
				t.setId( rs.getInt("id") );
				t.setType( rs.getInt("type") );
				t.setTitle( rs.getString("title") );
				t.setContent( rs.getString("content") );
				t.setPicture( rs.getString("picture") );
				t.setInserttime( rs.getString("inserttime") );
				list.add(t);
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
	
	/**
	 * ��Ŀ���ۼӺ�
	 * @return ���غ�
	 */
	public int getTotal(){
		String sql = "SELECT count(*) AS total FROM `member`";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int index = 0;
			if( rs.next() )
				index =  rs.getInt("total");
			return index;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
	
	/**
	 * ����Ŀ�в�������
	 * @param c ���ݹ�������Ŀ��Ϣ
	 * @return ����1--�ɹ�,0--ʧ��
	 */
	public int TyfcInsert(Tyfc t){
		
		String sql = "INSERT INTO `member` VALUES(NULL,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, t.getType() );
			pstmt.setString(2, t.getTitle() );
			pstmt.setString(3, t.getContent() );
			pstmt.setString(4, t.getPicture() );
			pstmt.setString(5, t.getInserttime() );
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
}
