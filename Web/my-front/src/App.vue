<template>
  <div>
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <input v-model="userInfo.userId" type="text">
    <input v-model="userInfo.userPw" type="text">

    <input v-model="answer" type="text">

    <p>{{ inputCheckMsg }}</p>
    <p>{{ addAnswerIzone }}</p>

    <button @click="clickInputEndButton" >입력종료</button>
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
      userInfo,
      inputCheckMsg:'입력 안하고 있음',
      answer : ''  
    }
  },
  watch:{ // watch는 특정값이 변경될때 실행
    answer: function(newVal, oldVal){
      this.inputCheckMsg = oldVal +  ' 에서 '+ newVal +' 으로 변경 중'
    }
  },
  computed:{ // computed는 그냥 어떤값을 계산해서 반환함
    addAnswerIzone: function(){
      return this.answer + ' 아이즈원 짱짱맨';
    }
  },
  methods: { // 이건 그냥 함수
    clickInputEndButton:function(){
      this.inputCheckMsg = '입력 끝!!';
    }
  },

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
