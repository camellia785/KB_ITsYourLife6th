<script setup>
import Parent from "./components/01_slot_basic/Parent.vue";
import Parent2 from "./components/02_Named_slot/Parent2.vue";
import Parent3 from "./components/03_dynamic-slot/Parent3.vue";
import Parent4 from "./components/04_scoped-slot copy/Parent4.vue";
</script>

<!-- 
Slot
- 부모의 컴포넌트에서 자식으로 콘텐츠를 전달하는 기능
- 컴포넌트를 더 유연하고 재사용 가능하게 만들기 위해
-->

<template>
  <div>
    <Parent />
    <r />
    <Parent2 />
    <br />
    <Parent3 />
    <br />
    <Parent4 />
  </div>
</template>

<style scoped></style>
