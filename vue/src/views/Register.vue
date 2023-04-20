<template>
  <section id="register-page">
    <div class="center-image">
      <img class="image" src="../assets/logo3.png" alt="Logo" />
    </div>
    <div class="wrapper-register">
      <div class="register-box">
      <div id="register" class="text-center">
        <div class="title">
          <h1>Create Account</h1>
        </div>
        <form @submit.prevent="register">
          <div role="alert" v-if="registrationErrors">
            {{ registrationErrorMsg }}
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
            <label for="username">Username</label>
          </div>
          <div class="form-input-group">
            <box-icon class="icon" name='lock-open'></box-icon>
            <input
              type="password"
              id="password"
              v-model="user.password"
              required
            />
            <label for="password">Password</label>
          </div>
          <div class="form-input-group">
            <box-icon class="icon" name='lock-open'></box-icon>
            <input
              type="password"
              id="confirmPassword"
              v-model="user.confirmPassword"
              required
            />
           <label for="confirmPassword">Confirm Password</label>
          </div>
          <button class="btn" type="submit">Create Account</button>
          <div class="link">
          <p>
            Already have an account? 
            <router-link :to="{ name: 'login' }"
              >Log in.</router-link
            >
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
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

.wrapper-register {
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

.register-box {
  width: 100%;
}



</style>
