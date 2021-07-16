let index = {
  init: function () {
    $("#btn-save").on("click", () => {
      this.save();
    });
    $("#btn-update").on("click", () => {
      this.update();
    });
    // $("#btn-login").on("click", () => {
    //   this.login();
    // });
  },

  // login: function () {
  //   // alert("클릭됨");
  //   let data = {
  //     username: $("#username").val(),
  //     password: $("#password").val(),
  //   };
  //   data = JSON.stringify(data);
  //   axios
  //     .post("/api/user/login", data, {
  //       headers: {
  //         "Content-Type": "application/json; charset=utf-8",
  //       },
  //     })
  //     .then((response) => {
  //       location.href = "/";
  //     });
  // },
  save: function () {
    // alert("클릭됨");
    let data = {
      username: $("#username").val(),
      password: $("#password").val(),
      email: $("#email").val(),
    };
    data = JSON.stringify(data);
    axios
      .post("/auth/joinProc", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        location.href = "/";
      });
  },
  update: function () {
    let data = {
      password: $("#password").val(),
      email: $("#email").val(),
      id: $("#id").val(),
      username: $("#username").val(),
    };
    data = JSON.stringify(data);
    console.log(data);
    axios
      .put("/user", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        alert("회원 수정이 완료되었습니다.");
        location.href = "/";
      });
  },
};
index.init();
