const content = document.querySelectorAll(".add_reply");
const btn = document.querySelectorAll(".r_btn-save");
const edit = document.querySelectorAll(".reply_edit");
const editBtn = document.querySelectorAll(".reply_edit_button");
const deleteBtn = document.querySelectorAll(".reply_delete");

btn.forEach((target)=>{
	target.addEventListener('click',(e)=>{
		e.preventDefault();
		this.save(e);
	});
});

edit.forEach((target)=>{
	target.addEventListener('click',(e)=>{
		e.preventDefault();
			count1 = (e.target.parentElement.children[0]);
			count2 = (e.target.parentElement.children[1]);
			count3 = (e.target.parentElement.children[3].children[0]);
			count4 = (e.target.parentElement.children[3].children[1]);
			count1.style.display = "none";
			count2.style.display = "inline";
			count3.style.display = "inline";
			count4.style.display = "inline";
	});
});

editBtn.forEach((target)=>{
	target.addEventListener('click',(e)=>{
		e.preventDefault();
		this.editReply(e);
	});
});

deleteBtn.forEach((target)=>{
	target.addEventListener('click',(e)=>{
		e.preventDefault();
		this.deleteById(e);
	});
});




function save(event){
	let data = {
		content: event.target.parentElement.children[4].value,
		boardId: event.target.parentElement.children[2].value,
		userId: event.target.parentElement.children[3].value
	}
		console.dir(event.target.parentElement.children[2].value);
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/api/reply",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("댓글 작성이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert("실패");
		});
}

function editReply(event) {
		const parent = event.target.parentElement.parentElement.parentElement;
		const id =parent.children[0].value;
		/*alert(id)*/
		let data = {
			content : event.target.parentElement.parentElement.children[3].children[0].value
		}
		/*alert(data.content)*/
		$.ajax({
			type: "PUT",
			url: "/api/reply/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("댓글 수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
}

function deleteById(event) {
		const parent = event.target.parentElement.parentElement;
		const id =parent.children[0].value;

		
		$.ajax({
			type: "DELETE",
			url: "/api/reply/"+id,
			dataType: "json"
		}).done(function(resp){
			alert("댓글 삭제가 완료되었습니다.");
			parent.remove();
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
}
