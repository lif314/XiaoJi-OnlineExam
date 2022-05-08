// 展示组件页面
<template>
  <div id="index">
    <header1 class="topbar"></header1>
    <section class="container">
      <div class="left_side">
        <mainLeft></mainLeft>
      </div>
      <div class="main_wrapper">
        <navigator class="nav"></navigator>
        <router-view></router-view>
      </div>
    </section>
  </div>
</template>

<script>
import header from "@/components/common/header";
import mainLeft from "@/components/common/mainLeft";
import navigator from "@/components/common/navigator";
export default {
  components: {
    header1: header,
    mainLeft: mainLeft,
    navigator: navigator,
  },
  data() {
    return {
      username: "许如梦",
    };
  },
  created() {
    this.userInfo();
  },
  methods: {
    userInfo() {
      let name = this.$cookies.get("cname");
      let loginNum = this.$cookies.get(name + "num");
      // 显示登录消息
      this.$message({
        message: `${name}，您好！这是你第${loginNum}次光临本站`,
        type: "success",
      });
    },
  },
};
</script>

<style lang="scss" scoped>
#index .nav {
  box-shadow: 1px 0 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 30px;
}
.container {
  display: flex;
  background-color: #fff;
}
.main_wrapper {
  overflow: hidden;
  flex: 1;
  background-color: #fff;
}
</style>

