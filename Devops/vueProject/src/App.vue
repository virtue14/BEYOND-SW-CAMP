<template>
  <div class="plus">
    <h1>덧셈 기능 만들기</h1>
    <label>num1: <input type="text" v-model="num1">&nbsp </label>
    <label>num2: <input type="text" v-model="num2">&nbsp </label>
    <button @click="sendPlus">더하기</button>
    <hr>
    <p>`{{num1}} + {{num2}} = {{result}}`</p>
  </div>
</template>

<script setup>
  import {ref} from "vue";

  const num1 = ref(0);
  const num2 = ref(0);
  const result = ref(0);

  const sendPlus = async() => {

    /* 백엔드를 도커 컨테이너로 8055포트로 만들었을 때 */
    // const response = await fetch(`http://localhost:8055/plus?num1=${num1.value}&num2=${num2.value}`);
    /* 도커 컨테이너 간에 네트워크 연결 후(5173/api가 아니라 8011/api로 바꿔야 한다.) */
    // const response = await fetch(`http://localhost:8011/plus?num1=${num1.value}&num2=${num2.value}`);

    /* 백엔드를 쿠버네티스를 활용한 워커노트로 띄웠을 경우(30001번 NodePort) */
    const response = await fetch(`http://localhost:30001/plus?num1=${num1.value}&num2=${num2.value}`);

    const data = await response.json();
    result.value = data.sum;
  }
</script>

<style scoped>
  .plus {
    text-align: center;
  }
</style>
