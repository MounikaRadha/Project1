const closePopup = () => {
  window.close();
};
const sumbitFormHandler = async(event) => {
  document.getElementById("successDiv").style.display = "block";
  document.getElementById("passwordDiv").style.display = "none";
  const password = document.getElementById("passwordField").value;
  var query = { active: true, currentWindow: true };
  chrome.tabs.query(query, async(tabs) => {
    let url1=tabs[0].url
     await chrome.storage.sync.set({
       [url1]: password,
      });
    });
};

document
  .getElementById("submitPassword")
  .addEventListener("click", sumbitFormHandler);
document.getElementById("closeWindow").addEventListener("click", closePopup);

