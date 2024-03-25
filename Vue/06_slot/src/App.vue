<!--
  컴포넌트의 lifeCycle hooks를 사용하는 방식은 2가지가 있으며,
  아래의 정리된 방법과 <script setup>으로 script를 setup 지시문으로 추가하여
  hooks를 바로 사용할 수 있다.
-->
<script setup>
  import {onMounted} from "vue";
  export default {
    setup() {
      onMounted(async() => {
        console.log("Hello! Vue~~!");
      })
    }
  }
</script>

<template>
  <p>Hello!</p>
</template>

<style scoped>

</style>
