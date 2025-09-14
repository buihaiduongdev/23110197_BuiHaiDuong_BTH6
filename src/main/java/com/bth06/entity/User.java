package com.bth06.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50, nullable = false, unique = true)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(length = 100, columnDefinition = "NVARCHAR(100)")
	private String fullName;

	@Column(length = 100)
	private String email;

	@Column(length = 20)
	private String role;
}
