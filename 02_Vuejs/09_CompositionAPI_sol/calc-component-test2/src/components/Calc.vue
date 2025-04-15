<script setup>
import { ref } from 'vue'

const x = ref(10)
const y = ref(20)
</script>

<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>

<style scoped></style>
