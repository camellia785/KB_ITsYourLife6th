<script setup>
import { ref } from 'vue'
const currentFilter = ref('all')

// 현재 선택된 필터 값을 저장하는 반응형 변수
const emit = defineEmits(['update:filter'])

function setFilter(filter) {
  currentFilter.value = filter // 현재 필터값을 바꿔주고
  emit('update:filter', filter) // 부모 컴포넌트에 이 변경사항 전달
}
</script>

<template>
  <!-- 3개의 필터 버튼을 담고 있는 div클래스 filter-container로 스타일지정 -->
  <div class="filter-container">
    <!-- all이면 active 클래스 적용 -->
    <!--1 클릭하면 setFilter함수가 발동되어 all이 되는것 -->
    <!--2 클릭하면 active클래스 적용  -->
    <!--3 필터가 'completed'일 때 active 클래스 적용. -->
    <button :class="{ active: currentFilter === 'all' }" @click="setFilter('all')">전체</button>
    <button :class="{ active: currentFilter === 'active' }" @click="setFilter('active')">
      미완료
    </button>
    <button :class="{ active: currentFilter === 'completed' }" @click="setFilter('completed')">
      완료
    </button>
  </div>
</template>

<style scoped>
.filter-container {
  display: flex;
  gap: var(--space-m);
}
</style>
