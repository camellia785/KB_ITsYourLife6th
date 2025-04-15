<script setup>
import { ref } from 'vue'

const x = ref(10)
const y = ref(20)
const result = ref(30)

// script안에서는 값에 접근하기 위해 .value를 넣음
const calcAdd = () => {
  result.value = x.value + y.value
}
</script>

<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
    <button @click="calcAdd">계산</button> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<style scoped>
/* scoped가 이 vue파일 안에서만 정의된 스타일! */
</style>
