<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8"/>
    <title>关键字高亮显示</title>
</head>
<body>
<form action="./textarea.html" method="post">
    <div class="" id="text" name="text" style="word-wrap: break-word; word-break: break-all;">
	   <textarea class="" style="width: 600px;height: 100px">百度（Nasdaq简称：BIDU）是全球最大的中文搜索引擎，2000年1月由李彦宏、徐勇两人创立 于北京中关村，致力于向人们提供“简单，可依赖”的信息获取方式。“百度”二字源于中国宋朝词人辛弃疾的《青玉案·元夕》词句“众里寻他千百度”，象征着百度对中文信息检索技术的执著追求。
	   </textarea>
    </div>
    <input type="submit" name="" value="提交">
</form>
<div class="result" id="textbox">
    <p>百度（Nasdaq简称：BIDU）是全球最大的中文搜索引擎，2000年1月由李彦宏、徐勇两人创立于北京中关村，致力于向人们提供“简单，可依赖”的</p>
    <p>信息获取方式。“百度”二字源于中国宋朝词人辛弃疾的《青玉案·元夕》词句“众里寻他千百度”，象征着百度对中文信息检索技术的执著追求。</p>
</div>
</body>
</html>
<script>
    function highlight(idVal, keyword) {
        var textbox = document.getElementById(idVal);
        if ("" == keyword) return;
        //获取所有文字内容
        var temp = textbox.innerHTML;
        console.log(temp);
        var htmlReg = new RegExp("\<.*?\>", "i");
        var arr = new Array();

        //替换HTML标签
        for (var i = 0; true; i++) {
            //匹配html标签
            var tag = htmlReg.exec(temp);
            if (tag) {
                arr[i] = tag;
            } else {
                break;
            }
            temp = temp.replace(tag, "{[(" + i + ")]}");
        }


        // 讲关键词拆分并入数组
        words = decodeURIComponent(keyword.replace(/\,/g, ' ')).split(/\s+/);

        //替换关键字
        for (w = 0; w < words.length; w++) {
            // 匹配关键词，保留关键词中可以出现的特殊字符
            var r = new RegExp("(" + words[w].replace(/[(){}.+*?^$|\\\[\]]/g, "\\$&") + ")", "ig");
            temp = temp.replace(r, "<b style='color:Red;'>$1</b>");
        }

        //恢复HTML标签
        for (var i = 0; i < arr.length; i++) {
            temp = temp.replace("{[(" + i + ")]}", arr[i]);
        }
        textbox.innerHTML = temp;
    }
    highlight("text", "百度,李彦宏");
</script>