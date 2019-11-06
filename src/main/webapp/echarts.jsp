<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
</head>
<body>
<div id="main" style="width: 600px; height: 400px"></div>
</body>
<script type="text/javascript">

    var chart = echarts.init(document.getElementById("main"));
    var option={
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
        xAxis: {
            data: ["衬衫", "羊毛衫","裤子","高跟鞋","帽子","拖鞋"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5,25,35,10,15,5]
        }]
    };
    chart.setOption(option);
</script>
</html>
