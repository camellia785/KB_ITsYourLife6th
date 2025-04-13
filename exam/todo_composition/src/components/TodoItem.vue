<script setup>
// Props는 부모 컴포넌트로부터 전달받음
const props = defineProps({
  todo: {
    type: Object, //객체타입
    required: true, //필수
  },
})
// emit은 부모에 이벤트 전달
const emit = defineEmits(['update:todo', 'delete:todo'])

// 완료상태 토글함수
const toggleCompleted = () => {
  // 기존 todo를 복사해서 completed값을 반전
  const updatedTodo = {
    ...props.todo, // 🔥
    completed: !props.todo.completed,
  }
  // 부모 컴포넌트로 업데이트 이벤트 전달
  emit('update:todo', updatedTodo)
}

// 삭제 이벤트 처리 함수

const handleDelete = () => {
  //사용자 확인창
  if (!confirm('정말 삭제하시겠습니까?')) return
  emit('delete:todo', props.todo.id)
}
</script>

<template>
  <!-- todo.completed상태에 따라 클래스 부여 -->
  <li class="{completed: todo.completed}" @click="toggleCompleted">
    <!-- 체크박스, 토글로직은 li에 걸려있음 -->
    <input type="checkbox" />
    <!-- 할일 텍스트표시 -->
    <span>{{ todo.text }}</span>

    <!-- 생성 날짜표시(unix 타임스탬프 -> 날짜변환) -->
    <time>{{ new Date(parseInt(todo.createdAt)).toISOString().split('T')[0] }}</time>

    <!-- 삭제 아이콘, 클릭시 삭제 함수 호출 -->
    <i class="fa fa-trash" @click="handleDelete"></i>
  </li>
</template>

<style scoped>
.todo-list li {
  display: flex;
  align-items: center;
  gap: var(--space-s);
  padding: var(--space-s);
  border-bottom: dotted 1px var(--gray200);
  cursor: pointer;
  transition: 0.3s;
}
.todo-list li:hover {
  background-color: var(--gray500);
}
/* 완료된 리스트 스타일 */
.todo-list li.completed {
  opacity: 0.3;
}
.todo-list li.completed span {
  text-decoration: line-through;
}

.todo-list span {
  flex: 1;
}
.todo-list time {
  font-size: 0.75rem;
}
.todo-list i {
  border: 1px solid transparent;
  padding: var(--space-s);
  color: var(--gray100);
  border-radius: var(--space-s);
  transition: 0.3s;
}
.todo-list i:hover {
  border: 1px solid var(--danger);
  color: var(--danger);
}
/* 가상요소로 사용하는 방법 */
.todo-list button::after {
  font-family: 'Font Awesome 6 Free';
  font-weight: bold;
  content: '\f1f8';
}
li.empty {
  flex-direction: column;
  padding: var(--space-l) 0;
}
li.empty:hover {
  background-color: transparent !important;
}
li.empty i {
  font-size: 3rem;
}
li.empty i:hover {
  border: none;
  color: var(--gray200);
}
</style>
