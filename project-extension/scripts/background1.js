const tabHandling = async (tab) => {
  //on newtab,on tabswitch,on tab updation we call this function
  //we check whether this url is saved in storage (means secured with password) or not
  //if it is not secured or if it is a new tab we return
  //else we ask for password i.e send msg to contenet script
  let url = await chrome.storage.sync.get(tab.url);
  let notSecured = Object.keys(url).length == 0;
  if (tab.title == "New Tab" || notSecured) return;
  chrome.tabs.sendMessage(tab.id, { data: "askForPassword" });
};
chrome.tabs.onActivated.addListener((activeInfo) => {
  chrome.tabs.get(activeInfo.tabId, tabHandling);
});
chrome.tabs.onCreated.addListener((activeInfo) => {
  chrome.tabs.get(activeInfo.tabId, tabHandling);
});
chrome.tabs.onUpdated.addListener((activeInfo) => {
  chrome.tabs.get(activeInfo, tabHandling);
});
chrome.runtime.onMessage.addListener(async (msg, sender, sendResponse) => {
  if (msg.passwordFromUser) {
    //the url,passowrd are fetched from storage api
    const url = await chrome.storage.sync.get(msg["passwordFromUser"]["url"]);
    let password = url[Object.keys(url)];
    //the user given password is compared with the stored password
    //based on the response we send verified or cheater
    if (msg["passwordFromUser"]["password"] == password) {
      var query = { active: true, currentWindow: true };
      chrome.tabs.query(query, async (tabs) => {
        await chrome.tabs.sendMessage(sender.tab.id, {
          data: "passwordVerified",
        });
      });
    } else {
      await chrome.tabs.sendMessage(sender.tab.id, { data: "cheater" });
    }
  }
});
