const closePopup=()=>{
    window.close()
}
const sumbitFormHandler=()=>{
    var query = { active: true, currentWindow: true };
    chrome.tabs.query(query, (tabs)=>{
        chrome.tabs.sendMessage(tabs[0].id, { data: 'giveUrl' }, (response) => {
            if (chrome.runtime.lastError) {
                console.log("err-", chrome.runtime.lastError);
            } else {
                console.log("url is --", response);
            }
            chrome.storage.sync.set({"key1":response})
        })
    });
   
   
}
const replaceContentHandler=async()=>{
    let newvalue=await chrome.storage.sync.get("key1");
    const url=window.location.href
    document.getElementById("replaceContent").innerText="the new value is "+newvalue["key1"]
}

document.getElementById("myform").addEventListener("submit",sumbitFormHandler)
document.getElementById('closeWindow').addEventListener('click', closePopup);
document.getElementById("replaceContent").addEventListener("click",replaceContentHandler)
