package com.pai.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
import com.opensymphony.xwork2.ActionSupport;*/
import java.util.Date;
import java.text.Format;
import com.pai.entity.Pager;
import com.pai.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pai.biz.PropertyinfoBiz;
import com.pai.entity.PropertyInfo;

/*@RequestMapping("/PropertyinfoAction") */
@Controller
@Scope("prototype")
@Action(value = "propertyinfoAction", results = {
 
		@Result(name = "index_sidebar_Progress", location = "/index.jsp"),
		@Result(name = "pro_read", location = "/pro_read.jsp"),
		@Result(name = "admin_new", location = "/admin_new.jsp")
		}
	 
		)
public class PropertyinfoAction extends ActionSupport implements RequestAware,SessionAware {
 //获得编号
   String BIANHAO;
   public void setBIANHAO(String bIANHAO) {
		BIANHAO = bIANHAO;
	}
   
	public String getBIANHAO() {
	return BIANHAO;
}

	//叫价
	Integer takeprice;
	public Integer getTakeprice() {
		return takeprice;
	}

	public void setTakeprice(Integer takeprice) {
		this.takeprice = takeprice;
	}

	//页的状态
	private Pager pager;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
  
	 
	


	@Autowired
	 private PropertyinfoBiz propertyinfoBiz;
		public void setPropertyinfoBiz(PropertyinfoBiz propertyinfoBiz) {
			this.propertyinfoBiz = propertyinfoBiz;
		}

	
	public String toListProcess( ) throws Exception {

		System.out.println("111");
		List listProgress =  (List) propertyinfoBiz.listPropertyInfoByStatus("开始");
		 
 
		System.out.println("111");
		request.put("listProgress",listProgress);
	   
	    System.out.println("111");
	    return "index_sidebar_Progress"; 
	 
	}
	

	public String toListfinish( ) throws Exception {

		System.out.println("222");
		 
		List listFinished=  (List) propertyinfoBiz.listPropertyInfoByStatus("结束");
		 
		System.out.println("222");
 
	    request.put("listFinished",listFinished);
	    System.out.println("222");
	    return "index_sidebar_finished"; 
	   
	}

	public String toListProcessByPager() throws Exception{
		int curPage=1;
		
		List listProgress =  null;
		
		if(pager!=null){
			curPage=pager.getCurPage();}
		
		if(pager==null){
	        //如何没有指定查询条件，获取指定页码的新闻列表
		//	newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			  listProgress =  (List) propertyinfoBiz.listPropertyInfoLimtByStatus("开始", 0, 5);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=propertyinfoBiz.getPagerOfAllPropertyInfo(5, "开始") ;	
			//pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			listProgress= (List) propertyinfoBiz.listPropertyInfoLimtByStatus("开始", curPage, 5);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			 
			pager=propertyinfoBiz.getPagerOfAllPropertyInfo(5, "开始") ;
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
	 
		//获取所有主题
		//List topicList=topicBiz.getAllTopics();
		//将主题列表存入request范围
		//request.put("topicList", topicList);
		request.put("listProgress",listProgress);
		return "index_sidebar_Progress";
		
		
	}
	//这个是给人看的
	public String getPropertyInfoByBianHao() throws Exception{
		PropertyInfo propertyInfo = new PropertyInfo();
		
		propertyInfo = propertyinfoBiz.getPropertyInfoByBianHao(BIANHAO);
		 
		session.put("BIANHAO", BIANHAO );
		request.put("propertyInfo",propertyInfo);
		return "pro_read";
	}
//这个是叫价的，如果已经叫价了PAIMAI存在记录，就更新PAIMAI	
	public String dotakePrice() throws Exception{
		 User user =(User) session.get("user");
	 	 BIANHAO =(String) session.get("BIANHAO");
	 
		 Format format = new SimpleDateFormat("yyyy-MM-dd");
		 format.format(new Date());
		  
		 //如果已经存在的话就UPDATE 否则就INSERT
		 if(propertyinfoBiz.isTakePrice(BIANHAO, user.getUserId())){
			propertyinfoBiz.doUpdatesubmit(BIANHAO,   takeprice ,format.format(new Date()), user.getUserId())   ; 
		 }else{
		    propertyinfoBiz.doAddsubmit(BIANHAO, takeprice,  format.format(new Date()),  user.getUserId()) ;
		 }
		 //找出最大的，并且更新到PROPERTYINFO表里
		 propertyinfoBiz.setPropertyInfoByBianHao(BIANHAO );
		 return "index_sidebar_Progress"; 
	}
//这个是修改价格的	
	public String doUpdatePrice() throws Exception{
		 User user =(User) session.get("user");
	 	 BIANHAO =(String) session.get("BIANHAO");
	 
		 Format format = new SimpleDateFormat("yyyy-MM-dd");
		 format.format(new Date());
		 propertyinfoBiz.doUpdatesubmit(BIANHAO, takeprice,  format.format(new Date()),  user.getUserId()) ;
	  
		 return "index_sidebar_Progress"; 
	}
	
	public String getPropertyInfoByBianHao_adminNew() throws Exception{
		PropertyInfo propertyInfo = new PropertyInfo();
		
		propertyInfo = propertyinfoBiz.getPropertyInfoByBianHao(BIANHAO);
		 
		session.put("BIANHAO", BIANHAO );
		request.put("propertyInfo",propertyInfo);
		return "admin_new";
	}	 
	
	public String doAddPropertyInfoByBianHao_adminNew() throws Exception{
		BIANHAO =(String) session.get("BIANHAO");
		propertyinfoBiz.doAddPropertyInfoByBianHao_adminNew(BIANHAO, SHIYONGKESHI, JISHENGBIANHAO, GOUMAIRIQI, GOURUJIAGE, PRINCEINIT, STARTDATE, ENDDATE, "开始",BEIZHU);
	  return "admin_new";
	}
	
	
	
	String SHIYONGKESHI;
	String JISHENGBIANHAO;
	String GOUMAIRIQI;
	String GOURUJIAGE;
	Integer PRINCEINIT;
	String  STARTDATE;
	String  ENDDATE;
	String status;
	String BEIZHU;
	
	
	
public String getBEIZHU() {
		return BEIZHU;
	}

	public void setBEIZHU(String bEIZHU) {
		BEIZHU = bEIZHU;
	}

public String getSHIYONGKESHI() {
		return SHIYONGKESHI;
	}

	public void setSHIYONGKESHI(String sHIYONGKESHI) {
		SHIYONGKESHI = sHIYONGKESHI;
	}

	public String getJISHENGBIANHAO() {
		return JISHENGBIANHAO;
	}

	public void setJISHENGBIANHAO(String jISHENGBIANHAO) {
		JISHENGBIANHAO = jISHENGBIANHAO;
	}

	public String getGOUMAIRIQI() {
		return GOUMAIRIQI;
	}

	public void setGOUMAIRIQI(String gOUMAIRIQI) {
		GOUMAIRIQI = gOUMAIRIQI;
	}

	public String getGOURUJIAGE() {
		return GOURUJIAGE;
	}

	public void setGOURUJIAGE(String gOURUJIAGE) {
		GOURUJIAGE = gOURUJIAGE;
	}

	public Integer getPRINCEINIT() {
		return PRINCEINIT;
	}

	public void setPRINCEINIT(Integer pRINCEINIT) {
		PRINCEINIT = pRINCEINIT;
	}

	public String getSTARTDATE() {
		return STARTDATE;
	}

	public void setSTARTDATE(String sTARTDATE) {
		STARTDATE = sTARTDATE;
	}

	public String getENDDATE() {
		return ENDDATE;
	}

	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
