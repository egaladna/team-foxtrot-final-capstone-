import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import cloudinary from 'cloudinary-vue'
import VueSocialSharing from 'vue-social-sharing'
 




Vue.config.productionTip = false


axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(VueSocialSharing, cloudinary, {
  configuration: {
    cloudName: 'dlnxljpbd',
    secure: false
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')