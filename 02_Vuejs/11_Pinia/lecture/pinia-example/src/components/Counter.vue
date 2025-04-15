<template>
  <div>
    <h3>{{ counter.count }}</h3>
    <button @click="increase">+증가</button>
    <button @click="reset">0 초기화</button>
  </div>
</template>

<script setup>
import { useCounterStore } from "@/stores/counter";

const counter = useCounterStore();
const { increase, reset } = useCounterStore();
</script>
