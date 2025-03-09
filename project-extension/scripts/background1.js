const tabHandling = async (tab) => {
  let url = await chrome.storage.sync.get(tab.url);
  let urls = await chrome.storage.sync.get(null,(items)=>{
    console.log("items"+items)
  });
  let notSecured=Object.keys(url).length==0
  if (tab.title == "New Tab" || chrome.runtime.lastError ||notSecured) return;
    chrome.tabs.sendMessage(tab.id, { data: "test" }, (response) => {
      if (chrome.runtime.lastError) {
        console.log("err--", chrome.runtime.lastError + "with tab as" + tab);
      } else {
        console.log("res--", response);
      }
    });
};
chrome.tabs.onActivated.addListener((activeInfo) => {
  console.log("9866 onactivated");
  chrome.tabs.get(activeInfo.tabId, tabHandling);
});
chrome.tabs.onCreated.addListener((activeInfo) => {
  console.log("createddd");
  chrome.tabs.get(activeInfo.tabId, tabHandling);;
});
chrome.tabs.onUpdated.addListener((activeInfo) => {
  console.log("updatedddd");
  chrome.tabs.get(activeInfo, tabHandling);
});
