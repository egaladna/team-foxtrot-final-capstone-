<template>
  <div id="main">
    <div id="l-nav">
     <TheHeader />
    </div>
    <div id="r-nav">
    </div>
    <div id="router">
    <router-view />
    </div>
    <!-- <div id = "footer"> -->
      <!-- <TheFooter /> -->
    <!-- </div> -->
    
    </div>
</template>

<script>
import TheHeader from '../src/components/TheHeader.vue'
// import TheFooter from './components/TheFooter.vue'

export default {
  components: {
   TheHeader,
    // TheFooter
  }
}
</script>


<style>
#clothingList-clothing-items {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
#clothingList-closet {
  display: flex;
  flex-direction: column;
  align-items: center;
}
body {
  background: url("./assets/background2.png");
    /* background-color: #ebefd1;  */
    font-family: "Aleo", sans-serif;
 }


/* #main {
  display: grid;
  grid-template-columns: 10% 80% 10%;
  grid-template-areas: "l-nav  header  r-nav"
                       "l-nav   router  r-nav"
                       "footer  footer  footer";

} */


/* #header {
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
  border: none;
} */

/* #l-nav {
  grid-area: l-nav;
  display: flex;
  justify-content: center;
  padding-top: 50px;
  background-color: #f37333;
}

/* #r-nav {
  grid-area: r-nav;
 
} */

#router {
 padding-top: 100;
 justify-content: center;
  
  
}

#l-nav {
  height: 0px;
}
/* 
#footer {
  height: 1vh;
  background-color: transparent;
} */
</style>