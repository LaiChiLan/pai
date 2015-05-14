<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>  
    <title>注册</title>
	
  </head>
  
  <body>
 
    <form action="user/doLogin.do" method="get">  
 <c:choose>
  <c:when test="${!empty loginFlag}">
  	 ${loginFlag}
  </c:when>
  <c:otherwise>
               请用EKP帐号登陆
  </c:otherwise>	
 </c:choose>
   
        <table>
        	<tr>
        		<td>用户名：</td>
        		<td><input type="text" name="userName" value="${user.userName}"/></td>
        	</tr>
        	<tr>
        		<td>密码：</td>
        		<td><input type="text" name="passWord" value="${user.passWord}"/></td>
        	</tr>
        	<tr>
        		<td></td>
        		<td><input type="submit" value="登 陆"> </td>
        	</tr>
        </table>

    </form>
  </body>
</html>
