function getChart(balanceData){
	var myChart = echarts.init(document.getElementById('main'));
	var option = {
	    title: {
	        text: '剩余报账金额图表'
	    },
	    legend: {
	        data: ['剩余报账金额（元）']
	    },
	
	    color: ['#3398DB'],
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data : ["专用材料费","差旅费","咨询费","会议费","邮电费","办公费","其他费用"],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	        }
	    ],
	    series: [
	        {
	            name: '剩余报账金额（元）',
	            type: 'bar',
	            barWidth: '40%',
	            data: balanceData,
	        }
	    ]
	};
	myChart.setOption(option);
}