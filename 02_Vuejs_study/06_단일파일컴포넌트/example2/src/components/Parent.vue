<script setup>
import Child from "./Child.vue";
import Grandchild from "./Grandchild.vue";
</script>

<template>
  <div style="border: 2px solid red">
    <h1>나는 부모</h1>
    <Child />
    <Grandchild />
  </div>
</template>

<style scoped></style>
