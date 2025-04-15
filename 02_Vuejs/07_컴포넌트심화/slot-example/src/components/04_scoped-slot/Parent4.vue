<script setup>
import Child4 from "./Child4.vue";
</script>

<template>
  <!-- 
   scoped-slot
   - 자식이 데이터를 넘겨준 걸 이용해서 부모가 콘텐츠를 제공한다. -->
  <div style="border: 1px solid blue">
    <!-- Parent4의 items를 받아와서 바인딩 -->
    <Child4 v-slot:item="{ item }">
      <h3>{{ item.name }}</h3>
    </Child4>
  </div>
</template>

<style scoped></style>
