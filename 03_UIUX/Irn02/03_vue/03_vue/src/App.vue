<!-- <script setup>
import CommonHeader from "./components/CommonHeader.vue";
import MainGallery from "./components/MainGallery.vue";
</script> -->

<script>
import { ref } from "vue";
import CommonHeader from "./components/CommonHeader.vue";
import MainGallery from "./components/MainGallery.vue";
export default {
  components: {
    CommonHeader,
    MainGallery,
  },

  setup() {
    // composition api방식
    const number = ref(0);
    return { number };
  },
};
</script>

<template>
  <CommonHeader />
  <MainGallery />
</template>

<style scoped></style>
