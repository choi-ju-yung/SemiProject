package com.semi.sc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardFile {
	private int boardNo;
	private int fileNo;
	private String boardFileName;
}
