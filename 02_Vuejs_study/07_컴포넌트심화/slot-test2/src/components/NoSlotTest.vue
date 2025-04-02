<script setup>
import CheckBox1 from './CheckBox1.vue'
import { ref } from 'vue'

const items = ref([
  { id: 'V', checked: true, label: 'Vue' },
  { id: 'A', checked: false, label: 'Angular' },
  { id: 'R', checked: false, label: 'React' },
  { id: 'S', checked: false, label: 'Svelte' },
])

const CheckBoxChanged = (e) => {
  console.log('CheckBoxChanged 이벤트 핸들러 실행!')
  let item = items.value.find((item) => item.id === e.id)
  item.checked = e.checked
}
</script>

<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은?(첫번째:Slot사용(X))</h3>
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    ></CheckBox1>
  </div>
</template>

<style scoped></style>
