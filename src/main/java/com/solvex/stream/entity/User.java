package com.solvex.stream.entity;

//User.java
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//User.java
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false, unique = true)
 private String userName;

 @Column(nullable = false)
 private String password;

 @Column(name = "user_created_times", updatable = false, insertable = false)
 private LocalDateTime userCreatedTimes;

 public Long getId() {
	return id;
 }

 public void setId(Long id) {
	this.id = id;
 }

 public String getUserName() {
	return userName;
 }

 public void setUserName(String userName) {
	this.userName = userName;
 }

 public String getPassword() {
	return password;
 }

 public void setPassword(String password) {
	this.password = password;
 }

 public LocalDateTime getUserCreatedTimes() {
	return userCreatedTimes;
 }

 public void setUserCreatedTimes(LocalDateTime userCreatedTimes) {
	this.userCreatedTimes = userCreatedTimes;
 }

 // getters and setters
 
 
}
