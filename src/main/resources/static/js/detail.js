const sendUserId = document.querySelector("#sendUser").value;
const recvUserId = document.querySelector("#recvUser").value;

//유저 정보 가져오기
async function initPage() {
    let sendUser = (await findUser())[0];
    let recvUser = (await findUser())[1];
    const eventSource = new EventSource(`http://localhost:8100/sender/${sendUser.username}/receiver/${recvUser.username}`);
    eventSource.onmessage = (event) => {
        const data = JSON.parse(event.data);
        if(data.sender === sendUser.username) {
            initMyMessage(data);
        } else {
            initYourMessage(data);
        }
    }
}

function findUser() {
     return  fetch(`/chat/findUser`, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            sendUserId: sendUserId,
            recvUserId: recvUserId
        })
    }).then(resp =>  resp.json())
        .catch(err => console.log(err));
}

function initMyMessage(data) {
    let msgBox = document.querySelector(".msg-box");
    let sendBox = document.createElement("div");

    sendBox.innerText = data.msg;
    sendBox.className = "msg-box__content-my msg-box__content";
    msgBox.append(sendBox);
    document.documentElement.scrollTop = document.body.scrollHeight;
}

function initYourMessage(data) {
    let msgBox = document.querySelector(".msg-box");
    let sendBox = document.createElement("div");

    sendBox.innerText = data.msg;
    sendBox.className = "msg-box__content-your msg-box__content";
    msgBox.append(sendBox);
    document.documentElement.scrollTop = document.body.scrollHeight;
}

async function addMyMessage() {
    let chat = {
        sender: (await findUser())[0].username,
        receiver: (await findUser())[1].username,
        msg: sendBoxInput.value,
    };

    fetch("http://localhost:8100/chat", {
        method: "post",
        body: JSON.stringify(chat),
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
    });
    window.parent.document.querySelector(".send-box__content").value = "";
}

//init 메소드
initPage();

const sendBtn = window.parent.document.querySelector(".send-box__btn")
sendBtn.addEventListener("click", () => addMyMessage());

const sendBoxInput = window.parent.document.querySelector(".send-box__content")
sendBoxInput.addEventListener("keydown", (event) => {
    if(event.keyCode === 13) {
        addMyMessage();
    }
});
