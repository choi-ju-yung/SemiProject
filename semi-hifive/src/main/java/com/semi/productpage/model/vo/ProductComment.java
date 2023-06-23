package com.semi.productpage.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductComment {
	
	private String userId;
	private int productId;
	private String nickName;
	private int commentNo;
	private int commentLevel;
	private String content;
	private int commentRef;
	private Date enrollDate;
	private int commentCount;

}

