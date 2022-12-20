package com.grang.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "room", uniqueConstraints = {@UniqueConstraint(name = "constraintName", columnNames = {"sendId", "recvId"})})
@SequenceGenerator(name = "USER_SEQ_GENERATOR4", sequenceName = "USER_SEQ4", allocationSize = 1)
public class Room {

    @Id
    @GeneratedValue(generator = "USER_SEQ_GENERATOR4", strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sendId")
    private User sendUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recvId")
    private User recvUser;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    private List<Message> messages;

    @CreationTimestamp
    private Timestamp timestamp;
}
