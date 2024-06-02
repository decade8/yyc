<template>
  <div class="writer">
    <h3>作者管理</h3>
    <!-- 主体区域 -->
    <!--头部-->
    <div class="header">
      <div class="xjbutton">
        <el-button type="text" @click="dialogFormVisible = true"
          >新建</el-button
        >
      </div>
      <div class="search">
        <div class="search0">
          <el-input placeholder="请输入内容" v-model="input" clearable>
          </el-input>
        </div>
        <div class="search1">
          <el-button
            type="primary"
            icon="el-icon-search"
            id="search1"
            @click="search"
            >搜索</el-button
          >
        </div>
      </div>
    </div>

    <!-- 弹框部分 -->
    <div class="dialog">
      <!-- 新增弹框 -->
      <el-dialog title="新增用户" :visible.sync="dialogFormVisible">
        <el-form :model="form" :rules="rules">
          <!-- :model保存表单的数据对象 form-->
          <el-form-item label="日期" :label-width="formLabelWidth" prop="date" >
            <el-input v-model="form.date" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item
            label="省份"
            :label-width="formLabelWidth"
            prop="province"
          >
            <el-select
              v-model="form.province"
              placeholder="请选择省"
              @change="changePro"
              style="width: 575px"
            >
              <el-option
                v-for="item in addressData"
                :key="item.code"
                :label="item.name"
                :value="item.name"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="市区" :label-width="formLabelWidth" prop="city">
            <el-select
              v-model="form.city"
              placeholder="请选择市"
              @change="changeCity"
              style="width: 575px"
            >
              <el-option
                v-for="item in cityData"
                :key="item.code"
                :label="item.name"
                :value="item.name"
              >
              </el-option>
            </el-select>
            <!-- <el-input v-model="form.city" autocomplete="off"></el-input> -->
          </el-form-item>
          <el-form-item
            label="地址"
            :label-width="formLabelWidth"
            prop="address"
          >
            <el-input v-model="form.address" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="邮编"
            :label-width="formLabelWidth"
            prop="emailcode"
          >
            <el-input v-model="form.emailcode" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button
            type="primary"
            @click="
              dialogFormVisible = false;
              addwriter();
            "
            >确 定</el-button
          >
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="dialog1">
      <!-- 修改弹框 -->
      <el-dialog title="修改用户" :visible.sync="dialogFormVisible1">
        <el-form :model="form" :rules="rules">
          <!-- :model保存表单的数据对象 form-->
          <el-form-item label="日期" :label-width="formLabelWidth" prop="date">
            <el-input v-model="form.date" autocomplete="off" ></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off" ></el-input>
          </el-form-item>
          <el-form-item
            label="省份"
            :label-width="formLabelWidth"
            prop="province"
          >
            <el-select
              v-model="form.province"
              placeholder="请选择省"
              @change="changePro"
              style="width: 575px"
            >
              <el-option
                v-for="item in addressData"
                :key="item.code"
                :label="item.name"
                :value="item.name"
              >
              </el-option>
            </el-select>
            <!-- <el-input v-model="form.province" autocomplete="off"></el-input> -->
          </el-form-item>
          <el-form-item label="市区" :label-width="formLabelWidth" prop="city">
            <el-select
              v-model="form.city"
              placeholder="请选择市"
              @change="changeCity"
              style="width: 575px"
            >
              <el-option
                v-for="item in cityData"
                :key="item.code"
                :label="item.name"
                :value="item.name"
              >
              </el-option>
            </el-select>
            <!-- <el-input v-model="form.city" autocomplete="off"></el-input> -->
          </el-form-item>
          <el-form-item
            label="地址"
            :label-width="formLabelWidth"
            prop="address"
          >
            <el-input v-model="form.address" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="邮编"
            :label-width="formLabelWidth"
            prop="emailcode"
          >
            <el-input v-model="form.emailcode" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button
            type="primary"
            @click="
              dialogFormVisible1 = false;
              update1();
            "
            >修 改</el-button
          >
          <el-button @click="dialogFormVisible1 = false">取 消</el-button>
        </div>
      </el-dialog>
    </div>
    <!-- 确认删除弹框 -->
    <div class="delete">
      <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="16"
          height="16"
          fill="currentColor"
          class="bi bi-exclamation-circle-fill"
          viewBox="0 0 16 16"
        >
          <path
            d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8 4a.905.905 0 0 0-.9.995l.35 3.507a.552.552 0 0 0 1.1 0l.35-3.507A.905.905 0 0 0 8 4zm.002 6a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"
          />
        </svg>
        <span>此操作将删除作者数据，是否继续?</span>
        <span slot="footer" class="dialog-footer">
          <el-button
            type="primary"
            @click="
              dialogVisible = false;
              delete1();
            "
            >确 定</el-button
          >
          <el-button @click="dialogVisible = false">取 消</el-button>
        </span>
      </el-dialog>
    </div>
    <!-- 内容部分 -->
    <div class="content">
      <el-table :data="fillist" border style="width: 100%">
        <el-table-column fixed prop="xuhao" label="序号" width="150">
        </el-table-column>
        <el-table-column prop="date" label="日期" width="120">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="province" label="省份" width="120">
        </el-table-column>
        <el-table-column prop="city" label="市区" width="120">
        </el-table-column>
        <el-table-column prop="address" label="地址" width="250">
        </el-table-column>
        <el-table-column prop="emailcode" label="邮编" width="150">
        </el-table-column>
        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <el-button
              type="text"
              @click="
                dialogFormVisible1 = true;
                handleClick(scope.row);
              "
              >编辑</el-button
            >
            <el-button
              type="text"
              @click="
                dialogVisible = true;
                handleClick(scope.row);
              "
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <div class="block1">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-size="5"
          layout="total, prev, pager, next"
          :total="this.total"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
// 引入省份城市数据
import address from "../utils/address.json"; //全国省市区街道数据

import { registerWriter } from "../api/post";
import { findWriter } from "../api/get";
import { findWriter1 } from "../api/get";
import { findWriter2 } from "../api/get";
import { deleteWriter } from "../api/get";
import { updateWriter } from "../api/post";
import {findone} from "../api/get";
import { len, required, date, integer, Chinese ,len1} from "../utils/formrules";
import { get } from "axios";
// import { watch } from 'vue'

export default {
  name: "writer",
  methods: {
    // 查询结果
    search() {
      findWriter2(5 * (this.page - 1), 5, this.input).then((res) => {
        // console.log(res.data);
        this.fillist = res.data.data;
        this.total = this.fillist.length;
      });
      if (this.input === "") {
        //this.input是string类型
        // console.log("hhh");
        findWriter().then((res) => {
          this.tableData1 = res.data.data;
          this.total = this.tableData1.length;
        });
        findWriter1(5 * (this.page - 1), 5).then((res) => {
          this.fillist = res.data.data;

          // 获取年月日
          this.gettime(), (this.form.date = this.nowDate);
        });
      }
    },

    // 处理分页函数
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      console.log("1");
    },
    handleCurrentChange(val) {
      console.log(val);
      this.page = val;
      // console.log(typeof this.page);
      findWriter().then((res) => {
        this.tableData1 = res.data.data;
        this.total = this.tableData1.length;
      });
      findWriter1(5 * (val - 1), 5).then((res) => {
        this.fillist = res.data.data;

        // 获取年月日
        this.gettime(), (this.form.date = this.nowDate);
      });
      // console.log(typeof(val));
      // console.log(`当前页: ${val}`);
    },

    handleClick(row) {
      // 将序号转化为数字型
      this.number = parseInt(row.xuhao);
      // console.log(this.number);
      findone(this.number).then((res)=>{
        this.msg=res.data.data
        // console.log(res.data.data);
        console.log(this.msg);

      })
    },
    // 修改作者数据
    update1() {
      this.form.xuhao = this.number;
      // console.log(typeof(this.form.xuhao));
      this.updateWriter(this.form);
      this.form = {};
    },
    async updateWriter(obj) {
      await updateWriter(obj).then((res) => {
        alert(res.data.data);
        // console.log(this.form);
        //更新后重新渲染
        findWriter().then((res) => {
          this.tableData1 = res.data.data;
          this.total = this.tableData1.length;
        });

        findWriter1(5 * (this.page - 1), 5).then((res) => {
          this.fillist = res.data.data;

          // 获取年月日
          this.gettime(), (this.form.date = this.nowDate);
        });
      });
    },

    // 删除作者数据 delete1函数
    delete1() {
      console.log(typeof this.number);
      this.deleteWriter(this.number);
    },
    async deleteWriter(obj) {
      await deleteWriter(obj).then((res) => {
        console.log(res.data.data);
        // 删除完重新渲染
        findWriter().then((res) => {
          this.tableData1 = res.data.data;
          this.total = this.tableData1.length;
        });
        findWriter1(5 * (this.page - 1), 5).then((res) => {
          this.fillist = res.data.data;

          // 获取年月日
          this.gettime(), (this.form.date = this.nowDate);
        });
      });
    },

    // 将数据发送给后端
    addwriter() {
      //给id赋值,需要赋值唯一
      this.form.xuhao = this.total + 1;
      // console.log(this.form);
      this.registerWriter(this.form);
      this.form = {};
      // 这里要加this代表引入的函数
    },

    async registerWriter(obj) {
      await registerWriter(obj).then((res) => {
        // console.log(res.data)
        alert(res.data.data);
        // 新建完成后马上重新渲染数据
        findWriter().then((res) => {
          this.tableData1 = res.data.data;
          this.total = this.tableData1.length;
        });
        findWriter1(5 * (this.page - 1), 5).then((res) => {
          console.log(this.page);
          this.fillist = res.data.data;

          // 获取年月日
          this.gettime(), (this.form.date = this.nowDate);
        });
      });
    },

    // 省份更改
    changePro(e) {
      // 从省中过滤出市的数据
      this.cityData = this.addressData.filter((item) => {
        return item.name == e;
      })[0].children;
      // 省发生改变的时候 清空输入框市区街道的内容
      this.form.city = this.cityData[0].name;
      // 省发生更改时 该表空区街道数据的内容
    },

    // 市更改
    changeCity(e) {
      // 获取到区的数据
      this.areaData = this.cityData.filter(
        (item) => item.name == e
      )[0].children;
      // 清空数据后面对应数组的数据
      this.form.district = this.areaData[0].name;
    },

    // 获取年月日
    gettime() {
      const date = new Date();
      this.nowDate =
        date.getFullYear() +
        "年" +
        (date.getMonth() + 1) +
        "月" +
        date.getDate() +
        "日";
      console.log(this.nowDate);
    },
  },
  data() {
    return {
      ok:"999",
      //存放修改的用户的查询数据
      msg:{},

      // 存放当前的页数
      page: 1,

      // 存放当前的年月日
      nowDate: "",

      // 存数据条数
      total: 0,
      //  省数据
      addressData: [],
      //  市数据
      cityData: [],

      //用来存放序号
      number: 0,
      input: "", //搜索栏输入的内容
      //输入框校验规则
      rules: {
        xuhao: [required, len(10)],
        date: [required, date],
        // name项必须填写内容，且字符长度在10之内
        name: [required, len(10), Chinese],
        province: [required, len(10)],
        city: [required, len(10)],
        address: [required, len(10)],
        emailcode: [required, integer,len1(6)],
      },
      // 声明一个数组作为主体内容的展示部分（分页）
      tableData: [],
      // 声明一个数组用来获取总的数据条数
      tableData1: [],
      //用来显示搜索匹配到的数据的数组
      fillist: [],
      // 控制弹框的显示与消失
      dialogFormVisible: false,
      dialogFormVisible1: false,
      dialogVisible: false,
      // 弹框的数据
      form: {
        xuhao: "",
        date: "",
        name: "",
        emailcode: "",
        province: "",
        city: "",
        address: "",
      },
      formLabelWidth: "120px",
    };
  },
 
  created() {
    // 测试修改用户的数据获取
    // findone(1).then((res)=>{
    //   console.log(res.data.data);

    // })

    // console.log(typeof this.input); //string
    findWriter1(0, 5).then((res) => {
      this.tableData = res.data.data;
      this.fillist = this.tableData;

      // console.log(res.data.data)
    }),
      // 用来获取总的数据条数
      findWriter().then((res) => {
        this.tableData1 = res.data.data;
        this.total = this.tableData1.length;
      });
    // 获取年月日
    this.gettime(), (this.form.date = this.nowDate);

    // 省份数据初始化
    this.addressData = address;
    // console.log("this.form",this.form)

    if (this.form.province != "") {
      let cityData = this.addressData.filter(
        (item) => item.name == this.form.province
      );
      if (cityData.length) {
        this.cityData = cityData[0].children;
      }
    }
  },

  // 监听搜索框的输入变化
  watch: {
    input: {
      immediate: true, //在框的值还没变化时执行如下函数显示出所有的情况
      handler(val) {
        console.log(val); //val代表实时输入的数值
        this.fillist = this.tableData.filter((p) => {
          return p.name.indexOf(val) !== -1;
        });
      },
    },
  },
};
</script>

<style scoped>
@import "../assets/css/writer.css";
</style>