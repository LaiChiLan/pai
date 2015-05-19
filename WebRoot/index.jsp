<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="index-elements/index_top.jsp" />
<div id="container">
<!-- 用AJAX解决 -->
 <%--
   <s:action name="propertyinfoAction!toListProcess" namespace="/" executeResult="true" />   
   <s:action name="propertyinfoAction!toListfinish" namespace="/" executeResult="true" />   
 --%>
 <div class="sidebar">
 <ul class ="side_list1">
    <li><a href="propertyinfoAction!toListProcessByPager" >正在进行中..</a></li>
    <li><a>我的竞投记录</a></li>
    <li><a>所有结果公布</a></li>
 <%--    <s:if test="#session.user.admin==1">
		 <li><a href="propertyinfoAction!toListProcessByPager" >新建</a></li>
    	<li><a>修改</a></li>
	</s:if>	 --%>
 </ul>
 </div>
 <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>    
      	 <!-- 循环显示主题列表 -->  	
      <%-- 	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator> --%>
      </ul>
      <ul class="classlist"> 
        <!-- 循环显示当前页新闻列表 -->     
        <s:iterator id="Progress" value="#request.listProgress">
         <li><a href="propertyinfoAction!getPropertyInfoByBianHao?BIANHAO=${Progress.BIANHAO}">${Progress.BIANHAO}-${Progress.PINGPAI}-${Progress.SHEBEIMINGCHEN}-竞投结束时间：${propertyInfo.ENDDATE}  </a>
      	 <%--    <span> ${newsinfo.createDate}</span> --%>
      	 </li>
        </s:iterator>     
        <br> <br>
        
        <!-- 分页超链接部分 -->
	    <s:if test="pager.curPage == 1 and pager.pageCount !=1" > 
	     <p align="center">
		 	<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>下一页</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>尾页</a>
	     </p>
	    </s:if>	
		<s:if test="pager.curPage < pager.pageCount and pager.curPage>1">
		  <p align="center">
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>首页</a>
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>上一页</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>下一页</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>尾页</a>
		   </p>
		</s:if>
		<s:if test="pager.curPage == pager.pageCount and pager.curPage != 1">
		  <p align="center">
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>首页</a>
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>上一页</a>
 
		   </p>
		</s:if>
       </ul>
    </div>   
  </div> 
   
  </div>
 
