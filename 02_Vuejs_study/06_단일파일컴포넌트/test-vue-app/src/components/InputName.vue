<script setup>
import { ref } from "vue";
const emit = defineEmits(["nameChange"]);

const childName = ref("");
</script>

<template>
  <div>
    이름: <input type="text" v-model="childName" />
    <button @click="emit('nameChange', { childName })">이벤트 발신</button>
  </div>
</template>

<style scoped></style>
