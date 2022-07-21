const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    // 指定项目启动时的默认端口号
    port: 8002
  }
})
