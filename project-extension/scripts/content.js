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
   else if (msg.data == "askForPassword") {
    const modalContainer = document.createElement("div");
    modalContainer.style.position = "fixed";
    modalContainer.style.top = "50%";
    modalContainer.style.left = "50%";
    modalContainer.style.transform = "translate(-50%, -50%)";
    modalContainer.style.backgroundColor = "white";
    modalContainer.style.padding = "20px";
    modalContainer.style.boxShadow = "0px 4px 6px rgba(0, 0, 0, 0.1)";
    modalContainer.style.borderRadius = "8px";
    modalContainer.style.textAlign = "center";
    const inputElement = document.createElement("input");
    inputElement.id = "inputField";
    inputElement.type = "password";
    inputElement.placeholder = "Enter password";
    inputElement.style.padding = "10px";
    inputElement.style.width = "90%";
    inputElement.style.marginBottom = "10px";
    inputElement.style.border = "1px solid #ccc";
    inputElement.style.borderRadius = "5px";
    const submitElement = document.createElement("button");
    submitElement.id = "submitButton";
    submitElement.innerText = "Submit";
    submitElement.style.backgroundColor = "#007bff";
    submitElement.style.color = "white";
    submitElement.style.border = "none";
    submitElement.style.padding = "10px 15px";
    submitElement.style.borderRadius = "5px";
    submitElement.style.cursor = "pointer";
    submitElement.style.width = "100%";
    submitElement.addEventListener("mouseenter", () => {
        submitElement.style.backgroundColor = "#0056b3";
    });
    submitElement.addEventListener("mouseleave", () => {
        submitElement.style.backgroundColor = "#007bff";
    });
    modalContainer.appendChild(inputElement);
    modalContainer.appendChild(submitElement);
    document.body.style.display = "none";
    document.documentElement.appendChild(modalContainer);
    document.getElementById("submitButton").addEventListener("click", () => {
        let givenPassword = document.getElementById("inputField").value;
        console.log("9866 givenpassword is " + givenPassword);
        const obj = { "password": givenPassword, "url": location.href };
        chrome.runtime.sendMessage({ "passwordFromUser": obj });
    });
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
