package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.News;
import entity.Song;

public class SongDAO extends BaseDAO{

	/**
	 * 查找出所有的新闻信息
	 * @return 返回一个ArrayList_News对象
	 */
	public ArrayList<Song> findAllSong(){

		String sql = "SELECT * FROM `song` WHERE type=1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Song> list = new ArrayList<Song>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Song s = new Song();
				s.setId( rs.getInt("id") );
				s.setSongName( rs.getString("songname") );
				s.setContent( rs.getString("content") );
				s.setRevicer( rs.getString("reveicer") );
				s.setSender( rs.getString("sender") );
				s.setInserttime( rs.getString("inserttime") );
				list.add(s);
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
	 * 在数据库中删除蓝目标
	 * @param id 要删除那条数据的id
	 * @return 返回int,1 -- 成功; 0 -- 失败
	 */
	public int deleteSong(int id){
		String sql = "DELETE FROM `song` WHERE id = ?";
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
	public ArrayList<Song> findAllSong(int pages){
		String sql = "SELECT * FROM `song` LIMIT ?,8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Song> list = new ArrayList<Song>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*8 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Song s = new Song();
				s.setId( rs.getInt("id") );
				s.setSongName( rs.getString("songname") );

				if( rs.getString("content")!=null )
					if(rs.getString("content").length()>8)
						s.setContent( rs.getString("content").substring(0,8));
					else
						s.setContent( rs.getString("content") );

				s.setRevicer( rs.getString("reveicer") );
				s.setSender( rs.getString("sender") );
				s.setInserttime( rs.getString("inserttime") );
				s.setType( rs.getInt("type"));
				list.add(s);
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
	
	public ArrayList<Song> findAllSong1(int pages){
		String sql = "SELECT * FROM `song` LIMIT ?,5";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Song> list = new ArrayList<Song>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*5 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Song s = new Song();
				s.setId( rs.getInt("id") );
				s.setSongName( rs.getString("songname") );
			    s.setContent( rs.getString("content") );
				s.setRevicer( rs.getString("reveicer") );
				s.setSender( rs.getString("sender") );
				s.setInserttime( rs.getString("inserttime") );
				s.setType( rs.getInt("type"));
				list.add(s);
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
		String sql = "SELECT count(*) AS total FROM `song` WHERE type=1";
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
	public int SongInsert(Song s){

		String sql = "INSERT INTO `song` VALUES(NULL,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getSongName() );
			pstmt.setString(2, s.getContent() );
			pstmt.setString(3, s.getRevicer() );
			pstmt.setString(4, s.getSender() );
			pstmt.setString(5, s.getInserttime() );
			pstmt.setInt(6, s.getType() );
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

	/**
	 * 
	 * @param type
	 * @param title
	 * @param content
	 * @param picture
	 * @return
	 */
	public int update(int id){
		String sql = "UPDATE song SET `type`= 1 WHERE id=?";
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
}
