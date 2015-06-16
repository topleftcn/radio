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
	 * 在数据库中删除蓝目标
	 * @param id 要删除那条数据的id
	 * @return 返回int,1 -- 成功; 0 -- 失败
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
	 * 按照页码来进行查询栏目信息
	 * @param pages 传递过来的页码
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
	 * 栏目的累加和
	 * @return 返回和
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
	 * 向栏目中插入数据
	 * @param c 传递过来的栏目信息
	 * @return 返回1--成功,0--失败
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
