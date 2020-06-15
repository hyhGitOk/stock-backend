package com.hyh.controller;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.dto.UserDto;
import com.hyh.entity.TUser;
import com.hyh.service.UserService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Find all users
	 * 
	 * @return ResponseEntity<Iterable<TUser>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TUser>> findAll() {
		Iterable<TUser> userList = userService.findAll();
		if (CollectionUtil.isEmpty(userList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(userList);
	}

	/**
	 * Find user by id
	 * 
	 * @param id user id
	 * @return ResponseEntity<TUser>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TUser> findById(@PathVariable("id") String id) {

		TUser user = userService.findById(Integer.parseInt(id));
		if (user == null) {
			return new ResponseEntity("No user exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(user);
	}

	/**
	 * Create user
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TUser> create(@RequestBody UserDto userDto) {

		// copy values from UI
		TUser user = new TUser();
		BeanUtils.copyProperties(userDto, user);

		// set new id
		int newId = userService.getNewId();
		user.setId(newId);

		// save data
		userService.save(user);

		return ResponseEntity.ok(user);
	}

	/**
	 * Update user
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TUser> update(@RequestBody UserDto userDto) {

		int id = userDto.getId();
		if (id <= 0) {
			return new ResponseEntity("id:" + id + " is wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TUser user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity("No user exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// copy specified values from UI
		user.setEmail(userDto.getEmail());
		user.setMobile_no(userDto.getMobile_no());
		user.setPassword(userDto.getPassword());

		// save data
		userService.save(user);

		return ResponseEntity.ok(user);
	}

	/**
	 * Delete table field by field id
	 * 
	 * @param elementId element id
	 * @param request   HttpServletRequest
	 * @return StatusDto
	 * @throws IOException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		int flag = userService.deleteById(Integer.parseInt(id));

		if (flag == -1) {
			return new ResponseEntity("No user exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(id);
	}

	@RequestMapping(value = "/token/error", method = RequestMethod.GET)
	public ResponseEntity<String> tokenError() {
		return new ResponseEntity<String>("token is invalid.", HttpStatus.UNAUTHORIZED);
	}
}