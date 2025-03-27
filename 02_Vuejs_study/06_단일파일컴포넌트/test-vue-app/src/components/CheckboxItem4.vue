<script setup>
//  validator
// Vue 공식 기능
// 부모가 prop를 전달,함수 호출
// 부모 컨포넌트에서 전달받은 프로퍼티를 정의하는 함수

defineProps({
  idol: {
    type: Object,
    required: true,
    validator: (value) => {
      return (
        (typeof value.id === "number" || typeof value.id === "string") &&
        typeof value.name === "string" &&
        typeof value.checked === "boolean"
      );
    },
  },
});
</script>

<template>
  <li>
    <input type="checkbox" :checked="idol.checked" />
    {{ idol.name }}
  </li>
</template>

<style scoped></style>
