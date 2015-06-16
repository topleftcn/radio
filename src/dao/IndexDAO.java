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
	 * 查找出所有的节目表信息
	 * @return 返回一个ArrayList_Column对象
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
	 * 在数据库中删除蓝目标
	 * @param id 要删除那条数据的id
	 * @return 返回int,1 -- 成功; 0 -- 失败
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
	 * 按照页码来进行查询栏目信息
	 * @param pages 传递过来的页码
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
	 * 栏目的累加和
	 * @return 返回和
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
	 * 向栏目中插入数据
	 * @param c 传递过来的栏目信息
	 * @return 返回1--成功,0--失败
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
