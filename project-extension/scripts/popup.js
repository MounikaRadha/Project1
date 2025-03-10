const closePopup = () => {
  window.close();
};
const sumbitFormHandler = async (event) => {
  const password = document.getElementById("passwordField").value;
  var query = { active: true, currentWindow: true };
  chrome.tabs.query(query, async (tabs) => {
    let url1 = tabs[0].url;
    const obj = await chrome.storage.sync.get([url1]);
    let notSecured = Object.keys(obj).length == 0;
    if (notSecured) {
      await chrome.storage.sync.set({
        [url1]: password,
      });
      document.getElementById("successDiv").style.display = "block";
      document.getElementById("passwordDiv").style.display = "none";
    } else {
      document.getElementById("alreadyProtected").style.display = "block";
    }
  });
};

document
  .getElementById("submitPassword")
  .addEventListener("click", sumbitFormHandler);
document.getElementById("closeWindow").addEventListener("click", closePopup);
