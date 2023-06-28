package com.semi.main.model.vo;

import com.semi.product.model.vo.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductElapsedTime {
	private Product product;
	private long elapsedTime;
}
