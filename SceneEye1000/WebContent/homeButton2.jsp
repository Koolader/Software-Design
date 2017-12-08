<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp"/>  


<body>
<div class="container"> 
<div class="row">
<!-- Left area where buttons will be located -->
  <div class="col-xs-1">left area</div>
<!-- Central , where video will be located in a future -->
  <div class="col-xs-8">
  <div id="rectangle"> 
  <div>
  <h1>Video from webCam</h1>
  <video ></video>
  </div>

  <div>
  <h1>Video on Canvas</h1>
  <canvas></canvas>
  </div>
  
  <div>
   <h1> Video from Server</h1>
  <img alt="" />
  </div>
 <script src="js/stream.js"></script>
  </div>
</div>







