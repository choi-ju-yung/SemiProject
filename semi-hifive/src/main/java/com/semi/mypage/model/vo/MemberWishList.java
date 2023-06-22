package com.semi.mypage.model.vo;

import com.semi.category.model.vo.Category;
import com.semi.category.model.vo.SubCategory;
import com.semi.member.model.vo.Member;
import com.semi.productpage.model.vo.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberWishList {
	private WishList wishList;
	private Product product;
	private SubCategory subCategory;
	private Category category;
}