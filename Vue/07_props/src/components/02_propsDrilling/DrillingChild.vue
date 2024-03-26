<script setup>
import {inject} from "vue";
import GrandChild from "@/components/02_propsDrilling/DrillingGrandChild.vue";

const injectCount = inject('count');
</script>

<template>
  <h2>child: {{injectCount}}</h2>
  <GrandChild/>
</template>

<style scoped>

</style>
