package com.semi.product.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	private int productId;
	private String userId;
	private String producttitle;
	private String productstatus;
	private String sellstatus;
	private int price;
	private Date registtime;
	private long elapsedtime;
	private int viewcount;
	private String explanation;
	private String keyword;
	private int subcategoryid;
	private int goonguareaid;
	
}
