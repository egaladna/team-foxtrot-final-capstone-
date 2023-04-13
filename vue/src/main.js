import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { initializeApp } from "firebase/app";
import { getStorage } from "firebase/storage";



const firebaseConfig = {
  apiKey: "AIzaSyAze0hadhVuhuz9oCuM7GZhu7EpzP7hcGs",
  authDomain: "te-foxtrot---digital-closet.firebaseapp.com",
  projectId: "te-foxtrot---digital-closet",
  storageBucket: "te-foxtrot---digital-closet.appspot.com",
  messagingSenderId: "172605617246",
  appId: "1:172605617246:web:ce281caded118c72afb0cf",
  measurementId: "G-G1RPDK53JX"
};

const app = initializeApp(firebaseConfig);
export const storage = getStorage(app)



Vue.config.productionTip = false


axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')