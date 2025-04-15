<template>
  <div class="card card-body">
    <h2>Members</h2>

    <div v-for="m in members" :key="m.id">
      <router-link :to="'/members/' + m.id">
        <img
          class="img-thumbnail"
          style="width: 90px"
          height="110px"
          :src="m.photo"
          :title="m.name"
        />

        <h6 class="display-7">{{ m.name }}</h6>
      </router-link>
    </div>
  </div>
</template>
<script setup>
import members from "@/members.json";
import { onMounted } from "vue";

onMounted(() => {
  console.log(members);
});
</script>
