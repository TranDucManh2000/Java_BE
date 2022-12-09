package com.hibernate.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.java.model.UsersModel;
import com.hibernate.java.pojo.Users;
import com.hibernate.java.service.UsersService;
import com.hibernate.java.service.impl.JwtTokenProvider;

@RestController
@RequestMapping("/user")
public class UsersController {

	UsersService userDAO = UsersService.createInstance();

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@GetMapping
	public List<Users> getUser() {
		return userDAO.getUser();
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/login")
	public String posUsers(@RequestBody UsersModel usersRequesModel,
			@RequestHeader(value = "Authorization") String token) {
		List<Users> user = userDAO.getAuthen(usersRequesModel.getEmail(), usersRequesModel.getPassword());
		System.out.print(jwtTokenProvider.getUserIdFromJWT(token));
		return jwtTokenProvider.generateToken(user.get(0).getEmail());
	}
}
