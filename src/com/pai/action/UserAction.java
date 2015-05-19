package com.pai.action;

import java.util.List;
import java.util.Map;
import java.lang.Exception;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

  

import com.stub.SSDLogin.*;
import com.pai.biz.UserBiz;
import com.pai.entity.User;

@Controller
@Action(value = "UserAction", results = {
		@Result(name = "index", location = "/index.jsp") }
       )
/*@RequestMapping("/user")*/
/*@SessionAttributes("user") */
public class UserAction  extends ActionSupport implements RequestAware,SessionAware         {
      @Autowired 
      private UserBiz userBiz;
  	  public void setSerivce(UserBiz userSerivce) {
		this.userBiz = userSerivce;
	  }
	  public UserBiz getSerivce() {
		return userBiz;
	  }
	  
	  String passWord;
	  public void setPassWord(String passWord) {
		 this.passWord = passWord;
	  }
	  public String getPassWord() {
		return passWord;
	  }


	String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}

	  
	/*  @RequestMapping(value="/toList",method=RequestMethod.GET)
	  public ModelAndView tolist() throws Exception{
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("NewFile");
		  List<User> users =  userBiz.selectUser();
		  mv.addObject("users", users);
	
		  return mv;
	  }
	  
	  @RequestMapping(value="/toEdit",method=RequestMethod.GET)
	  public ModelAndView toEdit(
			  @RequestParam(value="userId",required=true) Integer userId )  throws Exception {
		  User user =  userBiz.getUserByUserId(userId);
		  
		  
	 	  ModelAndView mv = new ModelAndView();
	      mv.addObject("user", user);
	 	  mv.setViewName("edit");
		  
		   return mv;
	  }
	
	  @RequestMapping(value="/doEdit",method=RequestMethod.GET)
	  public String doEdit(
			  @RequestParam(value="userId",required=true) Integer userId ,
			  @RequestParam(value="passWord",required=true) String passWord ,
			  @RequestParam(value="userName",required=true) String userName )  
      throws Exception {
		  
	 //	  ModelAndView mv = new ModelAndView();
	 	  User user =  new User(userId, userName, passWord);
	 	  boolean res  = userBiz.updateUser(user);
	 	 
	 	  if( res){
	 		 return "redirect:/user/toList.do";
	 	  }else
	 	  {
	 		 return "error"; 
	 	  }

	  }*/
	  
/*	  @RequestMapping(value="/doLogin",method=RequestMethod.GET)*/
	  public String doLogin(
		  )  
					  throws Exception {
		/*  User user =  userSerivce.getUserByUserId(userId);*/
		 
		/*  ModelAndView mv = new ModelAndView();*/
		  String Results;
		  String tempstr;
		//����Ҫ��ɵ�����EKP�Ľӿ���֤�����صĽ���������֣��磺��־��  ��������ɹ������ص���false1
		 
		  SSDLoginService ssdLoginService  =  new SSDLoginService();
			
		  SSDLoginDelegate ssdLoginDelegate = ssdLoginService.getSSDLoginPort();
			
		  Results = ssdLoginDelegate.getEKPUserFullName(userName, passWord);
		  
	
		  //����Ҫ��ɵ�����EKP�Ľӿ���֤�����صĽ���������֣��磺��־��  ��������ɹ������ص���false1   
		  
		 if (Results.equals("false")) {
		//����� ½��ֱ������	
			 session.put("loginFlag","�ʺŻ������������EKP�ʺŵ�½");
			// request.getSession().setAttribute("loginFlag","�ʺŻ������������EKP�ʺŵ�½");
		     tempstr = "index";
		}else{
			//����MYSQL��USER��û������ˣ�����еĻ���������SESSION����ȡ��ID�����û�У�INSERT ��ȡ���û�����ID 
			if(userBiz.isExitByName(Results)){
				User user = userBiz.getUserByUserName(Results);
			 
				session.put("user",user);
			
			    tempstr = "index";
			}else{
				User user = new User();
				user.setUserName(Results);
				//��ӵ����ݿ�,��ʵֻ�Ǽ��˸�����ȥ����û������
				userBiz.addUser(user);
				//��ΪҪȡUSERID ������ע����������ȡ
				user = userBiz.getUserByUserName(Results);			
				//�������USERID ��USERNAME
				session.put("user",user);
				 tempstr = "index"; 
			}  
		}
		 //����Ƕ���������׷�,�ͽ���admin����
		 if(Results.equals("������") || Results.equals("���׷�") )
		 {

			 tempstr = "admin"; 
		 }
		  
		 return "index";
	  }
	
	  
	  public String doLoginout() throws Exception {
		  if(session.get("user")!=null){
				session.remove("user");    		
			}
			return "index"; 
	  }
	  
	  public String toAdmin() throws Exception {
	  
		  
		  return "index"; 
		  
	  }
Map<String, Object> request;
@Override
public void setRequest(Map<String, Object> request) {
	this.request=request;		
}
Map<String, Object> session;
@Override
public void setSession(Map<String, Object> session) {
	this.session=session;				
}	
	 
}
