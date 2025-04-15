<script setup></script>

<template>
  <div>
    <header>
      <slot name="header"></slot>
    </header>
    <body>
      <slot></slot>
    </body>
    <footer>
      <slot name="footer"></slot>
    </footer>
    <h1>나는 자식</h1>
  </div>
</template>

<style scoped></style>
