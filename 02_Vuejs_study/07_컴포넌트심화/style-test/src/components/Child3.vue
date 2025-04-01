<script setup>
import { useCssModule } from "vue";

const styles = useCssModule();
</script>

<template>
  <div>
    <div :class="styles.child">
      <h2>child3</h2>
    </div>
  </div>
</template>

<style module>
.child {
  background-color: orangered;
  border: 1px solid black;
  margin: 1.5em;
  padding: 1em;
}
</style>
