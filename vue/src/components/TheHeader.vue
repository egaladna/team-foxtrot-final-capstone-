<template>
  <div>
      <div class= "nav">
           <router-link v-bind:to="{ name: 'home' }">Home </router-link>
           <router-link v-if="$route.name != 'closet' " v-bind:to="{ name: 'closet' }">My Closet </router-link>
           <router-link v-if="$route.name == 'closet' || $route.name == 'outfits' " v-bind:to="{ name: 'selection' }">Choose Outfit </router-link>
           <router-link v-if="$route.name == 'closet' || $route.name == 'selection' " v-bind:to="{ name: 'outfits' }">My Outfits </router-link>
           <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.nav a{
    padding: 15px 24px;
}
</style>