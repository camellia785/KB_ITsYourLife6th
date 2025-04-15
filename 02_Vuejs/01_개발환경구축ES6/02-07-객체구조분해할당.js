const user = {
  name: "Alice",
  age: 25,
  job: "Developer",
};

// 1. 객체 구조분해할당
// key 값 할당 (but 배열은 순서가 중요함, index로 할당하니까)
// const { age, name } = user;
// console.log(name);
// console.log(age);

// // 2. 변수 이름 변경 (별칭지정)
// const { name: userName, job: profession } = user;
// console.log(userName);

// // 3. 기본값 설정 (원래값이 있으면 원래값으로 적게됨)
// const { salary = 5000, age: userAge = 30 } = user;
// console.log(salary);
// console.log(userAge);

// 4. 중첩된 객체 분해
const person = {
  name: "Bob",
  info: {
    address: "Seoul",
    hobbies: ["reading", "coding"],
  },
};

const {
  name: name2,
  info: {
    address,
    hobbies: [firstHobby, secondHobby],
  },
} = person;

// 구조분해할당을 통해 이름과 첫번째 취미를 출력하시오
console.log(`이름 : ${name2}, 첫번째 취미: ${firstHobby}`);
