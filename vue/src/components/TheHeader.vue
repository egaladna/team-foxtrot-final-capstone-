<template>
  <div class="postion">
    <header class="header">
      <a href="http://localhost:8080">
      <img src="../assets/logo4.png" class="logo" alt="Logo"
    /></a>
      <nav id="nav">
        <router-link v-if="$route.name != 'home'" v-bind:to="{ name: 'home' }"
          >Home
        </router-link>
        <router-link
          v-if="$route.name != 'closet'"
          v-bind:to="{ name: 'closet' }"
          >My Closet
        </router-link>
        <router-link
          v-if="$route.name == 'closet' || $route.name == 'outfits'"
          v-bind:to="{ name: 'selection' }"
          >Choose Outfit
        </router-link>
        <router-link
          v-if="$route.name == 'closet' || $route.name == 'selection'"
          v-bind:to="{ name: 'outfits' }"
          >My Outfits
        </router-link>
        <button class="login">
          <router-link
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token == ''"
            >Login</router-link
          >
        </button>
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </nav>
    </header>
  </div>
</template>

<script>
export default {};
</script>

<style>
.header {
  display: flex;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  padding: 20px 130px;
  background: transparent;
  justify-content: space-between;
  align-items: center;
  z-index: 99;
}

.logo {
  display: flex;
  align-items: flex-start;
  border: none;
  cursor: pointer;
  justify-content: stretch;
  width: 100px;
  /* margin-left: 200px;
  margin-bottom: 60px; */
}
.header .login {
  position: relative;
  background: transparent;
  border: none;
  outline: none;
  font-size: 19px;
  font-weight: 500;
  cursor: pointer;
}
.header .login::before {
  content: "";
  position: absolute;
  left: 0;
  bottom: -4px;
  width: 58%;
  height: 2px;
  background: #fff;
  opacity: 0.85;
}
#nav a {
  color: #ebefd1;
  border-radius: 8px;
  font-family: sans-serif;
  text-decoration: none;
  font-size: 19px;
  font-weight: 500;
  margin-right: 40px;
}
#nav a:hover {
  background-color: #ebefd1;
  color: #001e10;
  cursor: copy;
}
</style>