<!-- frontend/src/App.vue -->
<template>
  <div id="app" class="app-root">
    <MainHeader />

    <main class="main-content">
      <RouterView />
    </main>

    <MainFooter />
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router'
import MainHeader from './components/layout/MainHeader.vue'
import MainFooter from './components/layout/MainFooter.vue'
</script>
