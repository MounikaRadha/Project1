const sumbitFormHandler = async (event) => {
  //take password from password field
  const password = document.getElementById("passwordField").value;
  var query = { active: true, currentWindow: true };
  //query for active tabs
  chrome.tabs.query(query, async (tabs) => {
    //get current url
    const url1 = tabs[0].url;
    //check if already there is a pair with this url as key
    //if exists then it means it is already secured
    const obj = await chrome.storage.sync.get([url1]);
    let notSecured = Object.keys(obj).length == 0;
    if (notSecured) {
      await chrome.storage.sync.set({
        [url1]: password,
      });
      //hide the password fields and show success para
      document.getElementById("successDiv").style.display = "block";
      document.getElementById("passwordDiv").style.display = "none";
    } else {
      //show if already protected msg
      document.getElementById("alreadyProtected").style.display = "block";
    }
  });
};

document
  .getElementById("submitPassword")
  .addEventListener("click", sumbitFormHandler);
