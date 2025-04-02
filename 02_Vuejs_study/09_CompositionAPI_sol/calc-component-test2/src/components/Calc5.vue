<style scoped></style>

<script setup>
// x값이 변경될때마다 이전값, 새로운값, 콘솔출력

import { ref, watch } from "vue";

const x = ref(0);
const result = ref(0);

watch(x, (current, old) => {
  console.log(`이전값: ${old} => 현재값: ${current}`);
  result.value = current;
});
</script>

<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
