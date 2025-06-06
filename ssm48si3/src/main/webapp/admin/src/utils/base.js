const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm48si3/",
            name: "ssm48si3",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm48si3/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "无中介租房系统小程序"
        } 
    }
}
export default base
