package com.mett.writeMe.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.services.LoginServiceInterface;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;
import com.mett.writeMe.services.WrittingServiceInterface;

/**
 * @author Dani
 * @author Sheng
 */
@RestController

@RequestMapping(value = "/writting")

public class WrittingController {
 @Autowired
 private WrittingServiceInterface WrittingService;
 @Autowired
 private UserHasWrittingServiceInterface UserHasWrittingService;
 @Autowired
 private LoginServiceInterface LoginService;
 private User u = new User();
 private Writting wr = new Writting();

 /**
  * @param ur
  * @return
  */
 @RequestMapping(value = "/create", method = RequestMethod.POST)
 public WrittingResponse create(@RequestBody WrittingRequest ur) {
  WrittingResponse us = new WrittingResponse();
  Boolean state = false;
  state = WrittingService.saveWritting(ur);
  WrittingPOJO w = WrittingService.getWrittingByName(ur);
  u = LoginService.getUser();
  BeanUtils.copyProperties(w, wr);
  

  if (state) {
   us.setCode(200);
   us.setCodeMessage("write created succesfully");
  }
  return us;
 }

 @RequestMapping(value = "/editContent", method = RequestMethod.POST)
 public WrittingResponse editContent(@RequestBody WrittingRequest ur) {
  WrittingResponse us = new WrittingResponse();
  WrittingPOJO w = WrittingService.getWrittingByName(ur);
  BeanUtils.copyProperties(w, wr);
  wr.setContent(ur.getWritting().getContent());
  Boolean state = WrittingService.editWritting(wr);

  if (state) {
   us.setCode(200);
   us.setCodeMessage("write created succesfully");
  }
  return us;
 }

 /**
  * @param ur
  * @return
  */
 @RequestMapping(value = "/createUserHasWritting", method = RequestMethod.POST)
 public UserHasWrittingResponse create(@RequestBody UserHasWrittingRequest ur) {
  UserHasWrittingResponse us = new UserHasWrittingResponse();
  ur.getUserHasWritting().setUser(u);
  ur.getUserHasWritting().setWritting(wr);
  System.out.println("Obra a la que estoy seteando: " + ur.getUserHasWritting().getWritting().getWrittingId());
  Boolean state = UserHasWrittingService.save(ur);

  if (state) {
   us.setCode(200);
   us.setCodeMessage("write created succesfully");
  }
  return us;
 }
}