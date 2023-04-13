<template>
  <div id="main">
    <div id="header">

      <img src="./assets/header.jpg" alt="Logo">
    </div>
    <div id="l-nav">
     <TheHeader />
    </div>
    <div id="r-nav">
     <TheHeader />
    </div>
    <div id="router">
    <router-view />
    </div>
    <div id = "footer">
      <TheFooter />
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
  grid-template-columns: 10% 80% 10%;
  grid-template-areas: "header  header  header"
                       "l-nav   router  r-nav"
                       "footer  footer  footer";
    row-gap: 20px;

}

#header {
  grid-area: header;
  display: flex;
  justify-content: center;
}
img {
  display: block;
  width: auto;
  height: auto;
  max-width: 400px;
  max-height: 200px;
  object-fit: contain;
}

#l-nav {
  grid-area: l-nav;
 
}
#r-nav {
  grid-area: r-nav;
 
}

#router {
  grid-area: router;
  display: flex;
  justify-content: center;
}

#footer {
  grid-area: footer;
}
</style>