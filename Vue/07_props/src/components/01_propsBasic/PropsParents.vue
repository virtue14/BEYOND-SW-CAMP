<script setup>
import {ref} from "vue";
import PropsChild from "@/components/01_propsBasic/PropsChild.vue";
import DarkMode from "@/components/01_propsBasic/DarkMode.vue";

const message = ref('hello');
const darkState = ref(false);

function toggleDarkMode() {
  darkState.value = !darkState.value;
}
</script>

<template>
  <div :class="{container: true, dark: darkState}">
    props 입력: <input v-model="message"/>
    <PropsChild :message="message"/>
    <DarkMode @toggle="toggleDarkMode"/>
  </div>
</template>

<style scoped>
.container {
  border: 1px solid;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.dark {
  background-color: black;
  color: white;
}
</style>
