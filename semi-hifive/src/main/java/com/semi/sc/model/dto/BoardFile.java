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
	private String boardPath;
	private String fileNo;
	private String boardFileName;
}
