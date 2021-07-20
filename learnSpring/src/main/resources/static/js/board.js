let index = {
  init: function () {
    $("#btn-board-save").on("click", () => {
      this.save();
    });
    $("#btn-board-update").on("click", () => {
      this.update();
    });
    $("#btn-delete").on("click", () => {
      this.deleteById();
    });
    $("#btn-reply-save").on("click", () => {
      this.replySave();
    });
  },

  save: function () {
    // alert("클릭됨");
    let data = {
      title: $("#title").val(),
      content: $("#content").val(),
    };
    data = JSON.stringify(data);
    axios
      .post("/api/board", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        alert("글쓰기가 완료되었습니다.");
        location.href = "/";
      })
      .catch(() => alert(data));
  },
  deleteById: function () {
    let id = $("#id").text();
    console.log(id);
    axios
      .delete("/api/board/" + id)
      .then((response) => {
        alert("글삭제가 완료되었습니다.");
        location.href = "/";
      })
      .catch(() => alert("문제발생"));
  },
  update: function () {
    let id = $("#id").val();
    let data = {
      title: $("#title").val(),
      content: $("#content").val(),
    };
    data = JSON.stringify(data);
    axios
      .put("/api/board/" + id, data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        alert("글수정이 완료되었습니다.");
        location.href = "/";
      })
      .catch(() => alert(data));
  },
  replySave: function () {
    let boardId = $("#boardId").val();
    let data = {
      userId: $("#userId").val(),
      content: $("#reply-content").val(),
      boardId: boardId,
    };

    data = JSON.stringify(data);
    axios
      .post(`/api/board/${boardId}`, data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        alert("댓글쓰기가 완료되었습니다.");
        location.href = `/board/${boardId}`;
      })
      .catch(() => alert(data));
  },
  replyDelete: function (boardId, replyId) {
    axios
      .delete(`/api/board/${boardId}/reply/${replyId}`, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        alert("댓글삭제가 완료되었습니다.");
        location.href = `/board/${boardId}`;
      });
  },
};
index.init();
