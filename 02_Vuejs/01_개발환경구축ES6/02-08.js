//✅ addContact1 수정 -> 매개변수 선언을 통해 구조 분해 할당을 사용하여 값 추출

function addContact1({ name, phone, email = "이메일없음", age = 0 }) {
  console.log(name, phone, email, age);
}

addContact1({ name: "이몽룡", phone: "010-3434-8989" });

// ✅ addContact2 수정 -> 기본값을 설정해 undefined 방지

function addContact2(contact) {
  if (!contact.email) contact.email = "이메일없음";
  if (!contact.age) contact.age = 0;

  let { name, phone, email, age } = contact; // 구조 분해 할당

  console.log(name, phone, email, age);
}

addContact2({ name: "이몽룡", phone: "010-3434-8989" });

// ✅ addContact3 수정
// 매개변수를 2개(name, phone)만 받는 대신, email과 age를 기본값으로 설정.

function addContact3(name, phone, email = "이메일없음", age = 0) {
  console.log(name, phone, email, age);
}

addContact3("이몽룡", "010-3434-8989");
