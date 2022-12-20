package com.grang.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="message")
@SequenceGenerator(name = "USER_SEQ_GENERATOR5", sequenceName = "USER_SEQ5", allocationSize = 1)
public class Message {

	@Id
	@GeneratedValue(generator = "USER_SEQ_GENERATOR5", strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 200)
	private String content;

	@ColumnDefault("1")
	private int readCheck;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId")
	private Room room;

	@CreationTimestamp
	private Timestamp sendTime;

	@CreationTimestamp
	private Timestamp recvTime;
}
