<template>
  <div>
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <input v-model="userInfo.userId" type="text">
    <input v-model="userInfo.userPw" type="text">
    <LoginComponent v-bind="userInfo"></LoginComponent>
  </div>

</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import LoginComponent from './components/LoginComponent.vue'

let userInfo = {
  userId : '',
  userPw : ''
}

export default {
  name: 'App',
  components: {
    LoginComponent
  },
  data(){
    return {
      userInfo
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
