<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>    
        <!-- 循环显示5条国内新闻  -->  	  
      	<s:iterator id="Progress" value="#request.listProgress">
      		<li> <a href='newsread?id=${Progress.BIANHAO}'><b> ${Progress.SHEBEIMINGCHEN}</b></a> </li>
      		<br>
      	</s:iterator>
      </ul>
<%--          <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>首页</a>
			    <a href='index?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>上一页</a>
		    </p>
		</s:if>		
--%>
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
		   <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>首页</a>
		   <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>上一页</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>下一页</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>尾页</a>
		  </p>
		</s:if>
    </div>
    
  </div>

