<script setup>
import { useStudentStore } from "@/store/studentStore";

const studentStore = useStudentStore();
</script>

<template>
  <div class="summary">
    <p>
      전체 학생 수 : <strong>{{ studentStore.studentCount }}</strong>
    </p>
  </div>
</template>

<style scoped></style>
