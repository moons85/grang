package com.grang.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="reply")
@SequenceGenerator(name = "USER_SEQ_GENERATOR3", sequenceName = "USER_SEQ3", allocationSize = 1)
public class Reply {

	@Id
	@GeneratedValue(generator = "USER_SEQ_GENERATOR3", strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "boardId")
	private Board board;
	
	@CreationTimestamp
	private Timestamp createTime;
}
