<template>
  <div>
    <ul class="student-list">
      <li
        v-for="student in studentStore.students"
        :key="student.id"
        class="student-item"
      >
        <StudentInfo :student="student"></StudentInfo>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useStudentStore } from "@/store/studentStore";
import StudentInfo from "./StudentInfo.vue";

const studentStore = useStudentStore();

onMounted(() => {
  studentStore.fetchStudents();
});
</script>

<style scoped></style>
