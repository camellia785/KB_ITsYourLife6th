import { ref, computed } from "vue";
import { defineStore } from "pinia";

// pinia store 정의
// defineStore :스토어를 생성하는 함수
// 첫번째 인자가 스토어의 고유 ID가 된다.

export const useCounterStore = defineStore("counter", () => {
  //state
  const count = ref(0); //카운터 값을 저장하는 상태 변수

  //getter
  const doubleCount = computed(() => count.value * 2);

  //action
  //1씩 증가하는 메서드
  const increase = () => {
    count.value++;
  };

  // 0으로 초기화 메서드
  const reset = () => {
    count.value = 0;
  };

  return { count, increase, reset };
});
