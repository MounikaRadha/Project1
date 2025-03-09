chrome.runtime.onInstalled.addListener(() => {
    console.log("Extension installed, setting badge...");
    const url1="https://www.google.com"
    let urlsObject={"urls":[url1]}
    chrome.storage.sync.set(urlsObject)
    chrome.action.setBadgeText({ text: "trail1" });
});

chrome.action.onClicked.addListener(async (tab) => {
    chrome.action.setBadgeText({ text: "chnged" });
    let ans=await chrome.storage.sync.get("urls")
    console.log("ans is "+ans+"type is "+typeof(ans))
    ans["urls"].map(x=>console.log("url is "+x))
});
const handleNewOrOldTabs=(activeInfo)=>{
    chrome.tabs.get(activeInfo.tabId, (tab) => {
        if(tab.title=="New Tab" || chrome.runtime.lastError ) return;
        chrome.tabs.sendMessage(tab.id, { data: 'test' }, (response) => {
            if (chrome.runtime.lastError) {
                console.log("err--", chrome.runtime.lastError+"with tab as"+tab);
            } else {
                console.log("res--", response);
            }
        });
    });
}
chrome.tabs.onActivated.addListener((activeInfo) => {
    handleNewOrOldTabs(activeInfo)
});
chrome.tabs.onCreated.addListener((activeInfo)=>{
    console.log("createddd")
    handleNewOrOldTabs(activeInfo)
})
chrome.tabs.onUpdated.addListener((activeInfo)=>{
    console.log("updatedddd")
    chrome.tabs.get(activeInfo, (tab) => {
        if (chrome.runtime.lastError) return;
        chrome.tabs.sendMessage(tab.id, { data: 'test' }, (response) => {
            if (chrome.runtime.lastError) {
                console.log("err-", chrome.runtime.lastError);
            } else {
                console.log("res--", response);
            }
        });
    });
})