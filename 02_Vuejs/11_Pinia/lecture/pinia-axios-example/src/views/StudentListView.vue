<template>
  <div>
    <StudentSummary />
    <h3>학생목록</h3>
    <StudentList />
    <h3>학생수Summary</h3>
  </div>
</template>
<script setup>
import StudentList from "@/components/StudentList.vue";
import StudentSummary from "@/components/StudentSummary.vue";
</script>
<style scoped></style>
