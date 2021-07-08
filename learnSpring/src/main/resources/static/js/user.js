let index = {
  init: function () {
    $("#btn-save").on("click", () => {
      this.save();
    });
    $("#btn-login").on("click", () => {
      this.login();
    });
  },

  login: function () {
    // alert("클릭됨");
    let data = {
      username: $("#username").val(),
      password: $("#password").val(),
    };
    data = JSON.stringify(data);
    axios
      .post("/api/user/login", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        location.href = "/";
      });
  },
  save: function () {
    // alert("클릭됨");
    let data = {
      username: $("#username").val(),
      password: $("#password").val(),
      email: $("#email").val(),
    };
    data = JSON.stringify(data);
    axios
      .post("/api/user", data, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      })
      .then((response) => {
        location.href = "/";
      });
  },
};
index.init();
