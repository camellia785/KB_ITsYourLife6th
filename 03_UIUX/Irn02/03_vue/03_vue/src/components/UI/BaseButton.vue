<script setup>
import { computed } from "vue";
const props = defineProps({
  variant: {
    type: String,
    default: "primary",
  },
});
const buttonClass = computed(() => {
  return {
    "btn-primary": props.variant === "primary",
    "btn-outline": props.variant === "outline",
    "btn-pill": props.variant === "pill",
  };
});
</script>
<template>
  <!-- 이렇게 쓰면 컴포넌트 재사용 어렵다 -->
  <!-- <button class="btn-primary">Primary</button>
  <button class="btn-outline">Outline</button>
  <button class="btn-pill">Pill</button> -->
  <button :class="buttonClass">
    <slot>Button</slot>
    <!-- slot에 값 들어가지 않으면 Button이 들어감. -->
  </button>
</template>
<style scoped>
/* 버튼 */
.btn-primary {
  background-color: #3b82f6;
  color: white;
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 0.375rem;
  cursor: pointer;
  margin-right: 10px;
}
.btn-outline {
  background: none;
  border: 2px solid #3b82f6;
  color: #3b8ef6;
  padding: 0.5rem 1rem;
  border-radius: 0.375rem;
  cursor: pointer;
  margin-right: 10px;
}
.btn-pill {
  background-color: #10b981;
  color: white;
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 50%;
}
</style>
