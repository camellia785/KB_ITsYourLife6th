import { createRouter, createWebHistory } from "vue-router";

/**
 * 라우터 생성
 * createRouter()
 * - 라우터 인스턴스 생성 메소드
 * - 인자로 history routes 필요
 *
 * history: 라우터 인스턴스에 전달되는 브라우저 히스토리 인스턴스
 * routes: 라우트 정보가 담긴 배열
 */

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", component: () => import("@/pages/Home.vue") },
    { path: "/about", component: () => import("@/pages/About2.vue") },
    { path: "/members", component: () => import("@/pages/Members.vue") },

    // 중첩 라우트
    // 라우트 내부에 라우트를 추가하는 방식
    {
      path: "/about",
      component: () => import("@/pages/About2.vue"),
      children: [
        // 기본 설정
        {
          path: "",
          redirect: "about/class",
        },
        {
          path: "class",
          name: "class",
          component: () => import("@/pages/about/Class.vue"),
        },
      ],
    },

    // 동적 라우트 파라미터 처리
    { path: "/members/:id", component: () => import("@/pages/MemberInfo.vue") },
    { path: "/videos", component: () => import("@/pages/Videos.vue") },
    { path: "/students", component: () => import("@/pages/Students.vue") },
  ],
});

export default router;
