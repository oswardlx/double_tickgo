function index() {
    var Request = new UrlSearch();
    var mount = Request.mount;
    $.ajax({
        type: "GET",
        async: "false",
        dataType: "json",
        url: location.origin +'/jfinal/get_smallball_analy?mount=' + mount,
        success: function (data) {
            console.log(data);
            if (data.success) {
                var trs = "";
                var list = data.list;
                for (var key in list) {
                    trs += '<tr>' +
                        '<td>' + key + '</td>' +
                        '<td>' + list[key] + '</td>' +
                        '</tr>';

                }
                $("#tb1")[0].innerHTML=trs;
                checkUpload();
            }
        }
    })
}

function checkUpload() {
    var Request = new UrlSearch();
    var mount = Request.mount;
    $.ajax({
        type: "GET",
        async: "false",
        dataType: "json",
        url: location.origin + '/jfinal/get_ball_list?mount=' + mount,
        success: function (data) {
            if (data.success) {
                var trs = "";
                var list = data.list;
                for (var key  in list) {
                    trs += '<tr>' +
                        '<td>' + key + '</td>' +
                        '<td>' + list[key] + '</td>' +
                        '</tr>';
                }
                $("#tb2")[0].innerHTML=trs;
            }
        }
    })
}

function UrlSearch() {
    var name, value;
    var str = location.href; //取得整个地址栏
    var num = str.indexOf("?")
    str = str.substr(num + 1); //取得所有参数   stringvar.substr(start [, length ]

    var arr = str.split("&"); //各个参数放到数组里
    for (var i = 0; i < arr.length; i++) {
        num = arr[i].indexOf("=");
        if (num > 0) {
            name = arr[i].substring(0, num);
            value = arr[i].substr(num + 1);
            this[name] = value;
        }
    }
}