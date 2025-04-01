<script setup>
defineProps(["slotName"]);
</script>

<template>
  <div>
    <div>
      <slot :name="slotName"></slot>
    </div>
  </div>
</template>

<style scoped></style>
