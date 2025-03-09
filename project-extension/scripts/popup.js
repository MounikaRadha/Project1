const closePopup=()=>{
    window.close()
}
const sumbitFormHandler=()=>{
    chrome.storage.sync.set({"key1":"value1"})
}
const replaceContentHandler=async()=>{
    let newvalue=await chrome.storage.sync.get("key1");
    document.getElementById("replaceContent").innerText="the new value is "+newvalue["key1"]
}

document.getElementById("myform").addEventListener("submit",sumbitFormHandler)
document.getElementById('closeWindow').addEventListener('click', closePopup);
document.getElementById("replaceContent").addEventListener("click",replaceContentHandler)
