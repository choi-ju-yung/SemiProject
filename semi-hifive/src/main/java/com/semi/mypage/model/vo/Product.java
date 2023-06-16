package com.semi.mypage.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	private int productId;
	private String userId;
	private String productTitle;
	private String productStatus;
	private String sellStatus;
	private int price;
	private Date registTime;
	private int viewCount;
	private String explanation;
	private String keyword;
	private int subcategoryId;
	private int goonguareaId;
}


//public class JoinTableDTO {
//    private int id;
//    private String name;
//    private String email;
//    private DepartmentDTO department;
//    private PositionDTO position;