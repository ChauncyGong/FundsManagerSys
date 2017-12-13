$(document).ready(function(){
	
	$(function(){
		var flag = false;
		var formNotNull = false;
		var job_Number = "" ;
		var curPage = 1;
		var pageSize = 10;
		var billList;
		var totalSize;
		var totalPage;
		var curPageBillList = [];
		var balanceData = [];
		var form_Validate = {
			"speMat_Validate" : 0,
			"travel_Validate" : 0,
			"inform_Validate" : 0,
			"meetting_Validate" : 0,
			"post_Validate" : 0,
			"office_Validate" : 0,
			"other_Validate" : 0
		};
		$.ajax({
			url: 'getValidateInfo',
			type: 'GET',
			contenType: "application/json;charset-utf-8",
			dataType: 'text',
			data: {},
			success: function (data) {
				var info = $.parseJSON(data);
				var user = info.user;
				var advance = info.totalAdvance;
				var balance = info.balance;
				form_Validate.speMat_Validate = user.advance_Amount*(advance.spemat/advance.total+0.1);
				form_Validate.travel_Validate = user.advance_Amount*(advance.travel/advance.total+0.1);
				form_Validate.inform_Validate = user.advance_Amount*(advance.inform/advance.total+0.1);
				form_Validate.meetting_Validate = user.advance_Amount*(advance.meetting/advance.total+0.1);
				form_Validate.post_Validate = user.advance_Amount*(advance.post/advance.total+0.1);
				form_Validate.office_Validate = user.advance_Amount*(advance.office/advance.total+0.1);
				form_Validate.other_Validate = user.advance_Amount*(advance.other/advance.total+0.1);
				balanceData.push(balance.balance_SpeMat);
				balanceData.push(balance.balance_Travel);
				balanceData.push(balance.balance_Inform);
				balanceData.push(balance.balance_Meetting);
				balanceData.push(balance.balance_Post);
				balanceData.push(balance.balance_Office);
				balanceData.push(balance.balance_Other);
				getChart(balanceData);
				job_Number = user.job_Number;
				$.ajax({
					url: "findUserBill/"+job_Number,
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
			}
		});
		
		function check(value){
			var regular = /^([1-9][0-9]{1,4})+(.[0-9]{1,2})?$/;
			if(regular.test(value)){
				return true
			}else{
				return false;
			}
		}
		
		$("#input_cost_speMat").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var speMat = parseFloat(value);
			    	if(speMat>form_Validate.speMat_Validate){
			    		$(this).next().html("专用材料费用已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}
		});
		$("#input_cost_travel").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var travel = parseFloat(value);
			    	if(travel>form_Validate.travel_Validate){
			    		$(this).next().html("差旅费已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}	
		});
		$("#input_cost_inform").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var inform = parseFloat(value);
			    	if(inform>form_Validate.inform_Validate){
			    		$(this).next().html("咨询费已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}	
		});
		$("#input_cost_meeting").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var meetting = parseFloat(value);
			    	if(meetting>form_Validate.meetting_Validate){
			    		$(this).next().html("会议费已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}	
		});
		$("#input_cost_post").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var post = parseFloat(value);
			    	if(post>form_Validate.post_Validate){
			    		$(this).next().html("邮电费已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}	
		});
		$("#input_cost_office").blur(function(){
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var office = parseFloat(value);
			    	if(office>form_Validate.office_Validate){
			    		$(this).next().html("办公费用已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}
		});
		$("#input_cost_other").blur(function(){
			$(this).next().html("");
			$(this).next().html("");
			var value = $(this).val();
			if(value!=""){
				if(check(value)){
					var other = parseFloat(value);
			    	if(other>form_Validate.other_Validate){
			    		$(this).next().html("其他费用已超出可报账范围");
			    		flag = false;
			    	}else{
			    		flag = true;
			    	}
				}else{
					$(this).next().html("输入错误");
					flag = false;
				}
			}	
		});
		
		$("#commit").click(function(){
			$("input[type='text']").each(function(){
		       if($(this).val()!=""){
		    	   formNotNull = true;
		       }
		    });
			if(flag&&formNotNull){
				var options = {
			        success: function(data){
			        	var info = $.parseJSON(data);
			        	if(info.status=="SUCCESS"){
			        		alert("提交成功");
			        		location.reload(true);
			        	}
			        	if(info.status=="LackofbalanceException"){
			        		alert("余额不足");
			        	}
			        	if(info.status=="BudgetOverrunsException"){
			        		alert("预算超支");
			        	}
			        }
			    };
		        $("#billForm").ajaxSubmit(options);
		        $("input[type='text']").each(function(){
		               $(this).val("");
		        });
			}else{
				alert("请正确填写信息");
			}
		});
		
		function getFirstPage(){
			if(totalSize==0){
				alert("暂无报账记录");
			}
			curPageBillList.splice(0,curPageBillList.length);
			if(totalSize>pageSize){
				var last = pageSize;
			}else{
				var last = totalSize;
			}
			for(var i=0;i<last;i++){
				curPageBillList.push(billList[i]);
			}
		}

		function prePage(){
			if(curPage=1){
				alert("已经是第一页");
				return;
			}
			curPageBillList.splice(0,curPageBillList.length);
			for(var i=(curPage-2)*pageSize;i<pageSize;i++){
				curPageBillList.push(billList[i]);
			}
			curPage = curPage - 1;
			getTable();
		}

		function nextPage(){
			if(curPage=totalPage){
				alert("已经是最后一页");
				return;
			}
			if((curPage+1)*pageSize<=totalSize){
				var last = pageSize;
			}else{
				var last = totalSize-(curPage+1)*pageSize;
			}
			curPageBillList.splice(0,curPageBillList.length);
			for(var i=curPage*pageSize;i<last;i++){
				curPageBillList.push(billList[i]);
			}
			curPage = curPage+1;
			getTable();
		}

		function getTable(curPageBillList){
			var table = document.getElementById("table_record");
			var rowNum=table.rows.length;
			for (i=rowNum;i>1;i--){
				table.deleteRow(i);
			}
			for (var i = 0; i < curPageBillList.length; i++){
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
		
		function openMatter(obj){
		    for(var i=1;i<5;i++){
		        if(i==obj){
		            document.getElementById("matter"+i).style.display="block";
		        }else {
		            document.getElementById("matter"+i).style.display="none";
		        }
		    }
		}
		
		$("#home").click(function(){
			openMatter(1);
		});
		$("#record").click(function(){
			openMatter(2);
        	getFirstPage();
        	getTable(curPageBillList);
		});
		$("#form").click(function(){
			openMatter(3);
		});
		$("#update").click(function(){
			openMatter(4);
		});
		
		$("#page_up").click(function(){
			prePage();
		});
		$("#page_down").click(function(){
			nextPage();
		});
		
		$("#input_pwd_renew").blur(function(){
			if($(this).val()!=$("#input_pwd_new").val()){
				$("#span_find_renew").html("*密码不一致");
			}else{
				$("#span_find_renew").html("");
			}
		});
		
		$("#updatePass").click(function(){
			var oldPass = $("#input_pwd_ed").val();
			var newPass = $("#input_pwd_new").val();
			if(oldPass!=""&&$("#input_pwd_new").val()==$("#input_pwd_renew").val()){
				var data = {
						"job_Number":job_Number,
						"oldPass":oldPass,
						"newPass":newPass}
				$.ajax({
					url: 'updatePass',
					type: 'POST',
					contenType: "application/json;charset-utf-8",
					dataType: 'text',
					data: {
						"job_Number":job_Number,
						"oldPassword":oldPass,
						"newPassword":newPass},
					success:function(data){
						alert(data);
		        		location.reload(true);
					}
				});
			}else{
				alert("请输入正确的信息");
			}
		});
	});
});
