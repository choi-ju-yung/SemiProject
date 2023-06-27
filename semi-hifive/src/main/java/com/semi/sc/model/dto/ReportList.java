package com.semi.sc.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportList {

	private int reportListNo;
	private int reportNo;
	private int productId;
	private int tradeId;
	private String userId;
	private String reportedUserId;
}
