const addBtn = document.querySelector(".fa-plus"); // 추가버튼
const input = document.querySelector(".footer_input"); //input 요소
const items = document.querySelector(".items"); // ul

//li 요소 생성함수
function createItem(text) {
  console.log(text);
  const itemRow = document.createElement("li");
  itemRow.className = "item";
  itemRow.innerHTML = `<span>${text}</span>
          <i class="fa-solid fa-check"></i>
          <i class="fa-solid fa-trash-can"></i>
        </li>`;

  // 체크버튼 클릭시 클래스 추가 이벤트
  itemRow.querySelector(".fa-check").addEventListener("click", () => {
    itemRow.classList.toggle("item_done");
  });
  //삭제 버튼 클릭시 itemRow 제거 이벤트
  itemRow
    .querySelector(".fa-trash-can")
    .addEventListener("click", () => itemRow.remove());

  //setTimeout(() => itemRow.scrollIntoView({ block: 'center' }), 0);
  requestAnimationFrame(() => itemRow.scrollIntoView({ block: "center" }));

  return itemRow;
}

// 추가함수
function onAdd() {
  const text = input.value.trim();
  if (!text) {
    input.value = "";
    input.focus();
    return;
  }

  // li생성하는 함수 - createItem(text)
  // ul에 생성값을 추가함

  items.appendChild(createItem(text));
  input.value = "";
  input.focus();
}

// 이벤트 등록
addBtn.addEventListener("click", onAdd);
// input.addEventListener('keypress', (e) => {
//   console.log(e);
//   if (e.key === 'Enter') {
//     onAdd();
//   }
// });

input.addEventListener("keyup", (e) => e.key === "Enter" && onAdd());

const resetBtn = document.querySelector(".reset-btn"); // 초기화 버튼

// 초기화 버튼 클릭 시 모든 리스트 삭제
resetBtn.addEventListener("click", () => {
  items.innerHTML = ""; // 모든 할 일 항목 삭제
});

function createSnowflake() {
  const snowflake = document.createElement("div");
  snowflake.classList.add("snowflake");
  snowflake.innerHTML = "❄";

  // 랜덤한 위치와 애니메이션 지속시간 설정
  snowflake.style.left = Math.random() * 100 + "vw";
  snowflake.style.animationDuration = Math.random() * 3 + 2 + "s";
  snowflake.style.fontSize = Math.random() * 10 + 10 + "px";

  document.body.appendChild(snowflake);

  // 일정 시간이 지나면 눈이 사라지도록 설정
  setTimeout(() => {
    snowflake.remove();
  }, 5000);
}

// 일정 간격으로 눈 생성 (100ms마다 하나씩)
setInterval(createSnowflake, 100);
