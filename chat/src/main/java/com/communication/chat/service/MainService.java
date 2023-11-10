package com.communication.chat.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.chat.dao.MessageDao;
import com.communication.chat.models.Message;
import com.communication.chat.models.MessageVo;
import com.communication.chat.security.LoginUserContextHolder;

@Service
public class MainService {

	@Autowired
	private MessageDao messageDao;

	public MessageVo sendMessage(MessageVo messagedetails) {
		Message message = new Message();
		message.setToUserId(messagedetails.getToUserId());
		message.setValue(messagedetails.getMessage());
		message.setFromUserId(LoginUserContextHolder.getAppUserID());
		message.setSendDate(new Date());
		messageDao.saveMessage(message);
		return messagedetails;
	}
}
