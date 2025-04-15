<script setup>
import { onMounted } from "vue";
import { useStudent } from "@/api/students";

// 컴포저블함수 사용
const { students, error, fetchAllstudents } = useStudent();
onMounted(() => {
  fetchAllstudents();
});
</script>

<template>
  <div>
    <h2>KB-19기 학생들</h2>
    <div>
      <div v-for="student in students" :key="student.id">
        <StudentCard :student="student"> </StudentCard>
      </div>
      <div v-if="error" class="error">
        {{ error }}
      </div>
    </div>
  </div>
</template>

<style scoped></style>
