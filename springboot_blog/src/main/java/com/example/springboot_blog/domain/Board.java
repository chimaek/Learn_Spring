package com.example.springboot_blog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ColumnDefault("0")
    private int countView;

    @ManyToOne // many =board , one = user
    @JoinColumn(name = "userId")
    private User userId; // db에서는 오브젝트를 저장할 수 없는데 jpa를 사용하면 코드에서 참조 테이블 정의가능

    @CreationTimestamp
    private Timestamp timestamp;
}


