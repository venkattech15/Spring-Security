package com.communication.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.communication.chat.models.MessageVo;
import com.communication.chat.service.MainService;

@RestController
public class MainController {

	@Autowired
	private MainService mainService;
   
	@PostMapping("/sent")
	public ResponseEntity<String> sendMessage(@RequestBody MessageVo messagedetails) {
		mainService.sendMessage(messagedetails);
		return new ResponseEntity<>("Sucessfully sent", HttpStatus.OK);

	}

}
