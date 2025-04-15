import { defineStore } from "pinia";
import { ref, computed } from "vue";
import apiClient from "@/utils/axios";

export const useStudentStore = defineStore("student", () => {
  // state
  const students = ref([]);

  // action
  const fetchStudents = async () => {
    try {
      const response = await apiClient.get("/students");
      students.value = response.data;
    } catch (err) {
      console.log("학생정보 로딩에러: ", err);
    }
  };

  // getter
  // studentCount에서의 value가 아니라 stuents에서의 value를 사용해야 한다.
  const studentCount = computed(() => students.value.length);

  return { fetchStudents, students, studentCount };
});
