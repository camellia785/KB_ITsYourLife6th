<script setup>


// defineProps
// 부모 컨포넌트에서 전달받은 프로퍼티를 정의하는 함수
defineProps({
  id: [Number, String],
  name: String,
  checked: {
    typle: Booleatn,
    default: false,
    required =true
  },

  ["", ""]);
</script>

<template>
  <li><input type="checkbox" :checked="idol.checked" />{{ name }}</li>
</template>

<style scoped></style>
