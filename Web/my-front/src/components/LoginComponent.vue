<template>
    <div>
        {{ userId }}
        <br>
        {{ userPw }}
    </div>
</template>


<script>
export default {
    name:'LoginComponent',
    props:['userId', 'userPw']
}
</script>