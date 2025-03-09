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
    else if(msg.data=="askForPassword"){
        const div=document.createElement("body")
        const inputElement = document.createElement("input");
        inputElement.id="inputField"
        const submitElement=document.createElement("button")
        submitElement.id="submitButton"
        div.appendChild(inputElement)
        div.appendChild(submitElement)
        document.body.style.display="none"
        document.documentElement.appendChild(div)
        document.getElementById("submitButton").addEventListener("click",(e)=>{
            let givenpassword=document.getElementById("inputField").value
            console.log("9866 givenpassword is "+givenpassword)
            const obj={"password":givenpassword,"url":location.href}
            chrome.runtime.sendMessage({"passwordFromUser":obj})
        })
    }
    else if(msg.data=="passwordVerified"){
        console.log(" you are a verifed user ")
         document.body.style.display="block"
        sendResponse("you are veriefed")
        return true;
    }
    else if(msg.data=="cheater"){
        let element=document.createTextNode("you are cheating... no access to youu")
        document.documentElement.appendChild(element)
    }
    else{
        document.body.innerHTML="the message that is received is not test"
        sendResponse("callling send response with out test")
    }
})
