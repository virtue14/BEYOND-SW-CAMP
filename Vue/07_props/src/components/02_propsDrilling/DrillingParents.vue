<script setup>
import {provide, readonly, ref} from "vue";
import Child from "@/components/02_propsDrilling/DrillingChild.vue";

const count = ref(0);
provide('count', count);    // provide를 통해 별도의 공간에 count 반응형 변수 값을 'count'라는 이름으로 담아 둠
provide('count', readonly(count));    // provide를 활용하는 부모 컴포넌트에는 수정하지만 Inject를 활용하는 곳은 읽기 전용으로 작성할 수 있다.(권장)
</script>

<template>
  <div class="container">
    <h1>Parents: {{count}}</h1>
    <Child/>
  </div>
</template>

<style scoped>
  .container {
    border: 1px solid;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>
