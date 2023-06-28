package com.semi.main.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.main.model.vo.ProductElapsedTime;
import com.semi.member.model.vo.Member;
import com.semi.mypage.dao.MypageMemberDao;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.ProductFile;

public class MainDao {
	private Properties sql = new Properties();
	
	public MainDao() {
		String path = MypageMemberDao.class.getResource("/sql/main/mainPage.properties").getPath();
		try(FileReader fr = new FileReader(path)){
			sql.load(fr);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 인기상품
	public List<ProductElapsedTime> productListAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductElapsedTime> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("productListAll"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getPet(rs));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} return list;
	}
	
	// 최신상품
	public List<ProductElapsedTime> productListNew(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductElapsedTime> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("productListNew"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getPet(rs));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} return list;
	}
	
	public ProductElapsedTime getPet(ResultSet rs) throws SQLException{
	    return ProductElapsedTime.builder()
	            .product(Product.builder()
	                    .productId(rs.getInt("product_Id"))
	                    .title(rs.getString("product_Title"))
	                    .productStatus(rs.getString("product_Status"))
	                    .sellStatus(rs.getString("sell_Status"))
	                    .price(rs.getInt("price"))
	                    .viewCount(rs.getInt("view_Count"))
	                    .build())
	            .elapsedTime(rs.getLong("elapsed_time"))
	            .productFile(ProductFile.builder()
	            		.imageName(rs.getString("product_image_name")).build())
	            .build();
	}
}
