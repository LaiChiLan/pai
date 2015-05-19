<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%-- <%@ taglib uri='/struts-tags' prefix='s' %> --%>
 <%@ taglib uri='/struts-tags' prefix='s' %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<title>新闻中国</title>
	
	<link href="CSS/main.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function check(){
			var loginName = document.getElementById("userName");
			var loginPwd = document.getElementById("passWord");
			if(loginName.value == ""){
				alert("用户名不能为空！请重新填入！");
				loginName.focus();	
				loginName.focus();
				return false;
			}else if(loginPwd.value == ""){
				alert("密码不能为空！请重新填入！");
				loginPwd.focus();
				return false;
			}
			return true;
		}
		
		function focusOnLogin(){
			var loginPwd = document.getElementById("passWord");
			if( loginPwd != null )
				loginPwd.focus();	
		}
	</script>
</head>
<body onload="focusOnLogin()">
<div id="header">
	<div id="top_login">	
	<s:if test="#session.user==null">
		<form action="UserAction!doLogin" method="post" onsubmit="return check()">
		    <label>用户名</label>
			<input type="text" id="userName"  name="userName" value="" class="login_input" />
			<label> 密&#160;&#160;码 </label>
			<input type="password" id="passWord" name="passWord" value="" class="login_input" />
			<input type="submit" class="login_sub" value="登录" />
			<label id="error"> </label>			
		</form>
	</s:if>
	<s:if test="#session.user!=null">
		欢迎您 ：<s:property value="#session.user.userName" />  &nbsp; &nbsp; &nbsp;
	<s:if test="#session.user.admin==1">
		<a href="admin.jsp">登录控制台</a>
	</s:if>	
		 &nbsp; <a  href="propertyinfoAction!toListProcessByPager">首页</a>
		 &nbsp; <a  href="UserAction!doLoginout">退出</a>
	</s:if>
  </div>
  <div id="nav">
	  <table>
	    <tr>
	    	<td><div id="logo"> <img src="Images/logo.jpg" alt="新闻" /> </div></td>
	    	<td><img src="Images/a_b01.gif" alt="" /></td>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
</div>
</body>
</html>

