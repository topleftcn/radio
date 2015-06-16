package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.News;

public class NewsDAO extends BaseDAO{

	/**
	 * 查找出所有的新闻信息
	 * @return 返回一个ArrayList_News对象
	 */
	public ArrayList<News> findAllNews(){

		String sql = "SELECT * FROM `news` ORDER BY `id` DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<News> list = new ArrayList<News>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				News n = new News();
				n.setId( rs.getInt("id") );
				n.setType( rs.getInt("type") );
				n.setTitle( rs.getString("title") );
				n.setContent( rs.getString("content") );
				n.setPicture( rs.getString("picture") );
				n.setInserttime( rs.getString("inserttime") );
				list.add(n);
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
	
	public News findAllNews1(int id){

		String sql = "SELECT * FROM `news` WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		News n = new News();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				n.setId( rs.getInt("id") );
				n.setType( rs.getInt("type") );
				n.setTitle( rs.getString("title") );
				n.setContent( rs.getString("content") );
				n.setPicture( rs.getString("picture") );
				n.setInserttime( rs.getString("inserttime") );
			}
			return n;
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
	 * 在数据库中删除蓝目标
	 * @param id 要删除那条数据的id
	 * @return 返回int,1 -- 成功; 0 -- 失败
	 */
	public int deleteNews(int id){
		String sql = "DELETE FROM `news` WHERE id = ?";
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
	public ArrayList<News> findAllNews(int pages){
		String sql = "SELECT * FROM `news` ORDER BY `id` DESC LIMIT ?,8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<News> list = new ArrayList<News>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*8 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				News n = new News();
				n.setId( rs.getInt("id") );
				n.setType( rs.getInt("type") );
				n.setTitle( rs.getString("title") );
				n.setContent( rs.getString("content") );
				n.setPicture( rs.getString("picture") );
				n.setInserttime( rs.getString("inserttime") );
				list.add(n);
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
		String sql = "SELECT count(*) AS total FROM `news`";
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
	public int NewsInsert(News c){
		
		String sql = "INSERT INTO `news` VALUES(NULL,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getType() );
			pstmt.setString(2, c.getTitle() );
			pstmt.setString(3, c.getContent() );
			pstmt.setString(4, c.getPicture() );
			pstmt.setString(5, c.getInserttime() );
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
