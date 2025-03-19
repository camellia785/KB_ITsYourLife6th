// 1. 배열 구조 분해 할당
let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;

console.log(a1, a2, a3);

// 2. 객체 구조 분해 할당
let p1 = { name: "홍길동", age: 20, gender: "M" };
let { name: n, age: a, gender } = p1;

console.log(n, a, gender);
