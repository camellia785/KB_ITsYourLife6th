<template>
  <div class="card card-body">
    <h2>About</h2>
    <nav>
      <router-link :to="{ name: 'class' }">학급소개</router-link>
      <router-link :to="'/about/goal'">목표</router-link>
    </nav>
    <hr />
    <router-view></router-view>
  </div>
</template>
