<template>
  <div class="user">
    <div class="image">
    <img src="../assets/touxiang.jpg" alt="" id="touxiang">
    </div>
    <div class="imf">
      <strong>用户基本信息</strong>
      <el-table
      style="width: 100%"
      :data="getValues"
      :show-header="false"
      :border="true"
    >
      <el-table-column
        v-for="(item, index) in getHeaders"
        :key="index"
        :prop="item"
      >
      </el-table-column>
    </el-table>

    </div>
  </div>

 
 </template>
 
 <script>
 export default {
   name:'user',
   props:['name1','username1','email1','year1'],
   data(){
    return{
      headers: [
        {
        prop: 'name',
        label: '姓名',
      },
      {
        prop: 'username',
        label: '用户名',
      },
      {
        prop: 'email',
        label: '邮箱',
      },
      {
        prop: 'birthday',
        label: '生日',
      },
    ],
    tableData: [
      {
       name:this.name1,
       username:this.username1,
       email:this.email1,
       birthday:this.year1
      },
    ]
    }
   },
   computed: {
  getHeaders() {
    return this.tableData.reduce((pre, cur, index) => pre.concat(`value${index}`), ['title'])
  },
  getValues() {
    return this.headers.map(item => {
      return this.tableData.reduce((pre, cur, index) => Object.assign(pre, {['value' + index]: cur[item.prop]}), {'title': item.label,});
    });
  }}
 
 }
 </script>
 
 <style scoped>

    @import "../assets/css/user.css";
 </style>