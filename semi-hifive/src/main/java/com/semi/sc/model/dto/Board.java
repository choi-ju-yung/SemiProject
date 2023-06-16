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
public class Board {
//	BOARD_NO NUMBER CONSTRAINT BOARD_NO_PK PRIMARY KEY,
//	BOARD_WRITER VARCHAR2(30) NOT NULL,
//	BOARD_TITLE	VARCHAR2(150) NOT NULL,
//	BOARD_CONTENT VARCHAR2(4000) NOT NULL,
//	BOARD_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL,
//	BOARD_CATEGORY VARCHAR2(50)	NULL,
//	NOTICE_YN CHAR(5) DEFAULT 'Y' NOT NULL,
//	BOARD_FILE VARCHAR2(2000) NULL
	private int boardNo;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private String boardCategory;
	private char noticeYn;
	private String boardOriginalFileName;
	private String boardRenamedFileName;
}