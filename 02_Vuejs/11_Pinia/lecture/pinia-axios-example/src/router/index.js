import { createRouter, createWebHistory } from "vue-router";
import StudentListView from "../views/StudentListView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      redirect: "/students",
    },
    {
      path: "/students",
      name: "students",
      component: StudentListView,
    },
  ],
});

export default router;
