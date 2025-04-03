<script setup>
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

// useRoute: 현재 활성화된 라우트 객체에 접근할 수 있게 해줌
// 주로 현재 경로, 쿼리파라미터 등의 정보를 가져올 수 있음
const route = useRoute();

// useRouter: push, replace, go 등의 메서드를 통해 페이지 이동을 제어 가능
const router = useRouter();

// 뒤로가기 버튼
const goBack = () => {
  router.go(-1);
};

// route 객체 출력
onMounted(() => {
  console.log(route);
});
</script>

<template>
  <div class="card card-body">
    <h2>Home</h2>
    <p>요청 경로 : {{ route.fullPath }}</p>
    <button class="btn btn-secondary mt-2" @click="goBack">뒤로가기</button>
  </div>
</template>
