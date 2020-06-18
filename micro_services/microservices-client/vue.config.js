module.exports = {
    devServer: {
        proxy: {
          '/api': {
            target: 'http://127.0.0.1:8080', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
            ws: true,
            changeOrigin: true
          }
        },
          public: 'http://127.0.0.1:8090'
    
      },

    
    "transpileDependencies": [
      "vuetify"
    ]
  }