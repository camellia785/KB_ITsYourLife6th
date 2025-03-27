<script setup>
import CheckboxItem from "./components/CheckboxItem.vue";
import InputName from "./components/InputName.vue";
import { ref } from "vue";

const parentName = ref("");

const nameChangeHandler = (event) => {
  parentName.value = event.childName;
};
</script>

<template>
  <h1>App 컴포넌트</h1>
  <hr />
  <div>
    <InputName @nameChange="nameChangeHandler"></InputName>
    <h3>App Data: {{ parentName }}</h3>
  </div>
</template>

<style scoped></style>
