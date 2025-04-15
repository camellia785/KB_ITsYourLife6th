<script setup></script>

<template>
  <div class="child">
    <h2>child2</h2>
  </div>
</template>

<!-- 
scoped를 적으면 해당 컴포넌트에만 스타일 적용. 아래 스타일 코드는 Child2에만 적용 

* scoped 속성을 사용하면 해당 컴포넌트에서만 적용되는 스타일이 된다.
-> 특정 속성을 만들어서 해당 컴포넌트에만 등록될 수 있게 바꾸어줌
ex) data-v-xxxx
-->
<style scoped>
.child {
  background-color: blue;
  border: 1px solid black;
  margin: 1.5em;
  padding: 1em;
}
</style>
