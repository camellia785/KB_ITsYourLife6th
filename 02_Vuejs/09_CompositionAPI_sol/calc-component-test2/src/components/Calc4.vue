<style scoped></style>

<script setup>
import { reactive, computed } from "vue";

const state = reactive({ x: 10, y: 20 });
const result = computed(() => state.x + state.y);
</script>

<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
