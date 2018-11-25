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
        trackingData.event = data.type;
        trackingData.eventSource = data.target.id;
      }else{
        trackingData.action = data;
      }

      var dataToPost = JSON.stringify(trackingData);

      //var request = new XMLHttpRequest();
      //request.open("POST","http://localhost:3000/offers.html")
      // request.send(dataToPost);
      console.log(dataToPost);
     
  }

global.$beacon = beacon;

})(window);



