package com.semi.productlist.model.service;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.List;
import com.semi.productlist.model.vo.ProductCategoryList;
import com.semi.productlist.model.vo.ProductCategoryTimeList;
import com.semi.productlistlist.model.dao.ProductCategoryListDao;


public class ProductCategoryListService {
	private ProductCategoryListDao dao = new ProductCategoryListDao();
//	전체 상품리스트 가져오기 카테고리, 세부카테고리 모두 join해서 가져온것	
	public List<ProductCategoryTimeList> CategoryProductList(int cPage, int numPerpage){
		Connection conn = getConnection();
		List<ProductCategoryTimeList> list = dao.CategoryProductList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
//	전체 상품리스트 가져오기 카테고리, 세부카테고리 모두 join해서 가져온것 페이징처리 	
	public int CategoryProductListCount() {
		Connection conn = getConnection();
		int result = dao.CategoryProductListCount(conn);
		close(conn);
		return result;
	}
	// 선택한 상품페이지상세페이지로 이동 메소드
	public ProductCategoryTimeList SelectProduct(int productId) {
		Connection conn = getConnection();
		ProductCategoryTimeList p = dao.SelectProduct(conn, productId);
		close(conn);
		return p;
	}
	
	//서브카테고리 이름을 상품 리스트 찾아서 가져오기
	public List<ProductCategoryTimeList> SelectSubCategoryList(int cPage, int numPerpage ,String subcategoryname) {
		Connection conn = getConnection();
		List<ProductCategoryTimeList> p = dao.SelectSubCategoryList(conn, cPage, numPerpage, subcategoryname);
		close(conn);
		return p;
	}
	//서브카테고리 이름을 상품 리스트 찾아서 가져오기 페이징처리
	public int SelectSubCategoryProductListCount(String subcategoryname){
		Connection conn = getConnection();
		int result = dao.SelectSubCategoryProductListCount(conn, subcategoryname);
		close(conn);
		return result;
	}
	//대표카테고리 선택시 대표카테고리 상품리스트 출력
	public List<ProductCategoryTimeList> CategoryList(int cPage, int numPerpage, String categoryname) {
			Connection conn = getConnection();
			List<ProductCategoryTimeList> categorylist = dao.CategoryList(conn, cPage, numPerpage, categoryname);
			close(conn);
			return categorylist;
	}
	//대표카테고리 선택시 대표카테고리 상품리스트 출력 페이징처리
	public int CategoryCount(String categoryname) {
			Connection conn = getConnection();
			int selectcategory = dao.CategoryCount(conn, categoryname);
			close(conn);
			return selectcategory;
	}
	
}