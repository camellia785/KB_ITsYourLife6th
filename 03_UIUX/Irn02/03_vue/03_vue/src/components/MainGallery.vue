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
    <section class="component-card">
      <h2>알림창</h2>
      <BaseAlert variant="success">Sucess</BaseAlert>
      <BaseAlert variant="warning">Warning</BaseAlert>
      <BaseAlert variant="error">Error</BaseAlert>
    </section>
  </main>
</template>

<style scoped></style>
