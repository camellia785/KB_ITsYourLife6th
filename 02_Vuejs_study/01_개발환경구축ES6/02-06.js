// 가변 파라미터 (Rest parameter)
// - 전달된 인수를 매개변수로 매칭한 후, 매칭되지 않은 인수를 모아 배열로 지정
// - 가변 파라미터는 항상 매개변수의 **마지막 위치**에만 작성가능

function foodReport(name, age, ...food) {
  console.log(name + ", " + age);
  console.log("food");
}
foodReport("이몽룡", 20, "짜장면", "냉면", "불고기");
foodReport("홍길동", 16, "초밥");
