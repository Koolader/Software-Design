$(document).ready(function() {
	
	var urlServer = "ws://localhost:8080/WScams/wsServer";
	var urlClient = "ws://localhost:8080/WScams/wsClientHandler";
	var video = document.querySelector('video');
	var canvas = document.querySelector('canvas');
	var img = document.querySelector('img');
	var context = canvas.getContext('2d');
	var socket = new WebSocket(urlServer);
	var constraints = {
			video: true,
			audio: false
	};
		
	//on socket open
	var onOpen = function(event) {
		
        socket.addEventListener('message', function(event) {
        	img.src = window.URL.createObjectURL(event.data);
        });
		console.log("Socket Opened: " + event.data);
	}
	
	//on server response
	var onMessage = function(event) {
		
		console.log("On Event: " + event.data);		
	}
	
	//read and write stream data to video element, current short poll interval: 100 ms
    var readDrawCanvas = function(event) {
    	
    	readCanvas();
    	drawCanvas();
    }
    
	//read current contents of video element
	var readCanvas = function(event) {
		
		var canvasData = canvas.toDataURL('image/jpeg',1);
		var decodeAstring = atob(canvasData.split(',')[1]);
		var charArray = [];
		
		for(var i = 0; i < decodeAstring.length; charAray.push(decodeAstring.charCodeAt(i++))) ;
		
       socket.send(new Blob([new Uint8Array(charArray)],{
    	   type:'image/jpeg'
       }));
	}
	
	//write stream data to current contents of video canvas
	var drawCanvas = function(event) {
		
		context.drawImage(video,0,0,canvas.width, canvas.height);
		console.log("Drawing Canvas: " + event.data)
	}

	//fetch media handle of video element
	var getStreamMedia = function(event) {
		
		navigator.mediaDevices.getUserMedia(constraints).then(	
				function(stream) {
					video.srcObject = stream;
					video.play();
					console.log("Stream Playback: " + stream.data);
				}).catch(
						function(error) {
							console.log("Error in stream playback: " + error.data);
				});
	}
	
	document.ready = getStreamMedia; //event to fetch media handle
	socket.onopen = onOpen; //event on socket open
	socket.onmessage = onMessage; //event on server response
    setInterval(readDrawCanvas ,100); //short poll for read/write operation, currently: 100 ms
});