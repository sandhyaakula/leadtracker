(function (global) {

var beacon = {};

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
      request.open("POST","http://localhost:3131/track");
      request.setRequestHeader( 'Access-Control-Allow-Origin', '*');
      request.setRequestHeader( 'Content-Type', 'application/json' );
      request.send(dataToPost);    
  }

global.$beacon = beacon;

})(window);



