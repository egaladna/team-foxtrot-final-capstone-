<template>
  <div id="main">
    <div id="header">

      <img src="./assets/header.jpg" alt="Logo">
    </div>
    <div id="l-nav">
     <TheHeader />
    </div>
    <div id="r-nav">
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
  grid-template-areas: "l-nav  header  r-nav"
                       "l-nav   router  r-nav"
                       "footer  footer  footer";

}

#header {
  grid-area: header;
  display: flex;
  justify-content: center;
  background-color: #001e10;
}
img {
  display: block;
  width: auto;
  height: auto;
  max-width: 400px;
  max-height: 200px;
  object-fit: contain;
  border: none;
}

#l-nav {
  grid-area: l-nav;
  display: flex;
  justify-content: center;
  background-color: #001e10;
  padding-top: 50px;
}

#r-nav {
  grid-area: r-nav;
  background-color: #001e10;
 
}

#router {
  grid-area: router;
  display: flex;
  justify-content: center;
  min-height: 60vh;
  padding-bottom: 20px;
}

#footer {
  grid-area: footer;
  background-color: #be6e46;
}
</style>