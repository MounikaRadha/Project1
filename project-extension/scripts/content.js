// if(location.href==="https://www.youtube.com/"){
// document.body.innerHTML="test"
// }
chrome.runtime.onMessage.addListener((msg,sender,sendResponse)=>{
    if(msg.data=="test"){
        document.body.innerHTML="test message received"
        sendResponse("callling send response with test")
    }
    else{
        document.body.innerHTML="the message that is received is not test"
        sendResponse("callling send response with out test")
    }
})
