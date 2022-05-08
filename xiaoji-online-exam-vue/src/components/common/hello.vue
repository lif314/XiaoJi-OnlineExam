<template>
  <section class="index">
    <div class="hello">
      <i class="iconfont icon-xihuan"></i><span>很高兴遇见你,{{user.userName}}老师。</span>
    </div>
    <div class="msg">
      <p class="title">教务公告：</p>
      <ul>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>疫情防控期间本科生教学相关业务FAQ</li>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>疫情防控期间本科生教学相关业务FAQ</li>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>疫情防控期间本科生教学相关业务FAQ</li>
        <li @click="openMsg()"><i class="iconfont icon-flag"></i>疫情防控期间本科生教学相关业务FAQ</li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      user: { //用户信息
        userName: null,
        userId: null
      } 
    }
  },
  created() {
    this.getUserInfo()
  },
  methods: {
    getUserInfo() { //获取用户信息
      let userName = this.$cookies.get("cname")
      let userId = this.$cookies.get("cid")
      this.user.userName = userName
      this.user.userId = userId
    },
    openMsg() {
      this.$alert('疫情防控期间，学校的本科教学形式发生了较大的调整和变化，为及时帮助同学们解决在学习中遇到的疑惑、困难或问题，本科生院开通“教学教务咨询服务”平台（通过“同济大学本科生院”微信公众号上线）提供了便捷的咨询服务；现根据平台运行一个多月以来同学们普遍关心的热点问题，制作了 FAQ 常见问题解答，希望能帮助到更多的同学。让我们同心抗疫、共克时艰！',{
        confirmButtonText: '确定'
      })
    }
  }
}
</script>


<style lang="scss" scoped>
.index {
  margin-left: 70px;
  .hello {
    font-size: 20px;
    color: #726f70;
    .icon-xihuan {
      font-size: 30px;
      color: #dd6572;
    }
  }
  .msg {
    .title {
      font-size: 16px;
      color: #000;
      margin-top: 20px;
      margin-left: 10px;
    }
    ul {
      display: flex;
      flex-direction: column;
      width: 400px;
      overflow: hidden;
    }
    li {
      margin-top: 10px;
      font-size: 14px;
      color: lightcoral;
      cursor: pointer;
      display: inline-block;
    }
  }
}
</style>

