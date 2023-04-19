<template>
  <div class="view-frame">
    <h1>Welcome</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home",
 
};
</script>
<style scoped>


/* .view-frame {
   display: flex;
   padding-top: 600px;
   padding-bottom: 600px;
   background: url('../assets/background2.png');
   background-size: cover;
   background-repeat: no-repeat;
   background-position: center center;

} */
.view-frame {
  display: flex;
  padding-top: 50vh;
  justify-content: center;
}

h1 {
  display: flex;
  justify-content: center;
  text-align: center;
  align-items: center;
  justify-content: center;
  color: #3B3355;
  font-family: sans-serif;
}


 p {
  display: flex;
  text-align: center;
}

</style>
