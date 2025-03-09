const closePopup = () => {
  window.close();
};
const sumbitFormHandler = (event) => {
  document.getElementById("successDiv").style.display = "block";
  document.getElementById("passwordDiv").style.display = "none";
  const password = document.getElementById("passwordField").value;
  var query = { active: true, currentWindow: true };
  chrome.tabs.query(query, (tabs) => {
    chrome.tabs.sendMessage(tabs[0].id, { data: "giveUrl" }, (response) => {
      chrome.storage.sync.set({
        key1: response + "password" + password,
      });
    });
  });
};
const replaceContentHandler = async () => {
  let newvalue = await chrome.storage.sync.get("key1");
  document.getElementById("replaceContent").innerText =
    "the new value iss " + newvalue["key1"];
};

document
  .getElementById("submitPassword")
  .addEventListener("click", sumbitFormHandler);
document.getElementById("closeWindow").addEventListener("click", closePopup);
document
  .getElementById("replaceContent")
  .addEventListener("click", replaceContentHandler);
