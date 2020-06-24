const fs = require('fs')
var path = require('path');

module.exports = {

  devServer: {
    proxy: {
      '/api': {
        target: 'https://127.0.0.1:8080', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
        ws: true,
        changeOrigin: true,
      },
    },
    https: {
      key: fs.readFileSync('/Users/milutinzeljkovic/localhost+3-key.pem'),
      cert: fs.readFileSync('/Users/milutinzeljkovic/localhost+3.pem'),
    },
    public: 'https://127.0.0.1:8090'

  },


  "transpileDependencies": [
    "vuetify"
  ]
}