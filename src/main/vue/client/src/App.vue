<template>
 <Planete></Planete>
</template>

<script>
import Planete from './components/Planete.vue'

export default {
  name: 'App',
  components: {
    Planete
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
