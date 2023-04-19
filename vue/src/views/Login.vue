<template>
  <section id="login">
    <div class="center-image">
      <img class="image" src="../assets/logo3.png" alt="Logo" />
    </div>
    <div class="wrapper">
      <div class="box">
        <div class="form-box">
          <div class="title">
            <h1>Login</h1>
          </div>
          <form @submit.prevent="login">
            <div role="alert" v-if="invalidCredentials">
              Invalid username and password!
            </div>
            <div role="alert" v-if="this.$route.query.registration">
              Thank you for registering, please sign in.
            </div>
            <div class="form-input-group">
              <span class="icon"><box-icon name="user"></box-icon></span>
              <input
                type="text"
                id="username"
                v-model="user.username"
                required
                autofocus
              />
              <label for="username"> Username</label>
            </div>
            <div class="form-input-group">
              <span class="icon"><box-icon name="lock"></box-icon></span>
              <input
                type="password"
                id="password"
                v-model="user.password"
                required
              />
              <label for="password"> Password</label>
            </div>
            <button type="submit" class="btn">Sign in</button>
            <div class="link">
              <p>
                Need an account?
                <router-link :to="{ name: 'register' }">Sign up</router-link>
              </p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style >
/* #login {
  padding-top: 400px;
  padding-bottom: 400px;
  background: url("../assets/background2.png");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
} */
.center-image {
  display: flex;
  justify-content: center;
  align-items: center;
  border: none;
  
}
.image {
  display: flex;
  border: none;
  width: 40%;
  justify-content: center;
  align-items: center;
  margin-top: 80px;
  margin-right: 200px;
  
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
.wrapper {
  display: flex;
  align-items: center;
  position: absolute;
  top: 0;
  right: 0;
  width: 450px;
  height: 100%;
  background: transparent;
  backdrop-filter: blur(15px);
  box-shadow: -1px 0 10px rgba(0, 0, 0, 0.2);
  border-left: 2px solid rgba(255, 255, 255, 0.1);
  z-index: 100;
  padding: 0 40px;
}
.wrapper .box {
  width: 100%;
}
.title {
  font-size: 32px;
  text-align: center;
  color: #EBEFD1;
  margin-bottom: 40px;
}
.form-input-group {
  position: relative;
  width: 100%;
  height: 50px;
  margin: 30px 0;
  border-bottom: 2px solid #EBEFD1;
}

.form-input-group input {
  width: 100%;
  height: 100%;
  background: transparent;
  border: none;
  outline: none;
  font-size: 18px;
  color: black;
}

.form-input-group label {
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  font-size: 16px;
  color: #EBEFD1;
  font-weight: 500;
  pointer-events: none;
  transition: 0.5s;
}
.form-input-group input:focus ~ label,
.form-input-group input:valid ~ label {
  top: -3px;
}

.form-input-group .icon {
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
  font-size: 19px;
  color: #fff;
}

.btn {
  width: 100%;
  height: 45px;
  background: #fff;
  border: none;
  outline: none;
  border-radius: 40px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  cursor: pointer;
  font-size: 16px;
  color: #222;
  font-weight: 600;
}
.link {
  font-size: 14.5px;
  color: #fff;
  text-align: center;
  font-weight: 500;
  margin-top: 25px;
}

.link p a {
  color: #be6346;
  text-decoration: none;
  font-weight: 600;
}

.link p a:hover {
  text-decoration: underline;
}
</style>