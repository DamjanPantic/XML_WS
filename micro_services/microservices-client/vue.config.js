module.exports = {
    devServer: {
        proxy: {
          '/api': {
            target: 'http://localhost:9000', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
            ws: true,
            changeOrigin: true
          }
        },
          public: 'http://localhost:8091'
    
      },

    
    "transpileDependencies": [
      "vuetify"
    ]
  }