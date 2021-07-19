function getJianjsgBs(){
    var rightJianJinsgQJ = $("#rightJianJinsgQJ").val();
    var rightJianJinsgZJ = $("#rightJianJinsgZJ").val();
    var leftJianJinsgQJ = $("#leftJianJinsgQJ").val();
    var leftJianJinsgZJ = $("#leftJianJinsgZJ").val();
    if (rightJianJinsgQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightJianJinsgQJ").value="";
    }
    if (rightJianJinsgZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightJianJinsgZJ").value="";
    }
    if (leftJianJinsgQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftJianJinsgQJ").value="";
    }
    if (leftJianJinsgZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftJianJinsgZJ").value="";
    }
}
function getZhongYongBs(){
    var rightZhongYongQJ = $("#rightZhongYongQJ").val();
    var rightZhongYongZJ = $("#rightZhongYongZJ").val();
    var leftZhongYongQJ = $("#leftZhongYongQJ").val();
    var leftZhongYongZJ = $("#leftZhongYongZJ").val();
    if (rightZhongYongQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightZhongYongQJ").value="";
    }
    if (rightZhongYongZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightZhongYongZJ").value="";
    }
    if (leftZhongYongQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftZhongYongQJ").value="";
    }
    if (leftZhongYongZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftZhongYongZJ").value="";
    }
}
function getJMSXBs(){
    var rightJiaoMosxQJ = $("#rightJiaoMosxQJ").val();
    var rightJiaoMosxZJ = $("#rightJiaoMosxZJ").val();
    var leftJiaoMosxQJ = $("#leftJiaoMosxQJ").val();
    var leftJiaoMosxZJ = $("#leftJiaoMosxZJ").val();
    if (rightJiaoMosxQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightJiaoMosxQJ").value="";
    }
    if (rightJiaoMosxZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightJiaoMosxZJ").value="";
    }
    if (leftJiaoMosxQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftJiaoMosxQJ").value="";
    }
    if (leftJiaoMosxZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftJiaoMosxZJ").value="";
    }
}
function getSjxlBs(){
    var rightShiJuexlQJ = $("#rightShiJuexlQJ").val();
    var rightShiJuexlZJ = $("#rightShiJuexlZJ").val();
    var leftShiJuexlQJ = $("#leftShiJuexlQJ").val();
    var leftShiJuexlZJ = $("#leftShiJuexlZJ").val();
    if (rightShiJuexlQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightShiJuexlQJ").value="";
    }
    if (rightShiJuexlZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("rightShiJuexlZJ").value="";
    }
    if (leftShiJuexlQJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftShiJuexlQJ").value="";
    }
    if (leftShiJuexlZJ%0.25!=0){
        alert("球镜、柱镜、ADD应为0.25的倍数!");
        document.getElementById("leftShiJuexlZJ").value="";
    }
}
function qingkong() {
    document.getElementById("content").value="";
    document.getElementById("ypName").value="";
}