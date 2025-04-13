<script setup>
import { ref } from 'vue'
const todoText = ref('')

// 부모 컴포넌트로 이벤트(add-todo) 발생시키기위해 emit 선언
const addTodo = () => {
  console.log('실행')
  const timeStamp = Date.now().toString()
  const newTodo = {
    id: timeStamp, //유일한id
    text: todoText.value, // 입력된 텍스트
    completed: false, //처음엔 완료 상태가 아니니 false
    createdAt: timeStamp, // 생성시간 저장
  }
  emit('add-todo', newTodo) //부모컨포넌트에 이벤트 발생 및 새로운 todo객체보내
  todoText.value = ''
}
</script>

<template>
  <div class="input-container">
    <!-- 엔터 누르면 addTodo함수 실행 -->
    <input
      type="text"
      placeholder="할일을 입력하세요"
      v-model.trim="todoText"
      @keyup.enter="addTodo"
    />
    <button @click="addTodo">추가</button>
  </div>
</template>

<style scoped>
/* 입력폼 input-container*/
.input-container {
  position: relative;
  top: -30px;
  display: flex;
  gap: var(--space-s);
}
.input-container input {
  border: none;
  padding: var(--space-m);
  background-color: var(--gray400);
  color: var(--gray100);
  outline: none;
  border-radius: var(--space-s);
  flex: 1;
}
.input-container input:focus {
  background-color: var(--gray300);
}
.input-container button {
  background-color: var(--blue-dark);
  padding: var(--space-m) calc(var(--space-m) * 2);
}
.input-container button::after {
  content: '+';
  border: 1px solid var(--gray100);
  border-radius: 50%;
  width: 14px;
  height: 14px;
  display: inline-block;
  position: relative;
  left: 3px;
}
</style>
