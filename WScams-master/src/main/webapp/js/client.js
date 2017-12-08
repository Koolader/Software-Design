/**
 * 
 */

	var img = document.querySelector('img');
	var url = "ws://localhost:8080/WScams/wsServer";
	var socket = new WebSocket(url);
	
	socket.onopen = function(){
		console.log("Connected to server");
		};
	
	socket.onmessage = onMessage;	
		
	function onMessage(event){
		img=event.data;
	}