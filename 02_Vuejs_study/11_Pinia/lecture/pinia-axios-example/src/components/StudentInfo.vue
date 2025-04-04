<script setup>
defineProps({
  student: {
    type: Object,
    required: true,
  },
});
</script>

<template>
  <div class="student-info">
    <div class="student-name">{{ student.name }}</div>
    <div class="student-email">{{ student.email }}</div>
    <div class="student-github">
      <a :href="student.githubURL" target="_blank">Github</a>
    </div>
  </div>
</template>

<style scoped></style>
