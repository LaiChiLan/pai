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
	alert("ֻ�����������֣�"); 
	return false; 
	}    
  	if(userId1==""|| userId1 == null)
	{
	alert("��δ��½������EKP�ʺŵ�½"); 
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
    <li><a href="propertyinfoAction!toListProcessByPager" >���ڽ�����..</a></li>
    <li><a>�ҵ�������¼</a></li>
    <li><a>���н������</a></li>
 </ul>
 </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="��������" /> </div>
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
            <p>��Ͷ����ʱ�䣺${propertyInfo.ENDDATE}</p>
            </td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
          <td align="left">
             <p>ʹ�ÿ��ң�${propertyInfo.SHIYONGKESHI}&nbsp;&nbsp;</p>
             <p>�ͺţ� ${propertyInfo.XINGHAO}&nbsp;&nbsp; &nbsp;�����ţ� ${propertyInfo.JISHENGBIANHAO}&nbsp;&nbsp; </p>
             <p>����ʱ�䣺${propertyInfo.GOUMAIRIQI}&nbsp;&nbsp; ����۸� ${propertyInfo.GOURUJIAGE}   </p>      
             <p>�׼ۣ�<i style="color: red"  >${propertyInfo.PRINCEINIT}</i> </p>
             <p>Ŀǰ��߼۸�<i style="color: red"  >${propertyInfo.TOPPRICE}</i> </p>           
          </td>
          </tr>
          <tr>
            <td align="left"><strong>��ע��${propertyInfo.BEIZHU}</strong></td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2">
            <form   action="propertyinfoAction!dotakePrice" method="post" onsubmit="return checkComment()">  
                                                            ��������ľ�Ͷ�۸�:&nbsp;&nbsp;
           <!--          <input type='TEXT' onKeyPress="if(event.keyCode==13){if(isNaN(this.value))alert('������ֵ')};"/> -->
                    <input type="text" name="takeprice" value="" id="takeprice" style="vertical-align: middle;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit"  value="��   ��" style="height: 54px; width: 105px; vertical-align: middle;"  />
                    
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
