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
    <div class=container>
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
<!-- Right area -->
  <div class="col-xs-3">right area
  <div></div>
<p>
  <span>Move the mouse over the div.</span>
  <span>&nbsp;</span>
</p>

<p>
  <span>Move the mouse over the div.</span>
  <span>&nbsp;</span>
</p>
<p class=oldx></p>
<p class=oldy></p>
 <!--  
<script>
$( "#rectangle" ).mousemove(function( event ) {
  var pageCoords = "( " + event.pageX + ", " + event.pageY + " )";
  var clientCoords = "( " + event.clientX + ", " + event.clientY + " )";
  var parentOffset = $(this).parent().offset();
  var locationx=(event.pageX - parentOffset.left);
  var locationy=(event.pageY - parentOffset.top);
  var prelocx;
  var prelocy;
 
  var pageCoords = "( " + locationx + ", " + locationy + " )";
  var clientCoords = "( " + event.clientX + ", " + event.clientY + " )";
  
  $( "span:first" ).text( "( event.pageX, event.pageY ) : " + pageCoords );
  $( "span:last" ).text( "( event.clientX, event.clientY ) : " + clientCoords );
});
</script>
-->

<script>
$( "#rectangle" ).mousemove(function( event ) {
	 var parentOffset = $(this).parent().offset();
 var locationx=(event.pageX-parentOffset.left);
 var locationy=(event.pageY - parentOffset.top);
 var prelocx;
 var prelocy;

 var pageCoords = "( " + locationx + ", " + locationy + " )";
 var clientCoords = "( " + event.clientX + ", " + event.clientY + " )";


 var locx =locationx/10;
 var locy =locationy/15;

 if(locy>prelocy)
 {
	  var returnServo ='U';
	  $.get('ServoController', {
		  updown : returnServo
	  }, function(responseText) {
         $('#ajaxGetUserServletResponse').text(responseText);
	  });
	  prelocx= locx ;
	  $("#oldx").text(locationx);
	  $( "span:first" ).text( "( event.pageX, event.pageY ) : " + pageCoords );
 }
 else
	  {
	  var returnServo ='D';
		  $.get('ServoController', {
			  updown : returnServo
		  }, function(responseText) {
             $('#ajaxGetUserServletResponse').text(responseText);
		  });
		  prelocx=locx;
		  $("#oldx").text(locationx);
	  $( "span:first" ).text( "( event.pageX, event.pageY ) : " + pageCoords );
	  $( "span:last" ).text( "( event.clientX, event.clientY ) : " + clientCoords );
	  
	  }
 

 if(locx>prelocx)
	  {
	  var returnMotor ='L';
		  $.get('MotorController', {
			  leftright : returnMotor
		  }, function(responseText) {
             $('#ajaxGetUserServletResponse').text(responseText);
		  });
		  prelocy=locy;
		  $("#oldy").text(locationy);
	  $( "span:last" ).text( "( event.clientX, event.clientY ) : " + clientCoords );
	  }
 else
	  {
	  var returnMotor ='R';
		  $.get('MotorController', {
			  leftright : returnMotor
		  }, function(responseText) {
             $('#ajaxGetUserServletResponse').text(responseText);
		  });
		  prelocy=locy;
		  $("#oldy").text(locationy);
	  $( "span:last" ).text( "( event.clientX, event.clientY ) : " + clientCoords );
	  
	  }

}

); 


</script>
  </div>
</div>
<!-- end right area -->
</div>



</body>
</html>







