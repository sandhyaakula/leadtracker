document.addEventListener("DOMContentLoaded",
  function (event) {
    console.log(event.traget) ;
    document.querySelector("button")
      .addEventListener("click", trackEvent);
  }
);

function getRequestParam(){
    var queryString = window.location.href;

}

function trackEvent(event){
            $beacon.send(event);
}