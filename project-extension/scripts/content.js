chrome.runtime.onMessage.addListener((msg,sender,sendResponse)=>{
    console.log("msg recevied is "+msg.data)
    if(msg.data=="giveUrl"){
        const url=window.location.href
        sendResponse(url)
    }
    else if (msg.data=="test"){
        document.body.innerHTML="test message received"
       
        sendResponse("callling send response with test")
    }
    else{
        document.body.innerHTML="the message that is received is not test"
        sendResponse("callling send response with out test")
    }
})
