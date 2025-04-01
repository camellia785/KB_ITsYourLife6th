<script setup>
import BaseButton from "./UI/BaseButton.vue";
</script>

<template>
  <!-- 그리드 컨테이너 -->
  <main class="component-grid">
    <!-- 컴포넌트 그룹(그리드아이템) -->
    <section class="component-card">
      <h2>버튼</h2>
      <BaseButton variant="btn-primary">Primary</BaseButton>
      <BaseButton variant="btn-outline">Outlint</BaseButton>
      <BaseButton variant="btn-pill">Pill</BaseButton>
    </section>
  </main>
</template>

<style scoped></style>
