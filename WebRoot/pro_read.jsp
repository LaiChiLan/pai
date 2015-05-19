<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>

<jsp:include page="index-elements/index_top.jsp" />
<link href="CSS/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkComment(){
 		var txt = document.getElementById("takeprice").value;
 		var userId1="${sessionScope.user.userId}";
	 if(checknumber(txt)) 
	{ 
	alert("只允许输入数字！"); 
	return false; 
	}    
  	if(userId1==""|| userId1 == null)
	{
	alert("还未登陆，请用EKP帐号登陆"); 
	return false; 
	}     
  return true; 
} 

function checknumber(String) 
	{ 
	var Letters = "1234567890"; 
	var i; 
	var c; 
	for( i = 0; i < String.length; i ++ ) 
	{ 
	c = String.charAt( i ); 
	if (Letters.indexOf( c ) ==-1) 
	{ 
	return true; 
	} 
	} 
	return false; 

}
	     
</script>
<div id="container">
 <%--  <jsp:include page="index-elements/index_sidebar.jsp"></jsp:include> --%>
  <div class="sidebar">
 <ul class ="side_list1">
    <li><a href="propertyinfoAction!toListProcessByPager" >正在进行中..</a></li>
    <li><a>我的拍卖记录</a></li>
    <li><a>所有结果公布</a></li>
 </ul>
 </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>      	
      <%-- 	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?tid=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator> --%>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">
            <p>${propertyInfo.BIANHAO}-${propertyInfo.PINGPAI}-${propertyInfo.SHEBEIMINGCHEN}</p>
            <p>竞投结束时间：${propertyInfo.ENDDATE}</p>
            </td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
          <td align="left">
             <p>使用科室：${propertyInfo.SHIYONGKESHI}&nbsp;&nbsp;</p>
             <p>型号： ${propertyInfo.XINGHAO}&nbsp;&nbsp; &nbsp;机身编号： ${propertyInfo.JISHENGBIANHAO}&nbsp;&nbsp; </p>
             <p>购买时间：${propertyInfo.GOUMAIRIQI}&nbsp;&nbsp; 购买价格： ${propertyInfo.GOURUJIAGE}   </p>      
             <p>底价：<i style="color: red"  >${propertyInfo.PRINCEINIT}</i> </p>
             <p>目前最高价格：<i style="color: red"  >${propertyInfo.TOPPRICE}</i> </p>           
          </td>
          </tr>
          <tr>
            <td align="left"><strong>备注：${propertyInfo.BEIZHU}</strong></td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2">
            <form   action="propertyinfoAction!dotakePrice" method="post" onsubmit="return checkComment()">  
                                                            请输入你的竞投价格:&nbsp;&nbsp;
           <!--          <input type='TEXT' onKeyPress="if(event.keyCode==13){if(isNaN(this.value))alert('不是数值')};"/> -->
                    <input type="text" name="takeprice" value="" id="takeprice" style="vertical-align: middle;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit"  value="提   交" style="height: 54px; width: 105px; vertical-align: middle;"  />
                    
            </form>
            </td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
    </div>
  </div>
</div>
