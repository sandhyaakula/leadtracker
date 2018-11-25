(function (global) {

var beacon = {};
beacon.GET = "GET";
beacon.POST = "POST";


// Makes an Ajax GET request to 'requestUrl'
beacon.get = 
  function(requestUrl, responseHandler) {
    var request = new XMLHttpRequest();
    request.onreadystatechange = 
      function() { 
        handleResponse(request, responseHandler); 
      };
    request.open("GET", requestUrl, true);
    request.send(null); // for POST only
  };

function handleResponse(request,
                        responseHandler) {
  if ((request.readyState == 4) &&
     (request.status == 200)) {
    responseHandler(request);
  }
}


beacon.send = 
    function(data,url){
      var trackingData = {
             location: global.location.href,
             time: Date(),
             cookie: document.cookie
      };
      if (data instanceof Event) {
        trackingData.action = data.type;
        trackingData.actionSource = data.target.id;
      }else{
        trackingData.action = data;
      }

      var dataToPost = JSON.stringify(trackingData);

      var request = new XMLHttpRequest();
      console.log("posting data");
      request.open("POST","http://192.168.0.19:3131/track");
      request.setRequestHeader( 'Access-Control-Allow-Origin', '*');
      request.setRequestHeader( 'Content-Type', 'application/json' );
      request.send(dataToPost);
      console.log(dataToPost);
     
  }

global.$beacon = beacon;

})(window);



