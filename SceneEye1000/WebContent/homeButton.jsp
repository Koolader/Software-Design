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
  <h1>Video on Canvas</h1>
  <canvas></canvas>
  </div>
  <div>
   <h1> Video from Server</h1>
  <img alt="" />
  </div>
 <script src="js/client.js"></script>
  </div>
</div>
<!-- Right area -->
  <div class="col-xs-3 text-center">
  <script type="text/javascript">

// ***********************************************
var loop = false;
var loopLR = false;
var increment = 1;
var incrementLR = 1;
var scrollTop = 0;
var scrollLeft = 0;
/*****************updown********************/
function startLoop(change) {
	increment = change;
	loop = true;
	loopMe();
}

function endLoop() {
	loop = false;
}

function loopMe() {
	if (!loop) { return; }
	scrollTop += increment;
	if (scrollTop>160 ) {scrollTop==160; return;}
	if (scrollTop<1) {scrollTop==1; return;}
	
	 if(increment==1)
	 {
		  var returnServo ='U';
		  $.get('ServoController', {
			  updown : returnServo
		  }, function(responseText) {
	         $('#ajaxGetUserServletResponse').text(responseText);
		  });
		
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
			 
		  $( "span:first" ).text( "( event.pageX, event.pageY ) : " + pageCoords );
		  $( "span:last" ).text( "( event.clientX, event.clientY ) : " + clientCoords );
		  
		  }
	
	document.title = "top "+scrollTop+"left "+scrollLeft;
	setTimeout(loopMe,10);
}
/**********end updown*******/

/*********************left right ******/
function startLoopLR(change) {
	incrementLR = change;
	loopLR = true;
	loopMeLR();
}

function endLoopLR() {
	loopLR = false;
}

function loopMeLR() {
	if (!loopLR) { return; }
	scrollLeft += incrementLR;
	if (scrollLeft>160 ) {scrollLeft==160;return;}
	if (scrollLeft<1) {scrollLeft==1;return;}
	document.title = "top "+scrollTop+"left "+scrollLeft;
	
	if(incrementLR==-1)
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
	
	setTimeout(loopMeLR, 10);
}

// ***********************************************

	</script>

<a class="btn btn-primary btn-lg active" role="button" onmousedown="startLoop(1);" onmouseup="endLoop();">UP </a><br />
<a class="btn btn-primary btn-lg active" role="button" onmousedown="startLoop(-1);" onmouseup="endLoop();">DOWN</a><br/>
<a class="btn btn-primary btn-lg active" role="button" onmousedown="startLoopLR(-1);" onmouseup="endLoopLR();">LEFT</a><br />
<a class="btn btn-primary btn-lg active" role="button" onmousedown="startLoopLR(1);" onmouseup="endLoopLR();">RIGHT</a><br>
 
</div> <!-- end right area -->
</div> <!-- end row -->
</div><!-- end container -->


</body>
</html>







