package com.grang.dto;

import com.grang.model.Board;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Data
public class uploadDto {
	private MultipartFile[] file;
	private String title;
	private String content;
	private Timestamp createTime;
	
	public Board toEntity(String title, String content, String storyImages, Timestamp createTime) {
		return Board.builder()
				.title(title)
				.content(content)
				.storyImages(storyImages)
				.createTime(createTime)
				.build();
	}

}
