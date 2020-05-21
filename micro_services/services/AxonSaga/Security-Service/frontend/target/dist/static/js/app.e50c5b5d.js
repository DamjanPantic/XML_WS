(function(e){function t(t){for(var s,o,i=t[0],c=t[1],u=t[2],d=0,p=[];d<i.length;d++)o=i[d],Object.prototype.hasOwnProperty.call(n,o)&&n[o]&&p.push(n[o][0]),n[o]=0;for(s in c)Object.prototype.hasOwnProperty.call(c,s)&&(e[s]=c[s]);l&&l(t);while(p.length)p.shift()();return a.push.apply(a,u||[]),r()}function r(){for(var e,t=0;t<a.length;t++){for(var r=a[t],s=!0,i=1;i<r.length;i++){var c=r[i];0!==n[c]&&(s=!1)}s&&(a.splice(t--,1),e=o(o.s=r[0]))}return e}var s={},n={app:0},a=[];function o(t){if(s[t])return s[t].exports;var r=s[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,o),r.l=!0,r.exports}o.m=e,o.c=s,o.d=function(e,t,r){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(o.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var s in e)o.d(r,s,function(t){return e[t]}.bind(null,s));return r},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],c=i.push.bind(i);i.push=t,i=i.slice();for(var u=0;u<i.length;u++)t(i[u]);var l=c;a.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"4b81":function(e,t,r){"use strict";var s=r("77f5"),n=r.n(s);n.a},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var s=r("2b0e"),n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{attrs:{id:"nav"}},[r("router-link",{attrs:{to:"/user"}},[e._v("User")]),e._v("| "),r("router-link",{attrs:{to:"/login"}},[e._v("Login")]),e._v("| "),r("router-link",{attrs:{to:"/entities"}},[e._v("Entities")]),e._v("| "),r("router-link",{attrs:{to:"/certificates"}},[e._v("Certificates")]),e._v("| ")],1),r("router-view",{attrs:{hellomsg:e.msg}})],1)},a=[],o={name:"app",data:function(){return{msg:"Welcome to your Vue.js powered Spring Boot App"}}},i=o,c=(r("5c0b"),r("2877")),u=Object(c["a"])(i,n,a,!1,null,null,null),l=u.exports,d=(r("45fc"),r("8c4f")),p=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},v=[function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"hello"},[s("img",{attrs:{src:r("bc98")}})])}],f={name:"hello",props:{hellomsg:{type:String,required:!0}}},h=f,m=(r("8570"),Object(c["a"])(h,p,v,!1,null,"2c0c2cfb",null)),g=m.exports,b=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"service"},[r("h1",[e._v(e._s(e.msg))]),r("h2",[e._v("REST service call results")]),r("button",{on:{click:function(t){return e.callHelloApi()}}},[e._v("CALL Spring Boot REST backend service")]),r("h4",[e._v("Backend response: "+e._s(e.backendResponse))])])},_=[],w=r("bc3a"),y=r.n(w),S=y.a.create({baseURL:"/api",timeout:1e3}),N={hello:function(){return S.get("/hello")},getUser:function(e){return S.get("/user/"+e)},createUser:function(e,t){return S.post("/user/"+e+"/"+t)},getSecured:function(e,t){return S.get("/secured/",{auth:{username:e,password:t}})}},R={name:"service",data:function(){return{msg:"HowTo call REST-Services:",backendResponse:[],errors:[]}},methods:{callHelloApi:function(){var e=this;N.hello().then((function(t){e.backendResponse=t.data,console.log(t.data)})).catch((function(t){e.errors.push(t)}))}}},x=R,k=(r("4b81"),Object(c["a"])(x,b,_,!1,null,"f2b27342",null)),C=(k.exports,function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"bootstrap"},[r("h1",[e._v(e._s(e.msg))]),r("h5",[e._v("REST service call are easy to do with Vue.js, if you know how to do it.")]),r("p"),r("h6",[r("b-badge",{attrs:{variant:"primary"}},[e._v(" Let´s go!")]),e._v(" Call a Spring Boot REST backend service, by clicking a button:")],1),r("p"),r("b-btn",{attrs:{variant:"success",id:"btnCallHello"},on:{click:function(t){return e.callHelloApi()}}},[e._v("/hello (GET)")]),r("p"),r("h4",[e._v("Backend response: "),r("b-alert",{attrs:{show:e.showResponse,dismissible:""},on:{dismissed:function(t){e.showResponse=!1}}},[e._v(e._s(e.backendResponse))])],1),r("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse1",modifiers:{collapse1:!0}}]},[e._v("Show Response details")]),r("p"),r("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse1"}},[r("b-card",[r("p",{staticClass:"card-text"},[e._v("The Response hat this details")]),r("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse1_inner",modifiers:{collapse1_inner:!0}}],attrs:{size:"sm",variant:"primary"}},[e._v("HTTP Status")]),r("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse1_inner"}},[r("b-card",[e._v("Status: "+e._s(e.httpStatusCode))]),r("b-card",[e._v("Statustext: "+e._s(e.httpStatusText))])],1),r("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse2_inner",modifiers:{collapse2_inner:!0}}],attrs:{size:"sm",id:"btnHttpHeaders",variant:"warning"}},[e._v("HTTP Headers")]),r("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse2_inner"}},[e.headers&&e.headers.length?r("p"):e._e(),e._l(e.headers,(function(t){return r("li",[r("b-card",[e._v("Header: "+e._s(t.valueOf()))])],1)})),r("p")],2),r("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse3_inner",modifiers:{collapse3_inner:!0}}],attrs:{size:"sm",variant:"danger"}},[e._v("Full Request configuration")]),r("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse3_inner"}},[r("p",{staticClass:"card-text"},[e._v("Config: "+e._s(e.fullResponse.config)+" ")])])],1)],1),r("b-tooltip",{attrs:{target:"btnHttpHeaders",title:"You should always know your HTTP Headers!"}})],1)}),P=[],E={name:"bootstrap",data:function(){return{msg:"Nice Bootstrap candy!",showResponse:!1,backendResponse:"",fullResponse:{config:{foo:"",bar:""}},httpStatusCode:"",httpStatusText:"",headers:["Noting here atm. Did you call the Service?"],errors:[]}},methods:{callHelloApi:function(){var e=this;N.hello().then((function(t){e.backendResponse=t.data,e.httpStatusCode=t.status,e.httpStatusText=t.statusText,e.headers=t.headers,e.fullResponse=t,e.showResponse=!0})).catch((function(t){e.errors.push(t)}))}}},U=E,T=(r("79f9"),Object(c["a"])(U,C,P,!1,null,"55c5f3d0",null)),O=(T.exports,function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"user"},[r("h1",[e._v("Create User")]),r("h3",[e._v("Just some database interaction...")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.firstName,expression:"user.firstName"}],attrs:{type:"text",placeholder:"first name"},domProps:{value:e.user.firstName},on:{input:function(t){t.target.composing||e.$set(e.user,"firstName",t.target.value)}}}),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.lastName,expression:"user.lastName"}],attrs:{type:"text",placeholder:"last name"},domProps:{value:e.user.lastName},on:{input:function(t){t.target.composing||e.$set(e.user,"lastName",t.target.value)}}}),r("button",{on:{click:function(t){return e.createNewUser()}}},[e._v("Create User")]),e.showResponse?r("div",[r("h6",[e._v("User created with Id: "+e._s(e.response))])]):e._e(),e.showResponse?r("button",{on:{click:function(t){return e.retrieveUser()}}},[e._v("Retrieve user "+e._s(e.user.id)+" data from database")]):e._e(),e.showRetrievedUser?r("h4",[e._v("Retrieved User "+e._s(e.retrievedUser.firstName)+" "+e._s(e.retrievedUser.lastName))]):e._e()])}),j=[],A={name:"user",data:function(){return{response:[],errors:[],user:{lastName:"",firstName:"",id:0},showResponse:!1,retrievedUser:{},showRetrievedUser:!1}},methods:{createNewUser:function(){var e=this;N.createUser(this.user.firstName,this.user.lastName).then((function(t){e.response=t.data,e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0})).catch((function(t){e.errors.push(t)}))},retrieveUser:function(){var e=this;N.getUser(this.user.id).then((function(t){e.retrievedUser=t.data,e.showRetrievedUser=!0})).catch((function(t){e.errors.push(t)}))}}},H=A,L=(r("a29c"),Object(c["a"])(H,O,j,!1,null,"1cf4addc",null)),$=L.exports,B=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"unprotected"},[r("h1",[r("b-badge",{attrs:{variant:"info"}},[e._v("Add entity")])],1),r("h5"),r("form",{on:{submit:function(t){return t.preventDefault(),e.callLogin()}}},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user,expression:"user"}],attrs:{type:"text",placeholder:"username"},domProps:{value:e.user},on:{input:function(t){t.target.composing||(e.user=t.target.value)}}}),r("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password",placeholder:"password"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),r("b-btn",{attrs:{variant:"success",type:"submit"}},[e._v("Login")]),e.error?r("p",{staticClass:"error"},[e._v("Bad login information")]):e._e()],1)])},I=[],q={},D=q,F=Object(c["a"])(D,B,I,!1,null,"6bf15c2a",null),M=F.exports,Y=function(){var e=this,t=e.$createElement,r=e._self._c||t;return e.loginError?r("div",{staticClass:"unprotected"},[r("h1",[r("b-badge",{attrs:{variant:"danger"}},[e._v("You don't have rights here, mate :D")])],1),r("h5",[e._v("Seams that you don't have access rights... ")])]):r("div",{staticClass:"unprotected"},[r("h1",[r("b-badge",{attrs:{variant:"info"}},[e._v("Please login to get access!")])],1),r("h5",[e._v("You're not logged in - so you don't see much here. Try to log in:")]),r("form",{on:{submit:function(t){return t.preventDefault(),e.callLogin()}}},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user,expression:"user"}],attrs:{type:"text",placeholder:"username"},domProps:{value:e.user},on:{input:function(t){t.target.composing||(e.user=t.target.value)}}}),r("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password",placeholder:"password"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),r("b-btn",{attrs:{variant:"success",type:"submit"}},[e._v("Login")]),e.error?r("p",{staticClass:"error"},[e._v("Bad login information")]):e._e()],1)])},z=[],J={name:"login",data:function(){return{loginError:!1,user:"",password:"",error:!1,errors:[]}},methods:{callLogin:function(){var e=this;this.errors=[],this.$store.dispatch("login",{user:this.user,password:this.password}).then((function(){e.$router.push("/Protected")})).catch((function(t){e.loginError=!0,e.errors.push(t),e.error=!0}))}}},V=J,G=Object(c["a"])(V,Y,z,!1,null,null,null),W=G.exports,K=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("h1",[r("b-badge",{attrs:{variant:"success"}},[e._v("YEAH you made it!")])],1),r("h5",[e._v("If you're able to read this, you've successfully logged in and redirected to this protected site :)")]),r("b-btn",{attrs:{variant:"primary"},on:{click:function(t){return e.getSecuredTextFromBackend()}}},[e._v("Call the secured API")]),r("p"),e.securedApiCallSuccess?r("div",[r("b-badge",{attrs:{variant:"success"}},[e._v("API call")]),e._v(" Full response: "+e._s(e.backendResponse)+" "),r("b-badge",{attrs:{variant:"success"}},[e._v("successful")])],1):e._e(),e.errors?r("div",[r("b-badge",{attrs:{variant:"warning"}},[e._v("API call")]),e._v(" "+e._s(e.errors)+" "),r("b-badge",{attrs:{variant:"warning"}},[e._v("NOT successful")])],1):e._e()],1)},Q=[],X=(r("d3b7"),r("2f62"));s["default"].use(X["a"]);var Z=new X["a"].Store({state:{loginSuccess:!1,loginError:!1,userName:null,userPass:null},mutations:{login_success:function(e,t){e.loginSuccess=!0,e.userName=t.userName,e.userPass=t.userPass},login_error:function(e,t){e.loginError=!0,e.userName=t.userName}},actions:{login:function(e,t){var r=e.commit,s=t.user,n=t.password;return new Promise((function(e,t){console.log("Accessing backend with user: '"+s),N.getSecured(s,n).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),200==t.status&&(console.log("Login successful"),r("login_success",{userName:s,userPass:n})),e(t)})).catch((function(e){console.log("Error: "+e),r("login_error",{userName:s}),t("Invalid credentials!")}))}))}},getters:{isLoggedIn:function(e){return e.loginSuccess},hasLoginErrored:function(e){return e.loginError},getUserName:function(e){return e.userName},getUserPass:function(e){return e.userPass}}}),ee={name:"protected",data:function(){return{backendResponse:"",securedApiCallSuccess:!1,errors:null}},methods:{getSecuredTextFromBackend:function(){var e=this;N.getSecured(Z.getters.getUserName,Z.getters.getUserPass).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),e.securedApiCallSuccess=!0,e.backendResponse=t.data})).catch((function(t){console.log("Error: "+t),e.errors=t}))}}},te=ee,re=Object(c["a"])(te,K,Q,!1,null,null,null),se=re.exports;s["default"].use(d["a"]);var ne=new d["a"]({mode:"history",routes:[{path:"/",component:g},{path:"/user",component:$},{path:"/login",component:W},{path:"/entities",component:M},{path:"/protected",component:se,meta:{requiresAuth:!0}},{path:"*",redirect:"/"}]});ne.beforeEach((function(e,t,r){e.matched.some((function(e){return e.meta.requiresAuth}))?Z.getters.isLoggedIn?r():r({path:"/login"}):r()}));var ae=ne,oe=r("5f5b");r("f9e3"),r("2dd8");s["default"].config.productionTip=!1,s["default"].use(oe["a"]),new s["default"]({router:ae,store:Z,render:function(e){return e(l)}}).$mount("#app")},"5c0b":function(e,t,r){"use strict";var s=r("9c0c"),n=r.n(s);n.a},"6bd6":function(e,t,r){},"77f5":function(e,t,r){},"79f9":function(e,t,r){"use strict";var s=r("6bd6"),n=r.n(s);n.a},8570:function(e,t,r){"use strict";var s=r("8739"),n=r.n(s);n.a},8739:function(e,t,r){},"9c0c":function(e,t,r){},a29c:function(e,t,r){"use strict";var s=r("d7f2"),n=r.n(s);n.a},bc98:function(e,t,r){e.exports=r.p+"static/img/cert.6264bb14.png"},d7f2:function(e,t,r){}});
//# sourceMappingURL=app.e50c5b5d.js.map