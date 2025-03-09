## overview
- user installs the extension
- user pins to toolbar
- user opens a site(gmail.com) and clicks on the icon in toolbar
    - we prompt for `enter the passkey to protect`
    - user can click cancel or enter password and click save(all this happens in a popup.js)
    - enhancement(if user gave at least one passowrd before,then we ask user `shall we use default password to protect this site`)

- user now opens gmail.com we check if it is protected or not(so on url open we run our background script)
- if protected we inject the content script
- the contnet script will remove the whole contnet say by placing the visible=hidden
- enhancement(other can change the hidden class,so bettr remove from dom)
- popup will be shown/custom html file will be shown(replace dom with our html)
- once user types correct password the reverse replacement will happen
    