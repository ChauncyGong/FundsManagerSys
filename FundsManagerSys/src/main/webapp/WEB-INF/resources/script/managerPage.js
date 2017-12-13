$(document).ready(function(){
	var balanceData = [];
	var curPage = 1;
	var pageSize = 10;
	var billList;
	var totalPage=1;
	var totalSize;
	var curPageBillList = [];
	$(function(){
		$.ajax({
			url: 'getValidateInfo',
			type: 'GET',
			contenType: "application/json;charset-utf-8",
			dataType: 'text',
			data: {},
			success: function (data) {
				var info = $.parseJSON(data);
				var balance = info.balance;
				balanceData.push(balance.balance_SpeMat);
				balanceData.push(balance.balance_Travel);
				balanceData.push(balance.balance_Inform);
				balanceData.push(balance.balance_Meetting);
				balanceData.push(balance.balance_Post);
				balanceData.push(balance.balance_Office);
				balanceData.push(balance.balance_Other);
				getChart(balanceData);
			}
		});
		$.ajax({
			url: "findAll",
			type: 'GET',
			contenType: "application/json;charset-utf-8",
			dataType: 'text',
			data: {},
			success: function (data) {
				billList = $.parseJSON(data);
				totalSize = billList.length;
				totalPage = totalSize%pageSize==0?totalSize/pageSize:parseInt(totalSize/pageSize)+1;		
				if(totalSize==0){
					totalPage=1;
				}
			}
		});
	});
	
	function getFirstPage(){
		curPageBillList.splice(0,curPageBillList.length);
		if(totalSize==0){
			alert("暂无报账记录");
		}
		if(totalSize>pageSize){
			var last = pageSize;
		}else{
			var last = totalSize;
		}
		for(var i=0;i<last;i++){
			curPageBillList.push(billList[i]);
		}
		getTable(curPageBillList);
	}

	function prePage(){
		if(curPage==1){
			alert("已经是第一页");
			return;
		}
		curPageBillList.splice(0,curPageBillList.length);
		for(var i=(curPage-2)*pageSize;i<(curPage-1)*pageSize;i++){
			curPageBillList.push(billList[i]);
		}
		curPage = curPage - 1;
		getTable(curPageBillList);
	}

	function nextPage(){
		if(curPage==totalPage){
			alert("已经是最后一页");
			return;
		}
		if(curPage<totalPage){
			var last = (curPage+1)*pageSize;
		}else{
			var last = totalSize;
		}
		curPageBillList.splice(0,curPageBillList.length);
		for(var i=curPage*pageSize;i<last;i++){
			curPageBillList.push(billList[i]);
		}
		curPage = curPage+1;
		getTable(curPageBillList);
	}

	function getTable(curPageBillList){
		var table = document.getElementById("table_record");
		var rowNum=table.rows.length;
		for (i=rowNum-1;i>0;i--){
			table.deleteRow(i);
		}
		for ( var i = 0; i < curPageBillList.length; i++){
			var tr = table.insertRow (table.rows.length);
			var bill = curPageBillList[i];
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.submitter.job_Number;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.submitter.name;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_SpeMat;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Travel;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Inform;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Meetting;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Post;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Office;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.cost_Other;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.total_Expenses;
			var td = tr.insertCell (tr.cells.length);
			td.innerText = bill.submit_Time;
		}
		$("#curPage").html(""+curPage);
		$("#totalPage").html(""+totalPage);
	}
	
	function adminOpenMatter(obj){
	    for(var i=1;i<3;i++){
	        if(i==obj){
	            document.getElementById("matter"+i).style.display="block";
	        }else {
	            document.getElementById("matter"+i).style.display="none";
	        }
	    }
	}
	$("#home").click(function(){
		adminOpenMatter(1);
	});
	$("#record").click(function(){
		adminOpenMatter(2);
		getFirstPage();
	});

	$("#page_up").click(function(){
		prePage();
	});
	$("#page_down").click(function(){
		nextPage();
	});
	
});