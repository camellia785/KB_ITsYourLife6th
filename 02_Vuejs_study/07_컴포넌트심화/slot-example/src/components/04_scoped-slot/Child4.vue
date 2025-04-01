<script setup>
const items = [
  { id: 1, name: "사과" },
  { id: 2, name: "바나나" },
  { id: 3, name: "체리" },
  { id: 4, name: "수박" },
];
</script>

<template>
  <div>
    <slot name="item" v-for="item in items" :item="item" :key="item.id"></slot>
  </div>
</template>

<style scoped></style>
