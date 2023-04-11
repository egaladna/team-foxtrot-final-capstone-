<template>
  <div id="app">
    <div id="nav">
     <TheHeader />
      
    </div>
    <router-view />
  </div>
</template>

<script>
import TheHeader from '../src/components/TheHeader.vue'

export default {
  components: {
   TheHeader
  }
}
</script>


<style scoped>
#app {
  display: flex;
  flex-direction: column;
}
</style>
