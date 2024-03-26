<template>
  <header>
    <h1>Router 사용하기</h1>
    <hr>
    <div class="wrapper">
      <h2>basic router</h2>
      <nav>
        <RouterLink to="/">Home</RouterLink>
      </nav>
    </div>
  </header>

  <main>
    <RouterView/>
  </main>
</template>

<script setup>
import {RouterLink, RouterView} from 'vue-router';
</script>

<style scoped>
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>
