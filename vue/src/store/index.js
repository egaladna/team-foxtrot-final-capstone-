import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
// const currentToken = localStorage.getItem('token')
const currentToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY4MTIxOTk4OX0.8vdVMR3MvtxC0OUiZs7ukYZCde4t5lbc9Y0BGG5xPgjQa8EibSrX_sRuyuofMJizyaCJ0S9u1j0ETC8YMttPAA'
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    selectedItems: [],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SELECT_ITEM(state, cloth) {
      state.selectedItems = state.selectedItems.filter((item) => {
        return item.type != cloth.type;
      });
      state.selectedItems.unshift(cloth);
    },
    DESELECT_ITEM(state, cloth) {
      const blankSelection = {type: cloth.type};
      this.commit('SELECT_ITEM', blankSelection);

      //state.selectedItems = state.selectedItems.filter( (item) => {
        //return item.id != cloth.id;
      //});
    },
  }
})
