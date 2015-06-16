package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Column;
import entity.Index;

public class IndexDAO extends BaseDAO{
	/**
	 * ���ҳ����еĽ�Ŀ����Ϣ
	 * @return ����һ��ArrayList_Column����
	 */
	public ArrayList<Index> findAllIndex(){
		String sql = "SELECT * FROM `index` ORDER BY `id` desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Index> list = new ArrayList<Index>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Index c = new Index();
				c.setId( rs.getInt("id") );
				c.setInserttime( rs.getString("inserttime") );
				c.setEnglish( rs.getString("english"));
				c.setZhongwen( rs.getString("zhongwen"));
				c.setGonggao(rs.getString("gonggao"));
				list.add(c);
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
	 * �����ݿ���ɾ����Ŀ��
	 * @param id Ҫɾ���������ݵ�id
	 * @return ����int,1 -- �ɹ�; 0 -- ʧ��
	 */
	public int deleteIndex(int id){
		String sql = "DELETE FROM `index` WHERE id = ?";
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
	public ArrayList<Index> findAllIndex(int pages){
		String sql = "SELECT * FROM `index` ORDER BY `id` desc LIMIT ?,3";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Index> list = new ArrayList<Index>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*3 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Index c = new Index();
				c.setId( rs.getInt("id") );
				c.setInserttime( rs.getString("inserttime") );
				
				if( rs.getString("english")!=null )
					if(rs.getString("english").length()>20)
						c.setEnglish( rs.getString("english").substring(0,20) );
				else
					c.setEnglish( rs.getString("english"));
				
				if( rs.getString("zhongwen")!=null  )
					if(rs.getString("zhongwen").length()>5)
						c.setZhongwen( rs.getString("zhongwen").substring(0,5) );
				else
					c.setZhongwen( rs.getString("zhongwen"));
				
				if( rs.getString("gonggao")!=null  )
					if( rs.getString("gonggao").length()>5)
						c.setGonggao(rs.getString("gonggao").substring(0,5) );
				else
					c.setGonggao(rs.getString("gonggao"));
				list.add(c);
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
		String sql = "SELECT count(*) AS total FROM `index`";
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
	public int IndexInsert(Index c){
		String sql = "INSERT INTO `index` VALUES(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getEnglish() );
			pstmt.setString(2, c.getGonggao() );
			pstmt.setString(3, c.getInserttime());
			pstmt.setString(4, c.getZhongwen());
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
