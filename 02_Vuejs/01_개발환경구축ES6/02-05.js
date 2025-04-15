/**기본 파라미터 (Default Parameter)


- 함수 매개변수에 기본값 지정 가능
- 형식: `function func(arg1, arg2 = 기본값, ...)`
- 중간에만 기본값 지정하는 것은 불가능

*/

function addContact(
  name,
  mobile,
  home = "없음",
  address = "없음",
  email = "없음"
) {
  console.log(
    `name=${name}, mobile=${mobile}, home=${home}, address=${address}, email=${email}`
  );
}

addContact("홍길동", "010-222-3331");
addContact("이몽룡", "010-222-3331", "02-3422-9900", "서울시");
