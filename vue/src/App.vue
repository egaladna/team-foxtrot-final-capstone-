<template>
  <div id="main">
    <div id="header">

      <img src="./assets/header.jpg" alt="Logo">
    </div>
    <div id="nav">
     <TheHeader />
    </div>
    <div id="router">
    <router-view />
    <div id = "footer">
      <TheFooter />
    </div>
    
    </div>
  </div>
</template>

<script>
import TheHeader from '../src/components/TheHeader.vue'
import TheFooter from './components/TheFooter.vue'

export default {
  components: {
   TheHeader,
    TheFooter
  }
}
</script>


<style scoped>
#main {
  display: grid;
  grid-template-columns: 20% 80%;
  grid-template-areas: " nav header"
                       " nav   router"
                       " nav   router"
                       " footer footer ";
    row-gap: 20px;
    column-gap: 50px;
}

#header {
  grid-area: header;
}
img {
  display: block;
  width: auto;
  height: auto;
  max-width: 400px;
  max-height: 200px;
  object-fit: contain;
}

#nav {
  grid-area: nav;
  row-gap: 0px;
  padding-bottom: 400px;
}

#router {
  grid-area: router;
}

#footer {
  grid-area: footer;
}
</style>