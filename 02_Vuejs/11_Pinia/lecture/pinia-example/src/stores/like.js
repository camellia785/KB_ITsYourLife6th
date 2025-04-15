import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useLikeStore = defineStore("like", () => {
  //state
  const like = ref(0); //좋아요 수를 저장하는 상태 변수

  //getter
  //getter함수를 만들어서 좋아요개수를 5배 뻥튀기하기
  const fivetime = computed(() => like.value * 5);

  //action
  // 1씩 증가하는 메서드
  const increase = () => {
    like.value++;
  };

  return like, increase, reset, fivetime;
});
