<script setup>
import api from "@/api/boardApi";
import { ref, computed, watch } from "vue";
import moment from "moment";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/auth";

const cr = useRoute(); // 현재 라우트 정보
const router = useRouter(); // 라이터 인스턴스
const page = ref({}); // 페이지 데이터 저장

// page 객체 내의 list 속성(게시글 목록)을 계산된 속성으로 반환함
// page.value가 변경되면 자동으로 articles도 반응적으로 갱신됨
const articles = computed(() => page.value.list); // 반응형 게시글 목록

// Composition API의 reactive 함수를 사용해
// 반응형 객체 pageRequest를 생성
const pageRequest = reactive({
  // 현재 페이지 번호를 설정:
  // URL 쿼리 파라미터에서 page 값을 가져와 정수로 변환, 없으면 기본값 1
  page: parseInt(cr.query.page) || 1,

  // 한 페이지에 보여줄 항목 수를 설정:
  // URL 쿼리 파라미터에서 amount 값을 가져와 정수로 변환, 없으면 기본값 10
  amount: parseInt(cr.query.amount) || 10,
});

const auth = useAuthStore();
const islogin = auth.isLogin;

//이 컴포넌트가 마운트되었을 때
//자동으로 axios를 불러서 list를 가지고 와야함.
//load()함수 정의후 --> 시작하자 마자 호출
//list를 가지고 와서  articles에 넣을 예정임.

//페이지바뀔 때마다 데이터를 가지고 올 예정인데
//그 데이터가 바뀌는지 자동 변동 여부 설정
//페이지에 따라 가지고 온 정보가 바뀌면 바뀐 데이터로
//자동으로 계산되어 articles에 넣어주세요.

load();
// 컴포넌트 마운트 시 실행
//해당 컴포넌트가 로드되자마자 load()함수를 불러서
//백엔드 서버로 부터 json으로 받아오자.

// 페이지네이션에서 페이지 번호를 클릭했을 때 실행되는 함수
const handlePageChange = async (pageNum) => {
  // URL의 query 문자열을 변경함 (예: ?page=2&amount=10)
  // 이때 컴포넌트가 다시 마운트되지는 않으므로 별도의 데이터 재로딩이 필요함
  // → 이후 watch()를 통해 라우트 정보 변경 감지하여 데이터 다시 불러옴
  router.push({
    query: { page: pageNum, amount: pageRequest.amount }, // 현재 페이지와 한 페이지당 항목 수 전달
  });
};

// 라우트 객체(cr)의 변화(즉, URL의 query 변경)를 감지하여 실행됨
watch(cr, async (newValue) => {
  // 변경된 페이지 번호 확인용 로그 출력
  console.log("WATCH", cr.query.page);

  // query에서 page와 amount 값을 읽어와 정수로 변환 후 pageRequest에 반영
  pageRequest.page = parseInt(cr.query.page);
  pageRequest.amount = parseInt(cr.query.amount);

  // 변경된 pageRequest 정보를 기반으로 게시글 데이터를 다시 불러옴
  await load(pageRequest);
});

// 게시글 목록 데이터를 서버(API)에서 비동기로 불러오는 함수 정의
const load = async (query) => {
  try {
    // API 호출: 전달받은 query 객체(page, amount)를 기반으로 게시글 목록 요청
    // 결과를 page.value에 할당하여 반응형 상태로 저장
    page.value = await api.getList(query);

    // 디버깅을 위한 콘솔 출력 (불러온 페이지 데이터 확인용)
    console.log(page.value);
  } catch {}
  // 에러 발생 시 특별한 처리는 없고 조용히 무시함 (필요 시 catch 블록 확장 가능)
};
// 컴포넌트 초기 렌더링 시, 현재의 pageRequest 정보를 기반으로 게시글 목록 로드
load(pageRequest);
</script>

<template>
  <div>
    <h1 class="mb-3"><i class="fa-solid fa-paste"></i> 게시글 목록</h1>
    <div class="mt-5 text-end">(총 {{ page.totalCount }}건)</div>
    <table class="table table-striped">
      <thead>
        <tr>
          ...
        </tr>
      </thead>
      <tbody>
        <tr v-for="article in articles" :key="article.no">
          <td>{{ article.no }}</td>
          <td>
            <router-link
              :to="{
                name: 'board/detail',
                params: { no: article.no },
                query: cr.query,
              }"
            >
              {{ article.title }}
            </router-link>
          </td>
          <td>{{ article.writer }}</td>
          <td>{{ moment(article.regDate).format("YYYY-MM-DD") }}</td>
        </tr>
      </tbody>
    </table>
    <div class="my-5 d-flex">
      <div class="flex-grow-1 text-center">
        <!-- 페이지 네이션 -->
        <vue-awesome-paginate
          :total-items="page.totalCount"
          :items-per-page="pageRequest.amount"
          :max-pages-shown="5"
          :show-ending-buttons="true"
          v-model="pageRequest.page"
          @click="handlePageChange"
        >
          <template #first-page-button
            ><i class="fa-solid fa-backward-fast"></i
          ></template>
          <template #prev-button
            ><i class="fa-solid fa-caret-left"></i
          ></template>
          <template #next-button
            ><i class="fa-solid fa-caret-right"></i
          ></template>
          <template #last-page-button
            ><i class="fa-solid fa-forward-fast"></i
          ></template>
        </vue-awesome-paginate>
      </div>
      <div>
        <router-link
          :to="{ name: 'board/create', query: cr.query }"
          class="btn btn-primary"
        >
          <i class="fa-solid fa-pen-to-square"></i> 글 작성</router-link
        >
      </div>
    </div>
  </div>
</template>
