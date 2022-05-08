<!-- 用户登录界面 -->
<template>
  <div id="login">
    <div class="header">
      <el-row class="main-container">
        <el-col :lg="8" :xs="16" :md="10" :span="10">
          <div class="top">
            <i class="iconfont icon-kaoshi"></i
            ><span class="title">小济在线考试系统</span>
          </div>
          <div class="bottom">
            <div class="container">
              <p class="title">账号登录</p>
              <el-form
                :label-position="labelPosition"
                label-width="80px"
                :model="formLabelAlign"
              >
                <el-form-item label="用户名">
                  <el-input
                    v-model.number="formLabelAlign.username"
                    placeholder="请输入用户名"
                  ></el-input>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input
                    v-model="formLabelAlign.password"
                    placeholder="请输入密码"
                    type="password"
                  ></el-input>
                </el-form-item>
                <div class="submit">
                  <el-button type="primary" class="row-login" @click="login()"
                    >登录</el-button
                  >
                </div>
                <div class="options">
                  <p class="find">
                    <a href="javascript:;" @click="openTip">{{ tip }}</a>
                  </p>
                  <!-- <div class="register">
                  <span>没有账号?</span>
                  <span><a href="javascript:;">去注册</a></span>
                </div> -->
                </div>
              </el-form>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 背景动画 -->
      <svg
        class="WaveMultiGroup"
        viewBox="0 24 150 28"
        preserveAspectRatio="none"
        shapeRendering="auto"
      >
        <path
          fill="rgba(255,255,255,0.7)"
          d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
        ></path>
        <path
          fill="rgba(255,255,255,0.5)"
          d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
        ></path>
        <path
          fill="rgba(255,255,255,0.3)"
          d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
        ></path>
        <path
          fill="rgba(255,255,255,1)"
          d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
        ></path>
      </svg>
    </div>

    <el-row class="footer">
      <el-col>
        <p class="msg2">
          版权所有 ©2022 同济大学软件学院李林飞 保留所有权利
          <a href="http://beian.miit.gov.cn/" target="_blank"
            >沪ICP备19001371号</a
          >
        </p>
      </el-col>
    </el-row>
    <section class="remind" v-show="isTip">
      <span>管理员账号：9527</span>
      <span>教师账号：20081001</span>
      <span>密码都是：123456</span>
    </section>
  </div>
</template>

<script>
import store from "@/vuex/store";
import { mapState } from "vuex";
export default {
  store,
  name: "login",
  data() {
    return {
      role: 2,
      labelPosition: "left",
      formLabelAlign: {
        username: "20154084",
        password: "123456",
      },
      isTip: false,
      tip: "测试账号提示",
    };
  },
  methods: {
    // 测试账号提示
    openTip() {
      this.isTip = !this.isTip;
      if (this.isTip) {
        this.tip = "关闭提示";
      } else {
        this.tip = "测试账号提示";
      }
    },
    // 统计用户登录次数
    countLoginNum(cname) {
      const key = cname + "num";
      if (this.$cookies.isKey(key)) {
        // console.log("1111s")
        let strNum = this.$cookies.get(key);
        console.log(strNum)
        // 存在用户登录信息
        let num = parseInt(strNum);
        this.$cookies.set(key, num + 1);
      } else {
        this.$cookies.set(key, 1);
      }
      console.log(this.$cookies.get(key));
    },
    //用户登录请求后台处理
    login() {
      console.log("登录操作执行-------");
      this.$axios({
        url: `/api/login`,
        method: "post",
        data: {
          ...this.formLabelAlign,
        },
      }).then((res) => {
        let resData = res.data.data;
        if (resData != null) {
          switch (resData.role) {
            case "0": //管理员
              this.$cookies.set("cname", resData.adminName);
              this.$cookies.set("cid", resData.adminId);
              this.$cookies.set("role", 0);
              this.countLoginNum(resData.adminName);
              this.$router.push({ path: "/index" }); //跳转到首页
              break;
            case "1": //教师
              this.$cookies.set("cname", resData.teacherName);
              this.$cookies.set("cid", resData.teacherId);
              this.$cookies.set("role", 1);
              this.countLoginNum(resData.teacherName);
              this.$router.push({ path: "/index" }); //跳转到教师用户
              break;
            case "2": //学生
              this.$cookies.set("cname", resData.studentName);
              this.$cookies.set("cid", resData.studentId);
              this.countLoginNum(resData.studentName);
              this.$router.push({ path: "/student" });
              break;
          }
        }
        if (resData == null) {
          //错误提示
          this.$message({
            showClose: true,
            type: "error",
            message: "用户名或者密码错误",
          });
        }
      });
    },
    clickTag(key) {
      this.role = key;
    },
  },
  computed: mapState(["userInfo"]),
  mounted() {},
};
</script>

<style lang="scss" scoped>
// 背景动画
body {
  margin: 0;
}

.header {
  position: relative;
  background: linear-gradient(
    60deg,
    rgba(84, 58, 183, 1) 0%,
    rgba(0, 172, 193, 1) 100%
  );
}

.WaveMultiGroup {
  position: relative;
  width: 100%;
  height: 15vh;
  margin-bottom: -7px;
  min-height: 100px;
  max-height: 150px;
}

.WaveMultiGroup path {
  animation: multiwavemove 30s cubic-bezier(0.55, 0.5, 0.45, 0.5) infinite;
}

.WaveMultiGroup path:nth-child(1) {
  transform: translateY(0px);
  animation-delay: -2s;
  animation-duration: 7s;
}
.WaveMultiGroup path:nth-child(2) {
  transform: translateY(1px);
  animation-delay: -3s;
  animation-duration: 10s;
}
.WaveMultiGroup path:nth-child(3) {
  transform: translateY(2px);
  animation-delay: -4s;
  animation-duration: 13s;
}
.WaveMultiGroup path:nth-child(4) {
  transform: translateY(3px);
  animation-delay: -5s;
  animation-duration: 20s;
}

@keyframes multiwavemove {
  0% {
    transform: translate3d(-30px, 0, 0);
  }
  60% {
    transform: translate3d(80px, 0, 0);
  }
  100% {
    transform: translate3d(-30px, 0, 0);
  }
}
@media (max-width: 768px) {
  .waves-multi {
    height: 40px;
    min-height: 40px;
  }
}

// 提示框
.remind {
  border-radius: 4px;
  padding: 10px 20px;
  display: flex;
  position: fixed;
  right: 20px;
  bottom: 50%;
  flex-direction: column;
  color: #606266;
  background-color: #fff;
  border-left: 4px solid #409eff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

// 登录注册框
.container {
  margin-bottom: 32px;
}
.container .el-radio-group {
  margin: 30px 0px;
}
a:link {
  color: #ff962a;
  text-decoration: none;
}
#login {
  font-size: 14px;
  color: #000;
  background-color: #fff;
}

#login .main-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
#login .main-container .top {
  margin-top: 100px;
  font-size: 30px;
  color: #ff962a;
  display: flex;
  justify-content: center;
  background-color: #409eff;
}

#login .top .icon-kaoshi {
  font-size: 80px;
}
#login .top .title {
  margin-top: 20px;
}
#login .bottom {
  display: flex;
  justify-content: center;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
#login .bottom .title {
  text-align: center;
  font-size: 30px;
}
.bottom .container .title {
  margin: 30px 0px;
}
.bottom .submit .row-login {
  width: 100%;
  background-color: deepskyblue;
  border-color: #04468b;
  margin: 20px 0px 10px 0px;
  padding: 15px 20px;
}
.bottom .submit {
  display: flex;
  justify-content: center;
}
.footer {
  margin-top: 50px;
  text-align: center;
}
.footer .msg1 {
  font-size: 18px;
  color: #fff;
  margin-bottom: 15px;
}
.footer .msg2 {
  font-size: 14px;
  color: #e3e3e3;
  margin-top: 70px;
}
.bottom .options {
  margin-bottom: 40px;
  color: #ff962a;
  display: flex;
  justify-content: space-between;
}
.bottom .options > a {
  color: #ff962a;
}
.bottom .options .register span:nth-child(1) {
  color: #8c8c8c;
}
</style>
