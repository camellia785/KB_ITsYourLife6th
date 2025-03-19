let msg = "GLOBAL";
function outer() {
  let msg = "OUTER"; //outer 출력
  console.log(msg);
  if (true) {
    let msg = "BLOCK";
    console.log(msg); // block 출력
  }
}
outer();
