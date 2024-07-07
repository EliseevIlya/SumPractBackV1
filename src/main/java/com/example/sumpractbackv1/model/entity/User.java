package com.example.sumpractbackv1.model.entity;

import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sumpractbackv1.model.enums.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@CreationTimestamp
	private Date createdAt;

	@Enumerated(EnumType.ORDINAL)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.getAuthorities();
	}

	

}
