package com.doil.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository<Entity클래스, PK타입> -> 기본 CRUD 메소드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
