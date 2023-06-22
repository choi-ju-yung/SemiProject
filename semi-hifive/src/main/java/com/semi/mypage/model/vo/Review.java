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
public class Review {
	private int reviewId;
	private int tradeId;
	private int reviewScore;
	private String reviewMsg;
	private Date reviewDate;
}