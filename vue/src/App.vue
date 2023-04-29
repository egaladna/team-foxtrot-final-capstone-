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
    font-family: "Aleo", sans-serif;
 }


#router {
 justify-content: center;
 background: url("./assets/background2.png");
 background-size: cover;
 background-repeat: no-repeat;
 background-position: center;
 height: 100vh;
  
}

#l-nav {
  height: 0px;
}

</style>