<template>

<div class="homepage">
  <div id="image">
    <img src="../assets/touxiang.jpg" alt="" id="touxiang">
  </div>
  <div id="rili">
    <el-calendar v-model="value" id="rilimax">
    </el-calendar>
  </div>
</div>
  
</template>

<script>
export default {
  name: 'homepage',
  props:['msg']
}
</script>


<style scoped>

@import "../assets/css/homePage.css";

</style>