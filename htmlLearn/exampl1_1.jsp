<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "utf-8" %>
<HTML><body bgcolor = pink>
<h1>这是一个简单的JSP页面</h1>
<% int i,sum=0;
       for(i=1;i<=100;i++){
          sum=sum+i;
       }
%>
<p style="font-family:宋体;font-size:36;color:blue" >
和是: <%=sum%>
</p></body></HTML>