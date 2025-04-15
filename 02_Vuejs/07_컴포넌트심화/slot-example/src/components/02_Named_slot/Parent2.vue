<script setup>
import Child2 from "./Child2.vue";
</script>

<template>
  <!-- 
   named slot
   - 부모가 자식 컴포넌트의 여러 위치에 콘텐츠 삽입 가능
   - slot에 name을 붙이면 특정위치에 원하는 내용 전달 가능
    -->

  <div style="border: 1px solid blue">
    <Child2>
      <template #header>
        <!-- Child2의 <slot name="header"></slot>로 넘어감 -->
        <p>헤더입니다.</p>
      </template>
      <template #default>
        <!-- Child2의 slot></slot>로 넘어감. defalut는 아무것도 지정 하지 않은 곳으로 넘어감. -->
        <p>기본 슬롯입니다.</p>
      </template>
      <template #footer>
        <!-- Child2의 <slot name="footer"></slot>로 넘어감 -->
        <p>푸터입니다.</p>
      </template>
    </Child2>
  </div>
</template>

<style scoped></style>
